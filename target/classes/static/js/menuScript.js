
let cart = [];


function addToCart(name, price) {
    const addToCartButtons = document.querySelectorAll('#add-to-cart');
    const clickedButton = Array.from(addToCartButtons).find(button =>
        button.getAttribute('onclick') === `addToCart('${name}', ${price})`
    );
    const existingItem = cart.find(item => item.name === name);

    if (existingItem) {
        existingItem.quantity += 1;
    } else {

        cart.push({ name, price, quantity: 1 });
    }

    if (clickedButton) {
        clickedButton.innerText = "Item Added";
        setTimeout(() => {
            clickedButton.innerText = "Add to Plate";
        }, 1000);
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
            <p> &nbsp;&nbsp;: ₹${itemTotalPrice}&nbsp;&nbsp;</p>
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
    const placeOrder = document.getElementById("place-order");
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

placeOrder.innerText="Placing Order....";
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
            placeOrder.innerText="Order Placed Successfully";
            setTimeout(()=>{
                placeOrder.innerText="Place Order";
            },1000)

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


document.addEventListener('DOMContentLoaded', function() {
    const cartToggle = document.getElementById('cartToggle');
    const cartContainer = document.querySelector('.cart-container');
    const cartOverlay = document.getElementById('cartOverlay');
    const mobileCartTotal = document.getElementById('mobileCartTotal');
    const menuContainer=document.getElementById("menu");

    function toggleCart() {
        cartContainer.classList.toggle('show');
        cartOverlay.classList.toggle('show');

        // Update button text
        const buttonText = cartToggle.querySelector('span');
        if (cartContainer.classList.contains('show')) {
            buttonText.textContent = 'Hide Cart';
            document.body.classList.add('cart-open');
            cartContainer.style.overflowY="block"
        } else {
            buttonText.textContent = 'View Cart';
            document.body.classList.remove('cart-open');
            cartContainer.style.overflowY="scroll"

        }
    }

    cartToggle.addEventListener('click', toggleCart);
    cartOverlay.addEventListener('click', toggleCart);

    // Modify your existing updateCartUI function to update mobile total
    const originalUpdateCartUI = updateCartUI;
    updateCartUI = function() {
        originalUpdateCartUI();

        // Update mobile cart total
        let totalPrice = 0;
        cart.forEach(item => {
            totalPrice += item.price * item.quantity;
        });
        mobileCartTotal.textContent = `(₹${totalPrice})`;
    }

    // Optional: Close cart when scrolling down
    let lastScrollTop = 0;
    window.addEventListener('scroll', () => {
        if (window.innerWidth <= 768) {
            const st = window.pageYOffset || document.documentElement.scrollTop;
            if (st > lastScrollTop && cartContainer.classList.contains('show')) {
                toggleCart();
            }
            lastScrollTop = st <= 0 ? 0 : st;
        }
    });
});