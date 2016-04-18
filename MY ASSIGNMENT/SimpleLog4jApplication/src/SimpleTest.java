import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleTest {
	
	//Logger(interface) from org.slf4j
	//LoggerFactory(class)from org.slf4j
	//logger is a constant;
	private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

	public static void main(String[] args) 
	{
		logger.info("Application started");
		System.out.println("logger");
		logger.info("Application Completed");

	}
	
}
