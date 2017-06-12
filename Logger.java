package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author LuAnn Born
 * Logger is the Single design pattern that ensures one instance
 * of an application log file that all methods can use.
 */
public class Logger {
	
	String outFile = ("logfile.txt");
	private static final Logger logfile = new Logger();
	String content = null;
    
    //private constructor to avoid client applications to use constructor
    private Logger(){
    	super();
    }
    /**
     * @return logfile
     */
    public static Logger getInstance(){
     	return logfile;
    }
    
	public void initialize(){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile, true))) {
			content = "\nInitializing Investment Tracker logfile on " + java.time.LocalDate.now() + " at " + java.time.LocalTime.now() + "\n";
			bw.write(content);
		}
		catch (IOException ex) {
			System.err.format("Error writing filename " + outFile);
		}
	}
	
	public void append(String content){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile, true))) {
			logfile.content = content + "\n";
			bw.write(content);
		}
		catch (IOException ex) {
			System.err.format("Error writing filename " + outFile);
		}
	}
}