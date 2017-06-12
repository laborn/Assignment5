package adapter;

import java.net.MalformedURLException;
import java.net.URL;

class GoogleFinance implements WebDataSource{
	
	String symbol;
	String statistics;
	URL url;

	public GoogleFinance(String symbol, String statistics) {
		this.symbol = symbol;
		this.statistics = statistics;
	}
	
	public URL getURL(String symbol, String statistics){
		
		this.symbol = symbol;
		URL urlGoogle = null;
		try {
			urlGoogle = new URL("http://finance.google.com/finance/info?client=ig&q=NASDAQ%3A" + symbol);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return urlGoogle;
	}
}
