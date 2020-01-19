package yahoo.search;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YahooSearch {
    public static final String GOOGLE_SEARCH_URL = "https://search.yahoo.com/search";
	public  String search(String searchTerm) throws IOException {
		
		
		String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm;
		//without proper User-Agent, we will get 403 error
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/6.0").get();
		
		//below will print HTML data, save it to a file and open in browser to compare
		//System.out.println(doc.html());
		
		//If google search results HTML change the <h3 class="r" to <h3 class="r1"
		//we need to change below accordingly
//		Elements results = doc.select("h3.title > a");mb-15 reg searchCenterMiddle
                Elements results = doc.select(".searchCenterMiddle > li");
                return results.toString();
//		for (Element result : results) {
//			String linkHref = result.attr("href");
//			String linkText = result.text();
			//System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
//                        System.out.println("Text::" + linkText+ ", URL::" + linkHref );
//		}
	}
}
