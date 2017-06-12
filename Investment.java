package factory;

import java.util.List;

/**
 * @author LuAnn Born
 *
 */
public abstract class Investment {
	
	//Instance variables:
	String symbol = null;
	double shares = 0;
	double purchasePrice = 0;
	double lastPrice;
	String name = null;
	List<String> stockList;
	
//	/**
//	 * @param symbol
//	 * @param name
//	 * @param shares
//	 * @param purchasePrice
//	 * @param lastPrice
//	 */
//	public Investment(String symbol, String name, double shares, double purchasePrice, double lastPrice){
//		
//		this.symbol = symbol;
//		this.name  = name;
//		this.shares = shares;
//		this.purchasePrice = purchasePrice;
//		this.lastPrice = lastPrice;
//	}
	
	//Set methods
	/**
	 * @param symbol
	 */
	public void setSymbol(String symbol){};
	/**
	 * @param name
	 */
	public void setName(String name){};
	/**
	 * @param shares
	 */
	public void setShares(double shares){};
	/**
	 * @param purchasePrice
	 */
	public void setPurchasePrice(double purchasePrice){};
	/**
	 * @param lastPrice
	 */
	public void setLastPrice(double lastPrice){
		this.lastPrice = lastPrice;
	};
	
	
	//get methods
	/**
	 * @return symbol
	 */
	public String getSymbol(){ return symbol;}
	/**
	 * @return name
	 */
	public String getName(){ return name;}
	/**
	 * @return shares
	 */
	public double getShares(){ return shares;}
	/**
	 * @return purchasePrice
	 */
	public double getPurchasePrice(){ return purchasePrice;}
	/**
	 * @return last Price
	 */
	public double getLastPrice(){ return lastPrice;}
	
	public List<String> getStockList(){ return stockList; }

	/**
	 * @param symbol
	 * @param name
	 * @param shares
	 * @param purchasePrice
	 * @param lastPrice
	 */
	public void printStats(String symbol, String name, double shares, double purchasePrice, double lastPrice){}
}
