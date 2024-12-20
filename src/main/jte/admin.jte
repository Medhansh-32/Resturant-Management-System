<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MarkFood Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Inter', sans-serif;
        }

        body {
            background: #f0f2f5;
            min-height: 100vh;
            padding: 20px;
        }

        .dashboard {
            max-width: 1400px;
            margin: 0 auto;
        }

        .header {
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            color: #1a1a1a;
            font-size: 1.8rem;
        }

        .status-counts {
            display: flex;
            gap: 15px;
        }

        .status-card {
            background: white;
            padding: 15px 25px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }

        .status-card h3 {
            color: #666;
            font-size: 0.9rem;
            margin-bottom: 5px;
        }

        .status-card .count {
            font-size: 1.5rem;
            font-weight: 600;
            color: #1a1a1a;
        }

        .orders-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .order-card {
            background: white;
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            transition: transform 0.2s;
        }

        .order-card:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .order-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }

        .order-id {
            font-weight: 600;
            color: #1a1a1a;
        }

        .order-time {
            color: #666;
            font-size: 0.9rem;
        }

        .customer-info {
            margin-bottom: 15px;
            padding-bottom: 15px;
            border-bottom: 1px solid #eee;
        }

        .customer-info h3 {
            font-size: 1rem;
            color: #1a1a1a;
            margin-bottom: 5px;
        }

        .customer-info p {
            color: #666;
            font-size: 0.9rem;
        }

        .order-items {
            margin-bottom: 15px;
        }

        .order-item {
            display: flex;
            justify-content: space-between;
            margin-bottom: 5px;
            font-size: 0.9rem;
            color: #444;
        }

        .total-price {
            font-weight: 600;
            color: #1a1a1a;
            text-align: right;
            margin-bottom: 15px;
            font-size: 1.1rem;
        }

        .status-controls {
            display: flex;
            gap: 10px;
        }

        .status-btn {
            flex: 1;
            padding: 8px;
            border: none;
            border-radius: 6px;
            font-weight: 500;
            cursor: pointer;
            transition: all 0.2s;
        }

        .status-btn:hover {
            opacity: 0.9;
        }

        .status-new {
            background: #e3f2fd;
            color: #1976d2;
        }

        .status-processing {
            background: #fff3e0;
            color: #f57c00;
        }

        .status-completed {
            background: #e8f5e9;
            color: #388e3c;
        }

        .status-cancelled {
            background: #ffebee;
            color: #d32f2f;
        }

        @media (max-width: 768px) {
            .status-counts {
                flex-wrap: wrap;
            }

            .status-card {
                flex: 1 1 calc(50% - 10px);
            }

            .orders-container {
                grid-template-columns: 1fr;
            }
        }

        .order-status {
            padding: 4px 8px;
            border-radius: 4px;
            font-size: 0.8rem;
            font-weight: 500;
        }

        .status-label-new {
            background: #e3f2fd;
            color: #1976d2;
        }

        .status-label-processing {
            background: #fff3e0;
            color: #f57c00;
        }

        .status-label-completed {
            background: #e8f5e9;
            color: #388e3c;
        }

        .status-label-cancelled {
            background: #ffebee;
            color: #d32f2f;
        }
    </style>
</head>
<body>
<div class="dashboard">
    <div class="header">
        <h1>Order Management Dashboard</h1>
        <div class="status-counts">
            <div class="status-card">
                <h3>New Orders</h3>
                <div class="count" id="new-count">0</div>
            </div>
            <div class="status-card">
                <h3>Processing</h3>
                <div class="count" id="processing-count">0</div>
            </div>
            <div class="status-card">
                <h3>Completed</h3>
                <div class="count" id="completed-count">0</div>
            </div>
            <div class="status-card">
                <h3>Cancelled</h3>
                <div class="count" id="cancelled-count">0</div>
            </div>
        </div>
    </div>

    <div class="orders-container" id="orders-container">
        <!-- Orders will be dynamically inserted here -->
    </div>
