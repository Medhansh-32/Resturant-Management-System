@import com.marktech.foodApp.model.FoodItem
@import java.util.List
@param List<FoodItem> menu
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />



    <title>Menu</title>
    <style>
        /* Styling for the "Add to Cart" button */
        /* Modern CSS Reset and Base Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            transition: all 0.3s ease-in-out;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            gap: 30px;
        }

        /* Menu Container Styling */
        .menu-container {
            width: 70%;
            padding: 30px;
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);
        }

        h1 {
            text-align: center;
            color: #2d3436;
            font-size: 2.8em;
            margin-bottom: 40px;
            position: relative;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        h1:after {
            content: '';
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
            width: 100px;
            height: 4px;
            background: linear-gradient(90deg, #ff7f50, #ff4757);
            border-radius: 2px;
        }

        /* Menu List Grid */
        .menu-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 30px;
            padding: 20px;
        }

        /* Menu Item Card */
        .menu-item {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.08);
            overflow: hidden;
            transform-origin: center;
            transition: transform 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        }

        .menu-item:hover {
            transform: translateY(-10px) scale(1.02);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.12);
        }

        .menu-item img {
            width: 100%;
            height: 220px;
            object-fit: cover;
            transform: scale(1);
            transition: transform 0.4s ease;
        }

        .menu-item:hover img {
            transform: scale(1.1);
        }

        .menu-item-content {
            padding: 20px;
        }

        .menu-item h3 {
            font-size: 1.4em;
            color: #2d3436;
            margin-bottom: 10px;
            font-weight: 600;
        }

        .menu-item p {
            color: #636e72;
            line-height: 1.6;
            margin-bottom: 20px;
        }

        .price {
            font-size: 1.8em;
            font-weight: 700;
            color: #ff6b6b;
            text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.1);
        }

        /* Button Styling */
        button {
            background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 1rem;
            font-weight: 600;
            border-radius: 50px;
            cursor: pointer;
            box-shadow: 0 4px 15px rgba(255, 107, 107, 0.3);
            transition: all 0.3s ease;
        }

        button:hover {
            background: linear-gradient(45deg, #ff5252, #ff7675);
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(255, 107, 107, 0.4);
        }

        button:active {
            transform: translateY(1px);
        }

        /* Cart Container */
        .cart-container {
            width: 28%;
            padding: 25px;
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);
            position: sticky;
            top: 20px;
            max-height: calc(100vh - 40px);
            overflow-y: auto;
        }

        .cart-container h2 {
            font-size: 2em;
            color: #2d3436;
            text-align: center;
            margin-bottom: 25px;
            position: relative;
            margin-top: 20px;
        }

        .cart-container h2:after {
            content: '';
            position: absolute;
            bottom: -8px;
            left: 50%;
            transform: translateX(-50%);
            width: 60px;
            height: 3px;
            background: linear-gradient(90deg, #ff6b6b, #ff8e8e);
            border-radius: 2px;
        }

        /* Cart Items */
        .cart-items {
            max-height: 400px;
            overflow-y: auto;
            padding: 10px;
            margin-bottom: 20px;
        }

        .cart-item {
            background: white;
            padding: 15px;
            border-radius: 12px;
            margin-bottom: 15px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .cart-item p {
            margin: 0;
            color: #2d3436;
            font-weight: 500;
        }

        .cart-item button {
            padding: 8px 16px;
            font-size: 0.9rem;
            background: linear-gradient(45deg, #ff4757, #ff6b6b);
        }

        .total-price {
            font-size: 1.8em;
            font-weight: 700;
            text-align: center;
            color: #2d3436;
            margin: 20px 0;
            padding: 15px;
            border-radius: 12px;
            background: linear-gradient(135deg, #f6f9fc 0%, #f1f5f9 100%);
        }

        /* User Details Form */
        .user-details {
            background: white;
            padding: 25px;
            border-radius: 15px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
        }

        .user-details h2 {
            font-size: 1.6em;
            margin-bottom: 20px;
        }

        .user-details label {
            font-size: 1rem;
            color: #2d3436;
            font-weight: 500;
            margin-bottom: 8px;
            display: block;
        }

        .user-details input {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e9ecef;
            border-radius: 10px;
            font-size: 1rem;
            margin-bottom: 15px;
            transition: all 0.3s ease;
        }

        .user-details input:focus {
            border-color: #ff6b6b;
            box-shadow: 0 0 0 4px rgba(255, 107, 107, 0.1);
            outline: none;
        }

        .user-details button {
            width: 100%;
            padding: 15px;
            font-size: 1.1rem;
            margin-top: 10px;
            background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
        }

        /* Responsive Design */
        @media (max-width: 1200px) {
            body {
                flex-direction: column;
            }

            .menu-container, .cart-container {
                width: 100%;
            }

            .cart-container {
                position: relative;
                top: 0;
                margin-top: 30px;
            }
        }

        @media (max-width: 768px) {
            body {
                padding: 10px;
            }

            .menu-list {
                grid-template-columns: 1fr;
            }

            h1 {
                font-size: 2em;
            }

            .menu-item-content {
                padding: 15px;
            }
        }

        /* Custom Scrollbar */
        ::-webkit-scrollbar {
            width: 8px;
        }

        ::-webkit-scrollbar-track {
            background: #f1f1f1;
            border-radius: 4px;
        }

        ::-webkit-scrollbar-thumb {
            background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
            border-radius: 4px;
        }

        ::-webkit-scrollbar-thumb:hover {
            background: linear-gradient(45deg, #ff5252, #ff7675);
        }
    </style>
</head>
<body>

<div class="menu-container">
    <h1>MarkFood Restaurant's Menu <i class="fa-solid fa-utensils"></i></h1>
    <hr>
    <ul class="menu-list">
        @for(FoodItem item : menu) <!-- Loop over the menu list -->
            <li class="menu-item">
                <img src="${item.getImages()}" alt="@foodItem.name">
                <div class="menu-item-content">
                    <h3>${item.getName()}</h3>
                    <p>${item.getDescription()}</p>
                    <div style="display: flex;justify-content: space-between;align-items: center;j">
                        <div class="price">₹${item.getPrice()}</div>
                    <button onclick="addToCart('${item.getName()}', ${item.getPrice()})">Add to cart</button>
                    </div>

                </div>
            </li>
        @endfor
    </ul>
</div>

<!-- Cart Sidebar -->
<div class="cart-container">
    <h2>Your Cart</h2>
    <br>
    <hr style="width: 100%">
    <div class="cart-items" id="cart-items">
        <!-- Cart items will appear here -->
    </div>
    <div class="total-price" id="total-price">
        Total: ₹0
    </div>

    <!-- User details input -->
    <div class="user-details">
        <h2>Your Details</h2>
        <label for="name">Name:</label>
        <input type="text" id="name" placeholder="Enter your name" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" placeholder="Enter your email" required>
        <br>
        <label for="phoneNumber">Phone Number:</label>
        <input type="tel" id="phoneNumber" placeholder="Enter your phone number" required>
        <br>
        <button onclick="placeOrder()">Place Order</button>
    </div>
</div>

@raw
<script>

    let cart = [];

    // Function to add items to the cart
    function addToCart(name, price) {
        // Find if the item is already in the cart
        const existingItem = cart.find(item => item.name === name);

        if (existingItem) {
            // If the item is already in the cart, just increase the quantity
            existingItem.quantity += 1;
        } else {
            // If the item is not in the cart, add it with quantity 1
            cart.push({ name, price, quantity: 1 });
        }

        // Update the cart UI
        updateCartUI();
    }

    // Function to remove items from the cart (decrease quantity or remove item)
    function removeFromCart(index) {
        const item = cart[index];

        if (item.quantity > 1) {
            // Decrease the quantity by 1 if quantity is greater than 1
            item.quantity -= 1;
        } else {
            // If quantity is 1, remove the item completely
            cart.splice(index, 1);
        }

        // Update the cart UI
        updateCartUI();
    }

    // Function to update the cart UI
    function updateCartUI() {
        const cartItemsContainer = document.getElementById('cart-items');
        const totalPriceContainer = document.getElementById('total-price');

        // Clear the current cart items in the UI
        cartItemsContainer.innerHTML = '';

        // Iterate over the cart items and display them
        let totalPrice = 0;
        cart.forEach((item, index) => {
            const cartItem = document.createElement('div');
            cartItem.classList.add('cart-item');

            // Calculate the total price for the item (price * quantity)
            const itemTotalPrice = item.price * item.quantity;
            totalPrice += itemTotalPrice;

            // Render item name, quantity, and total price for that item
            cartItem.innerHTML = `
            <p>${item.name} x ${item.quantity}</p>
            <p>Price: ₹${itemTotalPrice}</p>
            <button onclick="removeFromCart(${index})">Remove</button>
        `;

            // Append the item to the cart items container
            cartItemsContainer.appendChild(cartItem);
        });

        // Update the total price
        totalPriceContainer.innerHTML = `Total: ₹${totalPrice}`;
    }
 async  function placeOrder() {
        // Get the user's details from the input fields
        const customerName = document.getElementById('name').value;
        const customerEmail = document.getElementById('email').value;
        const customerPhone = document.getElementById('phoneNumber').value;

        // Make sure that all fields are filled before placing the order
        if (!customerName || !customerEmail || !customerPhone) {
            alert("Please fill in all your details!");
            return;
        }

        // Prepare the order data with food items repeated according to quantity
        const orderData = {
            customer: {
                name: customerName,
                email: customerEmail,
                phoneNumber: customerPhone
            },
            foodItems: []
        };

        // Loop over the cart and add food items to the foodItems array
        cart.forEach(item => {
            // Push the item into the foodItems array `item.quantity` times
            for (let i = 0; i < item.quantity; i++) {
                orderData.foodItems.push({ name: item.name });
            }
        });

        // Making the POST request to the newOrder API
        try {
            const response = await fetch("http://localhost:8080/order/newOrder", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(orderData)
            });

            if (response.ok) {  // Check if response status is 200-299
                const data = await response.json(); // Parse the JSON response
                console.log('Order placed successfully:', data);
                alert("Your order has been placed successfully!");

                // Clear the cart after order is placed
                cart = [];
                updateCartUI();
            } else {
                alert("Error placing order. Please try again.");
            }
        } catch (error) {
            console.error('Error placing order:', error);
            alert("Error placing order. Please try again.");
        }
    }
</script>
@endraw
</body>
</html>
