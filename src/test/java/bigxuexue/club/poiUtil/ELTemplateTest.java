package bigxuexue.club.poiUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.HyperLinkTextRenderData;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;

/**
 * 点缀法标签
 * 
 * @author lxb
 */
public class ELTemplateTest {

	RowRenderData header;
	List<RowRenderData> tableDatas;

	@Before
	public void init() {
		header = new RowRenderData(Arrays.asList(new TextRenderData("FFFFFF", "Word处理解决方案"),
				new TextRenderData("FFFFFF", "是否跨平台"), new TextRenderData("FFFFFF", "易用性")), "ff9800");
		RowRenderData row0 = RowRenderData.build("Poi-tl", "纯Java组件，跨平台", "简单：模板引擎功能，并对POI进行了一些封装");
		RowRenderData row1 = RowRenderData.build("Apache Poi", "纯Java组件，跨平台", "简单，缺少一些功能的封装");
		RowRenderData row2 = RowRenderData.build("Freemarker", "XML操作，跨平台", "复杂，需要理解XML结构");
		RowRenderData row3 = RowRenderData.build("OpenOffice", "需要安装OpenOffice软件", "复杂，需要了解OpenOffice的API");
		RowRenderData row4 = RowRenderData.build("Jacob、winlib", "Windows平台", "复杂，不推荐使用");
		tableDatas = Arrays.asList(row0, row1, row2, row3, row4);
	}

	/**
	 * 支持中文变量
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("serial")
	@Test
	public void testChinese() throws IOException {
		Configure.ConfigureBuilder builder = Configure.newBuilder();
		XWPFTemplate template = XWPFTemplate.compile("src/test/resources/chinese.docx", builder.build())
				.render(new HashMap<String, Object>() {
					{
						put("作者姓名", "Sayi");
						put("作者别名", "卅一1");
						put("authoravatar", new PictureRenderData(60, 60, "src/test/resources/sayi.png"));
						put("detaildiff",
								new MiniTableRenderData(header, tableDatas, MiniTableRenderData.WIDTH_A4_FULL));
						put("详情网址", new HyperLinkTextRenderData("http://www.deepoove.com", "http://www.deepoove.com"));
						put("详情", new HashMap<String, Object>() {
							{
								put("描述", new HashMap<String, String>() {
									{
										put("日期", "2019-05-24");
									}
								});
							}
						});
					}
				});

		template.writeToFile("out_chinese.docx");
	}

	@Test
	public void testPartyCost() throws IOException {
		Map<String, Object> outMap = new HashMap<>();
		outMap.put("year", "19");
		outMap.put("quar", "二");
		outMap.put("month", "6");
		outMap.put("day", "14");

		outMap.put("X1", "1232");
		outMap.put("Y1", "3232");
		outMap.put("Z1", "2312");
		outMap.put("R1", "32423");
		outMap.put("S1", "234");
		outMap.put("T1", "123");
		outMap.put("L1", "3242");
		outMap.put("M1", "12344");
		outMap.put("N1", "4634");
		outMap.put("P1", "234");

		Configure.ConfigureBuilder builder = Configure.newBuilder();
		XWPFTemplate template = XWPFTemplate
				.compile("src/test/resources/bjfy-shangjiao-party-cost-template.docx", builder.build()).render(outMap);

		template.writeToFile("out_chinese.docx");
	}
}