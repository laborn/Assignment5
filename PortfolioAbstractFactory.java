package abstractfactory;

public abstract class PortfolioAbstractFactory {
	
	public static Portfolio createPortfolio(int styleChoice){
		
		Portfolio portfolio = null;
		
		if (styleChoice == 1) {
			portfolio = AggressiveFactory.createPortfolio();
		}
		else if (styleChoice == 2){
			portfolio = DefensiveFactory.createPortfolio();
		}
		else if (styleChoice == 3){
			portfolio = IncomeFactory.createPortfolio();
		}
		else if (styleChoice == 4){
			portfolio = HybridFactory.createPortfolio();
		}
		else if (styleChoice == 5){
			portfolio = SpeculativeFactory.createPortfolio();
		}
		return portfolio;
	}
}
