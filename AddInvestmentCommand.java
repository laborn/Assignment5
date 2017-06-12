package command;

import factory.InvestmentFactory;
import singleton.Logger;



public class AddInvestmentCommand<Stock> implements Command {
	
	private String symbol;
	static Logger logfile = Logger.getInstance();
	
	public AddInvestmentCommand(String symbol) {
		
		this.symbol = symbol;
		
	}
	
	public void execute(){
		
		InvestmentFactory.addInvestment(symbol);
		logfile.append("Used AddInvestmentCommand.\n");

	}
	
}
