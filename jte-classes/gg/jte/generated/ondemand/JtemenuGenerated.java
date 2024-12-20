package gg.jte.generated.ondemand;
import com.marktech.foodApp.model.FoodItem;
import java.util.List;
public final class JtemenuGenerated {
	public static final String JTE_NAME = "menu.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,14,14,15,35,67,75,126,150,185,227,272,307,333,333,333,335,335,335,335,335,335,335,335,335,337,337,337,338,338,338,340,340,340,341,341,341,341,341,341,341,341,346,346,350,356,362,378,505,508,508,508,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<FoodItem> menu) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css\" integrity=\"sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n\r\n\r\n\r\n    <title>Menu</title>\r\n    <style>\r\n        ");
		jteOutput.writeContent("\r\n        ");
		jteOutput.writeContent("\r\n        * {\r\n            margin: 0;\r\n            padding: 0;\r\n            box-sizing: border-box;\r\n            transition: all 0.3s ease-in-out;\r\n        }\r\n\r\n        body {\r\n            font-family: 'Poppins', sans-serif;\r\n            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);\r\n            min-height: 100vh;\r\n            margin: 0;\r\n            padding: 20px;\r\n            display: flex;\r\n            justify-content: space-between;\r\n            align-items: flex-start;\r\n            gap: 30px;\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        .menu-container {\r\n            width: 70%;\r\n            padding: 30px;\r\n            background: rgba(255, 255, 255, 0.95);\r\n            backdrop-filter: blur(10px);\r\n            border-radius: 20px;\r\n            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);\r\n        }\r\n\r\n        h1 {\r\n            text-align: center;\r\n            color: #2d3436;\r\n            font-size: 2.8em;\r\n            margin-bottom: 40px;\r\n            position: relative;\r\n            text-transform: uppercase;\r\n            letter-spacing: 2px;\r\n        }\r\n\r\n        h1:after {\r\n            content: '';\r\n            position: absolute;\r\n            bottom: -10px;\r\n            left: 50%;\r\n            transform: translateX(-50%);\r\n            width: 100px;\r\n            height: 4px;\r\n            background: linear-gradient(90deg, #ff7f50, #ff4757);\r\n            border-radius: 2px;\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        .menu-list {\r\n            display: grid;\r\n            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));\r\n            gap: 30px;\r\n            padding: 20px;\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        .menu-item {\r\n            background: white;\r\n            border-radius: 15px;\r\n            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.08);\r\n            overflow: hidden;\r\n            transform-origin: center;\r\n            transition: transform 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);\r\n        }\r\n\r\n        .menu-item:hover {\r\n            transform: translateY(-10px) scale(1.02);\r\n            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.12);\r\n        }\r\n\r\n        .menu-item img {\r\n            width: 100%;\r\n            height: 220px;\r\n            object-fit: cover;\r\n            transform: scale(1);\r\n            transition: transform 0.4s ease;\r\n        }\r\n\r\n        .menu-item:hover img {\r\n            transform: scale(1.1);\r\n        }\r\n\r\n        .menu-item-content {\r\n            padding: 20px;\r\n        }\r\n\r\n        .menu-item h3 {\r\n            font-size: 1.4em;\r\n            color: #2d3436;\r\n            margin-bottom: 10px;\r\n            font-weight: 600;\r\n        }\r\n\r\n        .menu-item p {\r\n            color: #636e72;\r\n            line-height: 1.6;\r\n            margin-bottom: 20px;\r\n        }\r\n\r\n        .price {\r\n            font-size: 1.8em;\r\n            font-weight: 700;\r\n            color: #ff6b6b;\r\n            text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.1);\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        button {\r\n            background: linear-gradient(45deg, #ff6b6b, #ff8e8e);\r\n            color: white;\r\n            border: none;\r\n            padding: 12px 24px;\r\n            font-size: 1rem;\r\n            font-weight: 600;\r\n            border-radius: 50px;\r\n            cursor: pointer;\r\n            box-shadow: 0 4px 15px rgba(255, 107, 107, 0.3);\r\n            transition: all 0.3s ease;\r\n        }\r\n\r\n        button:hover {\r\n            background: linear-gradient(45deg, #ff5252, #ff7675);\r\n            transform: translateY(-3px);\r\n            box-shadow: 0 6px 20px rgba(255, 107, 107, 0.4);\r\n        }\r\n\r\n        button:active {\r\n            transform: translateY(1px);\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        .cart-container {\r\n            width: 28%;\r\n            padding: 25px;\r\n            background: rgba(255, 255, 255, 0.95);\r\n            backdrop-filter: blur(10px);\r\n            border-radius: 20px;\r\n            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);\r\n            position: sticky;\r\n            top: 20px;\r\n            max-height: calc(100vh - 40px);\r\n            overflow-y: auto;\r\n        }\r\n\r\n        .cart-container h2 {\r\n            font-size: 2em;\r\n            color: #2d3436;\r\n            text-align: center;\r\n            margin-bottom: 25px;\r\n            position: relative;\r\n            margin-top: 20px;\r\n        }\r\n\r\n        .cart-container h2:after {\r\n            content: '';\r\n            position: absolute;\r\n            bottom: -8px;\r\n            left: 50%;\r\n            transform: translateX(-50%);\r\n            width: 60px;\r\n            height: 3px;\r\n            background: linear-gradient(90deg, #ff6b6b, #ff8e8e);\r\n            border-radius: 2px;\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        .cart-items {\r\n            max-height: 400px;\r\n            overflow-y: auto;\r\n            padding: 10px;\r\n            margin-bottom: 20px;\r\n        }\r\n\r\n        .cart-item {\r\n            background: white;\r\n            padding: 15px;\r\n            border-radius: 12px;\r\n            margin-bottom: 15px;\r\n            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);\r\n            display: flex;\r\n            justify-content: space-between;\r\n            align-items: center;\r\n        }\r\n\r\n        .cart-item p {\r\n            margin: 0;\r\n            color: #2d3436;\r\n            font-weight: 500;\r\n        }\r\n\r\n        .cart-item button {\r\n            padding: 8px 16px;\r\n            font-size: 0.9rem;\r\n            background: linear-gradient(45deg, #ff4757, #ff6b6b);\r\n        }\r\n\r\n        .total-price {\r\n            font-size: 1.8em;\r\n            font-weight: 700;\r\n            text-align: center;\r\n            color: #2d3436;\r\n            margin: 20px 0;\r\n            padding: 15px;\r\n            border-radius: 12px;\r\n            background: linear-gradient(135deg, #f6f9fc 0%, #f1f5f9 100%);\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        .user-details {\r\n            background: white;\r\n            padding: 25px;\r\n            border-radius: 15px;\r\n            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);\r\n        }\r\n\r\n        .user-details h2 {\r\n            font-size: 1.6em;\r\n            margin-bottom: 20px;\r\n        }\r\n\r\n        .user-details label {\r\n            font-size: 1rem;\r\n            color: #2d3436;\r\n            font-weight: 500;\r\n            margin-bottom: 8px;\r\n            display: block;\r\n        }\r\n\r\n        .user-details input {\r\n            width: 100%;\r\n            padding: 12px 15px;\r\n            border: 2px solid #e9ecef;\r\n            border-radius: 10px;\r\n            font-size: 1rem;\r\n            margin-bottom: 15px;\r\n            transition: all 0.3s ease;\r\n        }\r\n\r\n        .user-details input:focus {\r\n            border-color: #ff6b6b;\r\n            box-shadow: 0 0 0 4px rgba(255, 107, 107, 0.1);\r\n            outline: none;\r\n        }\r\n\r\n        .user-details button {\r\n            width: 100%;\r\n            padding: 15px;\r\n            font-size: 1.1rem;\r\n            margin-top: 10px;\r\n            background: linear-gradient(45deg, #ff6b6b, #ff8e8e);\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        @media (max-width: 1200px) {\r\n            body {\r\n                flex-direction: column;\r\n            }\r\n\r\n            .menu-container, .cart-container {\r\n                width: 100%;\r\n            }\r\n\r\n            .cart-container {\r\n                position: relative;\r\n                top: 0;\r\n                margin-top: 30px;\r\n            }\r\n        }\r\n\r\n        @media (max-width: 768px) {\r\n            body {\r\n                padding: 10px;\r\n            }\r\n\r\n            .menu-list {\r\n                grid-template-columns: 1fr;\r\n            }\r\n\r\n            h1 {\r\n                font-size: 2em;\r\n            }\r\n\r\n            .menu-item-content {\r\n                padding: 15px;\r\n            }\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        ::-webkit-scrollbar {\r\n            width: 8px;\r\n        }\r\n\r\n        ::-webkit-scrollbar-track {\r\n            background: #f1f1f1;\r\n            border-radius: 4px;\r\n        }\r\n\r\n        ::-webkit-scrollbar-thumb {\r\n            background: linear-gradient(45deg, #ff6b6b, #ff8e8e);\r\n            border-radius: 4px;\r\n        }\r\n\r\n        ::-webkit-scrollbar-thumb:hover {\r\n            background: linear-gradient(45deg, #ff5252, #ff7675);\r\n        }\r\n    </style>\r\n</head>\r\n<body>\r\n\r\n<div class=\"menu-container\">\r\n    <h1>MarkFood Restaurant's Menu <i class=\"fa-solid fa-utensils\"></i></h1>\r\n    <hr>\r\n    <ul class=\"menu-list\">\r\n        ");
		for (FoodItem item : menu) {
			jteOutput.writeContent(" ");
			jteOutput.writeContent("\r\n            <li class=\"menu-item\">\r\n                <img");
			var __jte_html_attribute_0 = item.getImages();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" src=\"");
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("img", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" alt=\"@foodItem.name\">\r\n                <div class=\"menu-item-content\">\r\n                    <h3>");
			jteOutput.setContext("h3", null);
			jteOutput.writeUserContent(item.getName());
			jteOutput.writeContent("</h3>\r\n                    <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(item.getDescription());
			jteOutput.writeContent("</p>\r\n                    <div style=\"display: flex;justify-content: space-between;align-items: center;j\">\r\n                        <div class=\"price\">₹");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(item.getPrice());
			jteOutput.writeContent("</div>\r\n                    <button onclick=\"addToCart('");
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(item.getName());
			jteOutput.setContext("button", null);
			jteOutput.writeContent("', ");
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(item.getPrice());
			jteOutput.setContext("button", null);
			jteOutput.writeContent(")\">Add to cart</button>\r\n                    </div>\r\n\r\n                </div>\r\n            </li>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </ul>\r\n</div>\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"cart-container\">\r\n    <h2>Your Cart</h2>\r\n    <br>\r\n    <hr style=\"width: 100%\">\r\n    <div class=\"cart-items\" id=\"cart-items\">\r\n        ");
		jteOutput.writeContent("\r\n    </div>\r\n    <div class=\"total-price\" id=\"total-price\">\r\n        Total: ₹0\r\n    </div>\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <div class=\"user-details\">\r\n        <h2>Your Details</h2>\r\n        <label for=\"name\">Name:</label>\r\n        <input type=\"text\" id=\"name\" placeholder=\"Enter your name\" required>\r\n        <br>\r\n        <label for=\"email\">Email:</label>\r\n        <input type=\"email\" id=\"email\" placeholder=\"Enter your email\" required>\r\n        <br>\r\n        <label for=\"phoneNumber\">Phone Number:</label>\r\n        <input type=\"tel\" id=\"phoneNumber\" placeholder=\"Enter your phone number\" required>\r\n        <br>\r\n        <button onclick=\"placeOrder()\">Place Order</button>\r\n    </div>\r\n</div>\r\n\r\n");
		jteOutput.writeContent("\r\n<script>\r\n\r\n    let cart = [];\r\n\r\n    // Function to add items to the cart\r\n    function addToCart(name, price) {\r\n        // Find if the item is already in the cart\r\n        const existingItem = cart.find(item => item.name === name);\r\n\r\n        if (existingItem) {\r\n            // If the item is already in the cart, just increase the quantity\r\n            existingItem.quantity += 1;\r\n        } else {\r\n            // If the item is not in the cart, add it with quantity 1\r\n            cart.push({ name, price, quantity: 1 });\r\n        }\r\n\r\n        // Update the cart UI\r\n        updateCartUI();\r\n    }\r\n\r\n    // Function to remove items from the cart (decrease quantity or remove item)\r\n    function removeFromCart(index) {\r\n        const item = cart[index];\r\n\r\n        if (item.quantity > 1) {\r\n            // Decrease the quantity by 1 if quantity is greater than 1\r\n            item.quantity -= 1;\r\n        } else {\r\n            // If quantity is 1, remove the item completely\r\n            cart.splice(index, 1);\r\n        }\r\n\r\n        // Update the cart UI\r\n        updateCartUI();\r\n    }\r\n\r\n    // Function to update the cart UI\r\n    function updateCartUI() {\r\n        const cartItemsContainer = document.getElementById('cart-items');\r\n        const totalPriceContainer = document.getElementById('total-price');\r\n\r\n        // Clear the current cart items in the UI\r\n        cartItemsContainer.innerHTML = '';\r\n\r\n        // Iterate over the cart items and display them\r\n        let totalPrice = 0;\r\n        cart.forEach((item, index) => {\r\n            const cartItem = document.createElement('div');\r\n            cartItem.classList.add('cart-item');\r\n\r\n            // Calculate the total price for the item (price * quantity)\r\n            const itemTotalPrice = item.price * item.quantity;\r\n            totalPrice += itemTotalPrice;\r\n\r\n            // Render item name, quantity, and total price for that item\r\n            cartItem.innerHTML = `\r\n            <p>${item.name} x ${item.quantity}</p>\r\n            <p>Price: ₹${itemTotalPrice}</p>\r\n            <button onclick=\"removeFromCart(${index})\">Remove</button>\r\n        `;\r\n\r\n            // Append the item to the cart items container\r\n            cartItemsContainer.appendChild(cartItem);\r\n        });\r\n\r\n        // Update the total price\r\n        totalPriceContainer.innerHTML = `Total: ₹${totalPrice}`;\r\n    }\r\n async  function placeOrder() {\r\n        // Get the user's details from the input fields\r\n        const customerName = document.getElementById('name').value;\r\n        const customerEmail = document.getElementById('email').value;\r\n        const customerPhone = document.getElementById('phoneNumber').value;\r\n\r\n        // Make sure that all fields are filled before placing the order\r\n        if (!customerName || !customerEmail || !customerPhone) {\r\n            alert(\"Please fill in all your details!\");\r\n            return;\r\n        }\r\n\r\n        // Prepare the order data with food items repeated according to quantity\r\n        const orderData = {\r\n            customer: {\r\n                name: customerName,\r\n                email: customerEmail,\r\n                phoneNumber: customerPhone\r\n            },\r\n            foodItems: []\r\n        };\r\n\r\n        // Loop over the cart and add food items to the foodItems array\r\n        cart.forEach(item => {\r\n            // Push the item into the foodItems array `item.quantity` times\r\n            for (let i = 0; i < item.quantity; i++) {\r\n                orderData.foodItems.push({ name: item.name });\r\n            }\r\n        });\r\n\r\n        // Making the POST request to the newOrder API\r\n        try {\r\n            const response = await fetch(\"http://localhost:8080/order/newOrder\", {\r\n                method: 'POST',\r\n                headers: {\r\n                    'Content-Type': 'application/json',\r\n                },\r\n                body: JSON.stringify(orderData)\r\n            });\r\n\r\n            if (response.ok) {  // Check if response status is 200-299\r\n                const data = await response.json(); // Parse the JSON response\r\n                console.log('Order placed successfully:', data);\r\n                alert(\"Your order has been placed successfully!\");\r\n\r\n                // Clear the cart after order is placed\r\n                cart = [];\r\n                updateCartUI();\r\n            } else {\r\n                alert(\"Error placing order. Please try again.\");\r\n            }\r\n        } catch (error) {\r\n            console.error('Error placing order:', error);\r\n            alert(\"Error placing order. Please try again.\");\r\n        }\r\n    }\r\n</script>\r\n");
		jteOutput.writeContent("\r\n</body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<FoodItem> menu = (List<FoodItem>)params.get("menu");
		render(jteOutput, jteHtmlInterceptor, menu);
	}
}
