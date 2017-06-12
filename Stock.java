package factory;

import singleton.Logger;

/**
 * @author LuAnn Born
 *
 */
class Stock extends Investment {
	
	Logger logfile = Logger.getInstance();
	
	/**
	 * @param symbol
	 * @param name
	 * @param shares
	 * @param purchasePrice
	 * @param lastPrice
	 */
	public Stock(String symbol, String name, double shares, double purchasePrice, double lastPrice) {
		this.symbol = symbol;
		this.name = name;
		this.shares = shares;
		this.purchasePrice = purchasePrice;
		this.lastPrice = lastPrice;
		
		String content = "Added stock " + symbol;
		
		System.out.println(content);
		logfile.append(content = "\n");
	}
	/**
	 * @param symbol
	 * @param shares
	 */
	public void setShares(String symbol, double shares){
		this.symbol = symbol;
		this.shares = shares;
	}
	
	public static void setPurchasePrice(String symbol, double lastPrice, double shares){
		double purchasePrice = lastPrice*shares;
		System.out.println("Purchased " + shares + " shares of " + symbol + " for $" + purchasePrice + "\n");

	}

	public void printStats(){
		System.out.println("This is the stocks printout");
	}
}
