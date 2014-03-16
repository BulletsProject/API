package logic.common;

import java.util.List;
import java.util.Map;

public class OpenGraphData {

	private String url;
	
	public static class OpenGraphProtocol {
		public static final String PageTitle = "title";
		
		public static final String OgImage = "og:image";
	}
	
	private String ogImage;
	private String pageTitle;
	
	public OpenGraphData(String url) {
		this.url = url;
	}
	
	public void process() throws Exception {
		HtmlPageParser parser = new HtmlPageParser(url);
		Map<String, List<String>> properties = parser.parse();
		
		for(String key : properties.keySet()) {
			if (key.equals(OpenGraphProtocol.OgImage)) {
				ogImage = properties.get(key).get(0);
			}
			if (key.equals(OpenGraphProtocol.PageTitle)) {
				pageTitle = properties.get(key).get(0);
			}			
		}
	}

	public String getOgImage() {
		return ogImage;
	}

	public String getPageTitle() {
		return pageTitle;
	}
	
}
