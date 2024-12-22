package gg.jte.generated.ondemand;
public final class JteloginGenerated {
	public static final String JTE_NAME = "login.jte";
	public static final int[] JTE_LINE_INFO = {30,30,30,30,30,30,30,30,30,30,30};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>MarkFood Restaurant - Login</title>\r\n    <link rel=\"stylesheet\" href=\"/css/login.css\">\r\n</head>\r\n<body>\r\n<div class=\"login-container\">\r\n    <div class=\"logo\">\r\n        <h1>MarkFood</h1>\r\n        <p>Taste the Excellence</p>\r\n    </div>\r\n    <form action=\"/login\" method=\"POST\">\r\n        <div class=\"input-group\">\r\n            <label for=\"username\">Username or Email</label>\r\n            <input type=\"text\" id=\"username\" name=\"username\" required>\r\n        </div>\r\n        <div class=\"input-group\">\r\n            <label for=\"password\">Password</label>\r\n            <input type=\"password\" id=\"password\" name=\"password\" required>\r\n        </div>\r\n        <button type=\"submit\" class=\"btn-login\">Login</button>\r\n        <div class=\"links\">\r\n            <a href=\"/register\">Create Account</a>\r\n        </div>\r\n    </form>\r\n</div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
