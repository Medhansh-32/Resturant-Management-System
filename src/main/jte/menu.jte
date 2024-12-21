@import com.marktech.foodApp.model.FoodItem
@import java.util.List
@param List<FoodItem> menu
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/styleMenu.css">
    <title>Menu</title>

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
                    <div style="display: flex;justify-content: space-between;align-items: center;">
                        <div class="price">₹${item.getPrice()}</div>
                    <button onclick="addToCart('${item.getName()}', ${item.getPrice()})">Add to Plate</button>
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
<script src="/js/menuScript.js"></script>
</body>
</html>
