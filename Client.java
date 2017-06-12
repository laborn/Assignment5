package iterator;

import java.util.Arrays;
import java.util.List;

public class Client {

	public Client() {
		super();
	}

	public static void main(String[] args){
		
		List<String> stocks = Arrays.asList("MMM","AXP","AAPL","BA","CAT","CVX","CSCO","KO","DIS",
				"DD","XOM","GE","GS","HD","IBM","INTC","JNJ","JPM","MCD",
				"MRK","MSFT","NKE","PFE","PG","TRV","UTX","UNH","VZ","V","WMT");

		StockListIterator iterate = new StockListIterator(stocks);
		
		System.out.println(stocks);

		while(!iterate.isDone()){
			
			System.out.println(iterate.currentItem());
			
			iterate.next();
		}
	}
}
