package gg.jte.generated.precompiled;
public final class JteadminGenerated {
	public static final String JTE_NAME = "admin.jte";
	public static final int[] JTE_LINE_INFO = {26,26,26,26,26,26,26,26,26,26,26,26,26};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteadminGenerated.class, "JteadminGenerated.bin", 1139);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
