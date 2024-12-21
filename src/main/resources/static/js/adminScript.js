
const socket = new WebSocket('wss://cheflink.onrender.com/ws/orders');
const orders = new Map();


const style = document.createElement('style');
style.textContent = `
    .order-card {
        animation: slide-in 0.5s ease-out;
        transition: transform 0.5s ease-out, opacity 0.5s ease-out;
    }

    @keyframes slide-in {
        from {
            transform: translateX(-100%);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }

    .order-card.removing {
        animation: slide-out 0.5s ease-out;
        transform: translateX(100%);
        opacity: 0;
    }

    @keyframes slide-out {
        from {
            transform: translateX(0);
            opacity: 1;
        }
        to {
            transform: translateX(100%);
            opacity: 0;
        }
    }
`;
document.head.appendChild(style);

// Fetch orders from the database
async function fetchOrders() {
    try {
        const response = await fetch("order/allOrders");
        if (response.ok) {
            const data = await response.json();
            data.forEach(order => {
                orders.set(order.id, order);
            });
            renderOrders();
        } else {
            console.error("Failed to fetch orders:", response.statusText);
        }
    } catch (error) {
        console.error("Error fetching orders:", error);
    }
}

// WebSocket event handlers
socket.onopen = () => {
    console.log('Connected to order updates');
    fetchOrders();
};

socket.onmessage = (event) => {
    console.log("json:" + event.data);
    const order = JSON.parse(event.data);
    orders.set(order.id, order);
    renderOrders();
};

socket.onerror = (error) => {
    console.error('WebSocket error:', error);
};

// Format date to readable string
function formatDateTime(dateArray) {
    // Handle the milliseconds correctly by dividing the nanoseconds by 1000000
    const milliseconds = Math.floor(dateArray[6] / 1000000);

    // Create a date object using the array values
    const date = new Date(
        dateArray[0],          // year
        dateArray[1] - 1,      // month (0-based)
        dateArray[2],          // day
        dateArray[3],          // hour
        dateArray[4],          // minute
        dateArray[5],          // second
        milliseconds           // milliseconds
    );

    // Format the date using Intl.DateTimeFormat
    const formatter = new Intl.DateTimeFormat('en-IN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        hour12: true,
        timeZone: 'Asia/Kolkata' // This ensures IST timezone
    });

    return formatter.format(date);
}

function renderOrders() {
    const container = document.getElementById('orders-container');
    const existingCards = new Set(Array.from(container.children).map(card => card.getAttribute('data-id')));

    const sortedOrders = Array.from(orders.values())
        .sort((b,a) => new Date(a.id) - new Date(b.id)); // Sort in ascending order

    sortedOrders.forEach(order => {
        const orderId = order.id.toString();
        const existingCard = container.querySelector(`[data-id="${orderId}"]`);

        if (!existingCard) {
            const orderCard = createOrderCard(order);
            if (container.firstChild) {
                container.insertBefore(orderCard, container.firstChild);
            } else {
                container.appendChild(orderCard);
            }
        }
        existingCards.delete(orderId);
    });


    existingCards.forEach(cardId => {
        const cardToRemove = container.querySelector(`[data-id="${cardId}"]`);
        if (cardToRemove) {
            cardToRemove.remove();
        }
    });
}

async function deleteOrder(orderId) {
    try {
        const orderCard = document.querySelector(`.order-card[data-id="${orderId}"]`);
        if (!orderCard) return;

        orderCard.classList.add('removing');

        // Wait for animation to complete before making the API call
        await new Promise(resolve => setTimeout(resolve, 500));

        const response = await fetch(`order/deleteOrder?orderId=${orderId}`, {
            method: 'DELETE',
        });

        if (response.ok) {
            orders.delete(orderId);
            if (orderCard.parentNode) {
                orderCard.parentNode.removeChild(orderCard);
            }
        } else {
            // If deletion fails, remove the animation class
            orderCard.classList.remove('removing');
            console.error('Failed to delete order:', response.status, response.statusText);
        }
    } catch (error) {
        console.error('Error occurred while deleting order:', error);
    }
}

// Create order card element (rest of the function remains the same)
function createOrderCard(order) {
    const card = document.createElement('div');
    card.className = 'order-card';
    card.setAttribute('data-id', order.id);

    const itemMap = new Map();
    order.foodItems.forEach(item => {
        if (itemMap.has(item.name)) {
            const existing = itemMap.get(item.name);
            itemMap.set(item.name, {
                price: existing.price + item.price,
                count: existing.count + 1
            });
        } else {
            itemMap.set(item.name, { price: item.price, count: 1 });
        }
    });

    card.innerHTML = `
        <div class="order-header">
            <span class="order-id">Order #${order.id}</span>
        </div>
        <div class="order-time">${formatDateTime(order.orderDateTime)}</div>
        <div class="customer-info">
            <h3>${order.customer.name}</h3>
            <p>${order.customer.email}</p>
            <p>${order.customer.phoneNumber}</p>
        </div>
        <div class="order-items">
            ${Array.from(itemMap.entries()).map(([name, details]) => `
                <div class="order-item">
                    <span>${name} x ${details.count}</span>
                    <span>₹${details.price}</span>
                </div>
            `).join('')}
        </div>
        <div class="total-price">Total: ₹${order.totalPrice}</div>
        <button class="delete-order-btn" onclick="deleteOrder(${order.id})">Order Completed</button>
    `;

    return card;
}

