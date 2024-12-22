package gg.jte.generated.ondemand;
import com.marktech.foodApp.model.FoodItem;
import java.util.List;
public final class JtemenuGenerated {
	public static final String JTE_NAME = "menu.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,19,19,19,19,21,21,21,21,21,21,21,21,21,23,23,23,24,24,24,26,26,26,27,27,27,27,27,27,27,27,32,32,36,42,48,63,72,77,77,77,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<FoodItem> menu) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css\" integrity=\"sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n    <link rel=\"stylesheet\" href=\"css/styleMenu.css\">\r\n    <title>Menu</title>\r\n\r\n</head>\r\n<body>\r\n\r\n<div class=\"menu-container\" id=\"menu\">\r\n    <h1>MarkFood Restaurant's Menu <i class=\"fa-solid fa-utensils\"></i></h1>\r\n    <hr>\r\n    <ul class=\"menu-list\">\r\n        ");
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
			jteOutput.writeContent("</p>\r\n                    <div style=\"display: flex;justify-content: space-between;align-items: center;\">\r\n                        <div class=\"price\">₹");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(item.getPrice());
			jteOutput.writeContent("</div>\r\n                    <button id=\"add-to-cart\" onclick=\"addToCart('");
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(item.getName());
			jteOutput.setContext("button", null);
			jteOutput.writeContent("', ");
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(item.getPrice());
			jteOutput.setContext("button", null);
			jteOutput.writeContent(")\">Add to Plate</button>\r\n                    </div>\r\n\r\n                </div>\r\n            </li>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </ul>\r\n</div>\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"cart-container\">\r\n    <h2>Your Plate</h2>\r\n    <br>\r\n    <hr style=\"width: 100%\">\r\n    <div class=\"cart-items\" id=\"cart-items\">\r\n        ");
		jteOutput.writeContent("\r\n    </div>\r\n    <div class=\"total-price\" id=\"total-price\">\r\n        Total: ₹0\r\n    </div>\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <div class=\"user-details\">\r\n        <h2>Your Details</h2>\r\n        <label for=\"name\">Name:</label>\r\n        <input type=\"text\" id=\"name\" placeholder=\"Enter your name\" required>\r\n        <br>\r\n        <label for=\"email\">Email:</label>\r\n        <input type=\"email\" id=\"email\" placeholder=\"Enter your email\" required>\r\n        <br>\r\n        <label for=\"phoneNumber\">Phone Number:</label>\r\n        <input type=\"tel\" id=\"phoneNumber\" placeholder=\"Enter your phone number\" required>\r\n        <br>\r\n        <button onclick=\"placeOrder()\" id=\"place-order\">Place Order</button>\r\n    </div>\r\n</div>\r\n");
		jteOutput.writeContent("\r\n<div class=\"mobile-cart-btn\">\r\n    <button class=\"cart-toggle\" id=\"cartToggle\">\r\n        <i class=\"fas fa-shopping-cart\"></i>\r\n        <span>View Cart</span>\r\n        <span id=\"mobileCartTotal\">(₹0)</span>\r\n    </button>\r\n</div>\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"cart-overlay\" id=\"cartOverlay\"></div>\r\n<script src=\"/js/menuScript.js\"></script>\r\n</body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<FoodItem> menu = (List<FoodItem>)params.get("menu");
		render(jteOutput, jteHtmlInterceptor, menu);
	}
}
