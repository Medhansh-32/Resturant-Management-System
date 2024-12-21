
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