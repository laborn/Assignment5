package factory;

import java.util.List;

import singleton.Logger;

/**
 * @author LuAnn Born
 *
 */
class MutualFund extends Investment {
	
	Logger logfile = Logger.getInstance();
	/**
	 * @param symbol
	 * @param name
	 * @param shares
	 * @param purchasePrice
	 * @param lastPrice
	 */
	public MutualFund(String symbol, String name, double shares, double purchasePrice, double lastPrice, List<String> stocks) {
		this.symbol = symbol;
		this.name = name;
		this.shares = shares;
		this.purchasePrice = purchasePrice;
		this.lastPrice = lastPrice;
		this.stockList = stocks;
		String content = "Added mutual fund " + symbol + "\n";
		System.out.println(content);
		logfile.append(content);
	}
	
	/**
	 * @param symbol
	 * @param shares
	 */
	public void setShares(String symbol, double shares){
		this.symbol = symbol;
		this.shares = shares;
	}
	
	/**
	 * @param symbol
	 * @param lastPrice
	 * @param shares
	 */
	public static void setPurchasePrice(String symbol, double lastPrice, double shares){
		double purchasePrice = lastPrice*shares;
		System.out.println("Purchased " + shares + "shares of " + symbol + " for $" + purchasePrice + "\n");
	}

	public void printStats(){
		System.out.println("This is the mutual funds printout");
	}
}