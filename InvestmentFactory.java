package factory;

import java.util.List;

/**
 * @author LuAnn Born
 *
 */
public class InvestmentFactory {

	static List<String> stocks = null;
	
	/**
	 * @param symbol
	 * @param stockList 
	 * @return Investment
	 */
	public static Investment addInvestment(String symbol) {

		if (symbol.length() > 4) {

			return new MutualFund(symbol, null, 0, 0, 0, null);
		} else {

			return new Stock(symbol, null, 0, 0, 0);
		}
	}

	public static void setPurchasePrice(String symbol, double lastPrice, double shares){
		
		if (symbol.length() > 4) {
			 
			MutualFund.setPurchasePrice(symbol, lastPrice, shares);
		}
		else {
			
			Stock.setPurchasePrice(symbol, lastPrice, shares);
		}
	}

	public static Investment addInvestment(String symbol, String name, double shares, double purchasePrice, double lastPrice, List<String> stocks) {

		return new MutualFund(symbol, name, shares, purchasePrice, lastPrice, stocks);
	}

}
