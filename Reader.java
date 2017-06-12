package singleton;

import java.util.Scanner;

/**
 * @author LuAnn Born
 * Reader uses the Singleton design pattern that ensures one instance
 * of an a Scanner for console input.
 */
public class Reader {
	
	public static Scanner input = new Scanner(System.in);
    

	private Reader(){
    	super();
    }
	
    /**
     * @return input
     */
    public static Scanner getInstance(){
     	return input;
	}
}