package abstractfactory;

import factory.InvestmentFactory;
import singleton.Logger;

/**
 * @author LuAnn Born
 *
 */
class DefensiveFactory extends PortfolioAbstractFactory {

	
	static Logger logfile = Logger.getInstance();

	/**
	 * 
	 */
	public DefensiveFactory() {};
		
		/**
		 * @return portfolio
		 */
		public static Portfolio createPortfolio(){
			
			Portfolio portfolio = new Portfolio(null, null, null, null);
			
			String comment = "A defensive portfolio has a 10:90 blend of stocks to mutual funds.\n";
			
			System.out.println(comment);
				
			logfile.append(comment);
			

			portfolio.i1 = InvestmentFactory.addInvestment("TPINX");
			portfolio.i2 = InvestmentFactory.addInvestment("PRHYX");
			portfolio.i3 = InvestmentFactory.addInvestment("DODFX");
			portfolio.i4 = InvestmentFactory.addInvestment("MSFT");

			
//			portfolio.investments
//
//			portfolio.i1 = InvestmentFactory.addInvestment("TPINX");
//			portfolio.i2 = InvestmentFactory.addInvestment("PRHYX");
//			portfolio.i3 = InvestmentFactory.addInvestment("DODFX");
//			portfolio.i4 = InvestmentFactory.addInvestment("MSFT");
			return portfolio;
	
		}
}
