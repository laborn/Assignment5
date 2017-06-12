package facade;

import java.io.IOException;
import java.util.Scanner;

import singleton.Logger;
import singleton.Reader;

public class UserInterface {

	static int choice;

	/**
	 * Create a Scanner object for input
	 */
	static Scanner input = Reader.getInstance();

	public static void main(String[] args) throws IOException {

		// Start the logger
		Logger logfile = Logger.getInstance();
		logfile.initialize();

		// Call the menu and get the user's choice:
		choice = Menu.mainMenu();
		Menu.mainMenuChoices(choice);
		
		input.close();

	}
}
