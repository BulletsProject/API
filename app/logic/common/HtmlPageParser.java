package logic.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlPageParser {

	private String urlAddress;
	private Map<String, List<String>> properties = new HashMap<>();
	
	public HtmlPageParser(String url) {
		urlAddress = url;
	}
	
	private String readUrl() throws IOException {
        URL url = new URL(urlAddress);
        URLConnection conn = url.openConnection();

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(
                           new InputStreamReader(conn.getInputStream()));

        String inputLine;
        while ((inputLine = br.readLine()) != null) {
        	sb.append(inputLine);
        }
        br.close();

        return sb.toString();		
	}
	
	public Map<String, List<String>> parse() throws Exception {
		String content = readUrl();
		
		Document doc = Jsoup.parse(content);
		
		Element title = doc.select("title").first();
		
		List<String> elems = new LinkedList<String>();
		elems.add(title.text());
		properties.put("title", elems);
		
		for(Element meta : doc.select("meta")) {
			
			String propertyName = meta.attr("property");
			if (propertyName == null) propertyName = meta.attr("name");
			if (propertyName == null) continue;
			
			List<String> values = properties.get(propertyName);
			
			if (!properties.containsKey(propertyName)) {
				values = new LinkedList<String>(); 
				properties.put(propertyName, values);
			}
			
			values.add(meta.attr("content"));
		}		
		
		return properties;
	}
	
	
	
}
