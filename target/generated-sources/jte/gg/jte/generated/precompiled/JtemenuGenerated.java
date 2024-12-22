package gg.jte.generated.precompiled;
import com.marktech.foodApp.model.FoodItem;
import java.util.List;
public final class JtemenuGenerated {
	public static final String JTE_NAME = "menu.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,19,19,19,19,21,21,21,21,21,21,21,21,21,23,23,23,24,24,24,26,26,26,27,27,27,27,27,27,27,27,32,32,36,42,48,63,72,77,77,77,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtemenuGenerated.class, "JtemenuGenerated.bin", 684,1,58,6,1,97,30,153,73,3,107,23,151,101,596,236,114);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	private static final byte[] TEXT_PART_BINARY_9 = BINARY_CONTENT.get(9);
	private static final byte[] TEXT_PART_BINARY_10 = BINARY_CONTENT.get(10);
	private static final byte[] TEXT_PART_BINARY_11 = BINARY_CONTENT.get(11);
	private static final byte[] TEXT_PART_BINARY_12 = BINARY_CONTENT.get(12);
	private static final byte[] TEXT_PART_BINARY_13 = BINARY_CONTENT.get(13);
	private static final byte[] TEXT_PART_BINARY_14 = BINARY_CONTENT.get(14);
	private static final byte[] TEXT_PART_BINARY_15 = BINARY_CONTENT.get(15);
	private static final byte[] TEXT_PART_BINARY_16 = BINARY_CONTENT.get(16);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<FoodItem> menu) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (FoodItem item : menu) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			var __jte_html_attribute_0 = item.getImages();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
			jteOutput.setContext("h3", null);
			jteOutput.writeUserContent(item.getName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(item.getDescription());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(item.getPrice());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(item.getName());
			jteOutput.setContext("button", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(item.getPrice());
			jteOutput.setContext("button", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<FoodItem> menu = (List<FoodItem>)params.get("menu");
		render(jteOutput, jteHtmlInterceptor, menu);
	}
}
