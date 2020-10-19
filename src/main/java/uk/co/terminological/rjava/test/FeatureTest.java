package uk.co.terminological.rjava.test;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RCharacter;
import uk.co.terminological.rjava.types.RDataframe;
import uk.co.terminological.rjava.types.RNumeric;
import uk.co.terminological.rjava.types.RObject; 

/**
 * A test of the jsr223 templating
 * 
 * this is a details comment 
 * @author given family email@example.com ORCIDID
 * 
 */
@RClass(
		imports = {"ggplot2","dplyr"},
		suggests = {"roxygen2","devtools"}
		)
public class FeatureTest {

	String message;
	static Logger log = LoggerFactory.getLogger(FeatureTest.class);
	
	/**
	 * A maximum of one constructor of any signature can be used. </br>
	 * 
	 * If different constructors are needed then they may be used but not 
	 * included in the R Api (i.e. not annotated with @RMethod. </br>
	 * 
	 * Static factory methods can be used instead.
	 * @param logMessage - a message which will be logged
	 */
	@RMethod(examples = {
			"J = testRapi::JavaApi$new()",
			"minExample = J$FeatureTest$new('Hello, java constructor!')",
		})
	public FeatureTest(String logMessage) {
		log.info(logMessage);
		this.message = logMessage;
	}
	
	
	/**
	 * Description of a hello world function
	 * @return this java method returns a String
	 */
	@RMethod(examples = {
					"An example",
					"Spans many lines"
			})
	public RCharacter doHelloWorld() {
		return RConverter.convert("Hello world from Java!");
	}
	
	/**
	 * A fluent method which updates the message in this object, returning the
	 * same object. This is differentiated from factory methods which produce a new
	 * instance of the same class by checking to see if the returned Java object is in the
	 * same memory location as the calling Java object.  
	 * @param message the message is a string
	 * @return this should return exactly the same R6 object.
	 */
	@RMethod
	public FeatureTest fluentSetMessage(RCharacter message) {
		this.message = message.toString();
		return this;
	}
	
	/**
	 * A fluent method description
	 * @param message the message is a string
	 * @return A MoreFeatureTest R6 reference
	 */
	@RMethod
	public MoreFeatureTest factoryMethod(RCharacter a, RCharacter b) {
		return new MoreFeatureTest(a,b);
	}
	
	/**
	 * message desciption
	 * @return The message previously set or maybe null
	 */
	@RMethod
	public RCharacter getMessage() {
		return RConverter.convert(message);
	}
	
	/**
	 * The doSum function description = it adds two numerics
	 * @param a the A parameter
	 * @param b the B parameter
	 * @return A+B of course
	 */
	@RMethod
	public RNumeric doSum(RNumeric a, RNumeric b) {
		return RConverter.convert(a.get()+b.get());
	}
	
	
	/**
	 * Do sum 2 uses native ints rather than RNumerics
	 * It shoudl throw an error if given something that cannot be an integer 
	 * @param a the A parameter
	 * @param b the B parameter
	 * @return A+B of course
	 */
	@RMethod
	public int doSum2(int a, int b) {
		return a+b;
	}
	
	
	@RMethod
	public String objectAsParameter(MoreFeatureTest otherObj) {
		return otherObj.toString();
	}
	
	/**
	 * Consumes a data frame and logs its length
	 * @param dataframe
	 */
	@RMethod
	public void doSomethingWithDataFrame(RDataframe dataframe) {
		log.info("dataframe length: "+dataframe.nrow());
	}
	
	/**
	 * Creates a basic dataframe and returns it
	 */
	@RMethod
	public RDataframe generateDataFrame() {
		RDataframe out = new RDataframe();
		for (int i=0; i<10; i++) {
			Map<String,Object> tmp = new LinkedHashMap<String,Object>();
			tmp.put("index", i);
			tmp.put("value", 10-i);
			out.addRow(tmp);
		}
		return out;
		
	}
	
	/**
	 * Static methods are also supported. These are accessed through the
	 * root of the R api.
	 * @param message
	 */
	@RMethod(examples = {
			"J = testRapi::JavaApi$new()",
			"J$FeatureTest$demoStatic('Ola, el mundo')",
	})
	public static void demoStatic(String message) {
		log.info(message);
	}
	
	
	/**
	 * A copy of the ggplot2::diamonds dataframe serialised into java, using
	 * RObject.writeRDS, saved within the jar file of the package, and exposed here
	 * using RObject.readRDS. 
	 */
	@RMethod(examples = {
			"J = testRapi::JavaApi$new()",
			"J$FeatureTest$diamonds()",
	})
	public static RDataframe diamonds() throws IOException {
		return RObject.readRDS(RDataframe.class, FeatureTest.class.getResourceAsStream("/diamonds.ser"));
	}
}
