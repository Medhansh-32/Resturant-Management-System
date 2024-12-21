
let cart = [];


function addToCart(name, price) {

    const existingItem = cart.find(item => item.name === name);

    if (existingItem) {

        existingItem.quantity += 1;
    } else {

        cart.push({ name, price, quantity: 1 });
    }


    updateCartUI();
}


function removeFromCart(index) {
    const item = cart[index];

    if (item.quantity > 1) {
        item.quantity -= 1;
    } else {
        cart.splice(index, 1);
    }

    // Update the cart UI
    updateCartUI();
}


function updateCartUI() {
    const cartItemsContainer = document.getElementById('cart-items');
    const totalPriceContainer = document.getElementById('total-price');


    cartItemsContainer.innerHTML = '';


    let totalPrice = 0;
    cart.forEach((item, index) => {
        const cartItem = document.createElement('div');
        cartItem.classList.add('cart-item');

        const itemTotalPrice = item.price * item.quantity;
        totalPrice += itemTotalPrice;

        cartItem.innerHTML = `
            <p>${item.name} x ${item.quantity}</p>
            <p>Price: ₹${itemTotalPrice}</p>
            <button onclick="removeFromCart(${index})">Remove</button>
        `;

        cartItemsContainer.appendChild(cartItem);
    });

    totalPriceContainer.innerHTML = `Total: ₹${totalPrice}`;
}
async  function placeOrder() {
    // Get the user's details from the input fields
    const customerName = document.getElementById('name').value;
    const customerEmail = document.getElementById('email').value;
    const customerPhone = document.getElementById('phoneNumber').value;

    if (!customerName || !customerEmail || !customerPhone) {
        alert("Please fill in all your details!");
        return;
    }

    const orderData = {
        customer: {
            name: customerName,
            email: customerEmail,
            phoneNumber: customerPhone
        },
        foodItems: []
    };


    cart.forEach(item => {

        for (let i = 0; i < item.quantity; i++) {
            orderData.foodItems.push({ name: item.name });
        }
    });


    try {
        const response = await fetch("order/newOrder", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(orderData)
        });

        if (response.ok) {
            const data = await response.json();
            console.log('Order placed successfully:', data);
            alert("Your order has been placed successfully!");

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