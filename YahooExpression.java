package interpreter;

/**
 * @author LuAnn Born
 *
 */
public class YahooExpression extends Expression {
	
	String statistics;
	
	/**
	 * @param statistics
	 */
	public YahooExpression(String statistics){
		
		this.statistics = statistics;
		
	}
	
	/**
	 * @param statistics
	 */
	public static void interpret(String statistics){
		
		String yahoocode = null;
		
		for (int i = 0; i < statistics.length(); i++){
			
			if (i < statistics.length()-1){
				if (Character.isDigit(statistics.charAt(i+1))){
					yahoocode = ("" + statistics.charAt(i) + statistics.charAt(i+1));
					System.out.println(yahoocode + " " + YahooInterpreter.yahooToEnglish().get(yahoocode));
					i++;
				}
				else{
					yahoocode = ("" + statistics.charAt(i));
					System.out.println(yahoocode + " " + YahooInterpreter.yahooToEnglish().get(yahoocode));
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
//		interpret("bs6a2j4m6g");
	}
}
