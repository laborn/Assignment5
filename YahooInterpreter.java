package interpreter;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class YahooInterpreter {
	
	static List<String> keys = Arrays.asList("a","b","p","o","y","d","r1","q","c1","c",
			"p2","d1","t1","g","h","l","l1","t8","m5","m6",
			"m7","m8","m3","m4","m","s6","k","j","j5","k4",
			"j6","k5","w","j1","f6","n","s","x","j2","v",
			"a5","b6","k3","a2","e","e7","e8","e9","b4","j4",
			"p5","p6","r","r5","r6","r7","s7");
	
	static List<String> values = Arrays.asList("Ask","Bid","Previous Close","Open","Dividend Yield", 
			"Dividend Per Share","Dividend Pay Date","Ex-dividend Date","Change","Change & % Change",
			"Change in %","Last Trade Date","Last Trade Time","Day's Low","Day's High",
			"Last Trade (with Time)", "Last Trade (Price Only)","1 Yr Target Price","Change from 200 day Moving Average",
			"% Change from 200 day Moving Average","Change from 50 day Moving Average","% Change from 50 day Moving Average",
			"50 day Moving Average","200 day Moving Average","Day's Range",
			"Revenue","52 Week High","52 Week Low","Change from 52 Week Low","Change from 52 Week High",
			"% Change from 52 Week Low","% Change from 52 Week High","52 Week Range","Market Capitalization","Float Shares",
			"Name","Symbol","Stock Exchange","Shares Outstanding","Volume",
			"Ask Size","Bid Size","Last Trade Size","Average Daily Volume","Earnings Per Share",
			"EPS Estimate Current Year","EPS Estimate Next Year","EPS Estimate Next Quarter","Book Value","EBITDA",
			"Price/Sales","Price/Book","P/E Ratio","PEG Ratio","Price/EPS Estimate Current Year",
			"Price/EPS Estimate Next Year","Short Ratio");

	public static Map<String,String> yahooToEnglish(){
		
		Map<String,String> yahoo = new Hashtable<String,String>();
	
		for (int i = 0; i < keys.size(); i++){
			yahoo.put(keys.get(i), values.get(i));
		}
		return yahoo;
	}
	
	public static Map<String,String> englishToYahoo(){
	    
		Map<String,String> english = new Hashtable<String, String>();
		
	    for	(int i = 0; i < keys.size(); i++){
	        english.put(values.get(i), keys.get(i));
	    }
	    return english;
	}

//	public static void main(String[] args){
//		
//		System.out.println(yahooToEnglish());
//		System.out.println(yahooToEnglish().get("a"));
//		
//		System.out.println(englishToYahoo());
//		System.out.println(englishToYahoo().get("Book Value"));
//	}
}
