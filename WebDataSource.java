package adapter;

import java.net.URL;

public interface WebDataSource {

	public URL getURL(String symbol, String statistics);
}
