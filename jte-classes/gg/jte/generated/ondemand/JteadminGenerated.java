package gg.jte.generated.ondemand;
public final class JteadminGenerated {
	public static final String JTE_NAME = "admin.jte";
	public static final int[] JTE_LINE_INFO = {23,23,23,23,23,23,23,23,23,23,23};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>MarkFood Admin Dashboard</title>\r\n    <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n    <link rel=\"stylesheet\" href=\"/css/styleAdmin.css\">\r\n\r\n</head>\r\n<body>\r\n<div class=\"dashboard\">\r\n    <div class=\"header\">\r\n        <h1>Order Management Dashboard</h1>\r\n        <a href=\"/logout\" class=\"logout-button\">Logout</a>\r\n    </div>\r\n\r\n\r\n    <div class=\"orders-container\" id=\"orders-container\">\r\n    </div>\r\n</div>\r\n<script src=\"/js/adminScript.js\"></script>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
