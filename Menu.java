package facade;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import abstractfactory.PortfolioAbstractFactory;
import factory.Investment;
import factory.InvestmentFactory;
import iterator.StockListIterator;
import singleton.Logger;
import singleton.Reader;
import adapter.DataAdapter;
import command.AddInvestmentCommand;
import command.Command;


public class Menu {

	static int choice;
	static int portfolioChoice;
	static int tradeChoice;
	static int styleChoice;
	static Logger logfile = Logger.getInstance();
	static Scanner input = Reader.getInstance();

	public Menu() {
		super();
	}


	public static int mainMenu() throws InputMismatchException {

		System.out.println("Choose an option:");
		System.out.println("1. Get current trading information");
		System.out.println("2. Find my investment style");
		System.out.println("3. Portfolio Management");
		System.out.println("4. Exit");

		// Get user's choice:
		try {
			int choice = input.nextInt();
			return choice;
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Try again.");
			return 10;
		}
	}

	/**
	 * Choices is the control mechanism using a switch statement that is
	 * controlled by the user's input from the printMenu method.
	 * 
	 * @param choice
	 *            is the choice made by the user in the printMenu
	 * @throws IOException
	 */
	public static void mainMenuChoices(int choice) throws InputMismatchException, IOException {

		// Define the choices:
		switch (choice) {
		case 1:
			logfile.append("Chose Trading\n");
			DataAdapter.tradesMenu();
			choice = mainMenu(); // Go back to the main menu for another choice
			mainMenuChoices(choice);
			break;

		case 2:
			logfile.append("Chose Styles\n");
			styleChoice = stylesMenu();
			stylesMenuChoices(styleChoice);
			choice = mainMenu(); // Go back to the main menu for another choice
			mainMenuChoices(choice);
			break;

		case 3:
			logfile.append("Chose Portfolio Management\n");
			portfolioChoice = portfoliosMenu();
			portfoliosMenuChoices(portfolioChoice);
			choice = mainMenu();
			mainMenuChoices(choice);
			break;

		case 4:
			logfile.append("Chose to exit\n");
			System.out.println("Have a nice day!"); // End the program
			break;

		default:
			System.out.println("Enter a choice from 1 to 4!"); // If something
			// other than 1, 2, 3, 4 is entered
			choice = mainMenu(); /// Go back to the main menu for another choice
			mainMenuChoices(choice);
		}
	}

	public static int stylesMenu() throws InputMismatchException {

		System.out.println("Choose an investment style:");
		System.out.println("1. Aggressive");
		System.out.println("2. Defensive");
		System.out.println("3. Income");
		System.out.println("4. Hybrid");
		System.out.println("5. Speculative");
		System.out.println("6. Exit");

		// Get user's choice:
		try {
			styleChoice = input.nextInt();
			return styleChoice;
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Try again.");
			return 10;
		}
	}

	public static int portfoliosMenu() throws InputMismatchException {

		System.out.println("Choose an option:");
		System.out.println("1. Create a Portfolio");
		System.out.println("2. Add to a Portfolio");
		System.out.println("3. Get a Portfolio's Current Value");
		System.out.println("4. New Mutual Fund");
		System.out.println("5. Exit");

		// Get user's choice:
		try {
			portfolioChoice = input.nextInt();
			return portfolioChoice;
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Try again.");
			return 10;
		}
	}

	/**
	 * Choices is the control mechanism using a switch statement that is
	 * controlled by the user's input from the printMenu method.
	 * 
	 * @param choice
	 *            is the choice made by the user in the printMenu
	 * @throws IOException
	 */
	public static void stylesMenuChoices(int styleChoice) throws IOException {
		// Define the choices:
		logfile.append("Chose " + styleChoice + "\n");
		PortfolioAbstractFactory.createPortfolio(styleChoice);
	}

	/**
	 * Choices is the control mechanism using a switch statement that is
	 * controlled by the user's input from the printMenu method.
	 * 
	 * @param choice
	 *            is the choice made by the user in the printMenu
	 * @throws IOException
	 */
	public static void portfoliosMenuChoices(int portfolioChoice) throws IOException {
		
		// Define the choices:
		switch (portfolioChoice) {
		case 1:
			logfile.append("Chose Create a Portfolio: \n");
			System.out.println("Enter the investment symbol: \n");
			String symbol = input.next();
			Command mycommand = new AddInvestmentCommand<Object>(symbol);
			mycommand.execute();
			System.out.println("Enter the number of shares: \n");
			int shares = input.nextInt();
			InvestmentFactory.setPurchasePrice(symbol,DataAdapter.getLastPrice(symbol),shares);
			break;

		case 2:
			logfile.append("Chose Add to a Portfolio \n");
			System.out.println("Enter the investment symbol: \n");
			symbol = input.next();
			logfile.append("Input: " + symbol + "\n");
			Command mycommand1 = new AddInvestmentCommand<Object>(symbol);
			mycommand1.execute();
			break;

		case 3:
			logfile.append("Chose get the portfolio's value\n");
			// get the value of the portfolio
			break;
			
		case 4:
			logfile.append("Chose new mutual fund\n");
			// create a mutual fund
			System.out.println("Enter the investment symbol: \n");
			symbol = input.next();
			System.out.println("Enter the name of the fund: \n");
			String name = input.next();
			List<String> stocks = Arrays.asList("MMM","AXP","AAPL","BA","CAT","CVX","CSCO","KO","DIS",
					"DD","XOM","GE","GS","HD","IBM","INTC","JNJ","JPM","MCD",
					"MRK","MSFT","NKE","PFE","PG","TRV","UTX","UNH","VZ","V","WMT");
			Investment newfund = InvestmentFactory.addInvestment(symbol, name, 0, 0.00, 0.00, stocks);
			StockListIterator iterate = new StockListIterator(stocks);
			
//			System.out.println(stocks);

			while(!iterate.isDone()){
				System.out.print("Stock: " + iterate.currentItem() + "     Last Trade Price: " + DataAdapter.getStockListLastPrice(iterate.currentItem()) + "     Buy " + 1000/DataAdapter.getStockListLastPrice(iterate.currentItem()) + " Shares");
				iterate.next();
			}
			
			System.out.println("\n\nMutual Fund Symbol: " + newfund.getSymbol());
			System.out.println("Mutual Fund Name: " + newfund.getName());
			System.out.println("Total of $30,000 investment with $1,000 per stock in the fund\n");
//			System.out.println("Mutual Fund Share Price: " + newfund.getLastPrice());
			break;

		case 5:
			logfile.append("Return to main menu\n");
			break;

		default:
			System.out.println("Enter a choice from 1 to 5!"); // If something
			// other than 1, 2, 3, 4, 5 is entered
			portfolioChoice = portfoliosMenu();
			portfoliosMenuChoices(portfolioChoice);
		}
	}
}