</div>
@raw
<script>
    // WebSocket connection
    const socket = new WebSocket('ws://localhost:8080/ws/orders');
    const orders = new Map();

    // WebSocket event handlers
    socket.onopen = () => {
        console.log('Connected to order updates');
    };

    socket.onmessage = (event) => {
        const order = JSON.parse(event.data);
        updateOrder(order);
    };

    socket.onerror = (error) => {
        console.error('WebSocket error:', error);
    };

    // Update or add new order
    function updateOrder(order) {
        orders.set(order.id, order);
        updateDashboard();
    }

    // Format date to readable string
    function formatDateTime(dateArray) {
        const date = new Date(Date.UTC(
            dateArray[0], // Year
            dateArray[1] - 1, // Month (0-indexed)
            dateArray[2], // Day
            dateArray[3], // Hour
            dateArray[4], // Minute
            dateArray[5], // Second
            dateArray[6] // Millisecond
        ));
        return date.toLocaleString();
    }

    // Get status label class
    function getStatusLabelClass(status) {
        return `status-label-${status.toLowerCase()}`;
    }

    // Update the entire dashboard
    function updateDashboard() {
        updateStatusCounts();
        renderOrders();
    }

    // Update status count cards
    function updateStatusCounts() {
        const counts = {
            NEW: 0,
            PROCESSING: 0,
            COMPLETED: 0,
            CANCELLED: 0
        };

        orders.forEach(order => {
            counts[order.status]++;
        });

        document.getElementById('new-count').textContent = counts.NEW;
        document.getElementById('processing-count').textContent = counts.PROCESSING;
        document.getElementById('completed-count').textContent = counts.COMPLETED;
        document.getElementById('cancelled-count').textContent = counts.CANCELLED;
    }

    // Render all orders
    function renderOrders() {
        const container = document.getElementById('orders-container');
        container.innerHTML = '';

        const sortedOrders = Array.from(orders.values())
            .sort((a, b) => new Date(b.orderDateTime) - new Date(a.orderDateTime));

        sortedOrders.forEach(order => {
            const orderCard = createOrderCard(order);
            container.appendChild(orderCard);
        });
    }

    // Create order card element
    function createOrderCard(order) {

        const card = document.createElement('div');
        card.className = 'order-card';
        card.innerHTML = `
            <div class="order-header">
                <span class="order-id">Order #${order.id}</span>
                <span class="order-status ${getStatusLabelClass(order.status)}">${order.status}</span>
            </div>
        <div class="order-time">${formatDateTime(order.orderDateTime)}</div>
        <div class="customer-info">
            <h3>${order.customer.name}</h3>
            <p>${order.customer.email}</p>
            <p>${order.customer.phoneNumber}</p>
        </div>
        <div class="order-items">
            ${order.foodItems.map(item => `
                        <div class="order-item">
                            <span>${item.name}</span>
                            <span>₹${item.price}</span>
                        </div>
                    `).join('')}
        </div>
        <div class="total-price">Total: ₹${order.totalPrice}</div>
        <div class="status-controls">
            ${getStatusButtons(order)}
        </div>
        `;

        return card;
    }

    // Generate status update buttons based on current status
    function getStatusButtons(order) {
        const currentStatus = order.status;
        let buttons = '';

        switch (currentStatus) {
            case 'NEW':
                buttons = `
                    <button class="status-btn status-processing" onclick="updateOrderStatus(${order.id}, 'PROCESSING')">
                        Start Processing
                    </button>
                <button class="status-btn status-cancelled" onclick="updateOrderStatus(${order.id}, 'CANCELLED')">
                    Cancel
                </button>
                `;
                break;
            case 'PROCESSING':
                buttons = `
                    <button class="status-btn status-completed" onclick="updateOrderStatus(${order.id}, 'COMPLETED')">
                        Complete
                    </button>
                <button class="status-btn status-cancelled" onclick="updateOrderStatus(${order.id}, 'CANCELLED')">
                    Cancel
                </button>
                `;
                break;
        }

        return buttons;
    }

    // Send status update to server
    function updateOrderStatus(orderId, newStatus) {
        socket.send(JSON.stringify({
            orderId: orderId,
            status: newStatus
        }));
    }
</script>
@endraw
</body>
</html>