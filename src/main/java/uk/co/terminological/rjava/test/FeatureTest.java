package uk.co.terminological.rjava.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.RDefault;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RCharacter;
import uk.co.terminological.rjava.types.RDataframe;
import uk.co.terminological.rjava.types.RNumeric;
import uk.co.terminological.rjava.types.RObject; 


//START_SNIP_1
/**
 * A test of the R6 generator templating
 * 
 * The feature test should allow mathjax in javadoc
 * 
 * $$e = mc^2$$
 * 
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
	 * A maximum of one constructor of any signature can be used. <br>
	 * 
	 * If different constructors are needed then they may be used but not 
	 * included in the R Api (i.e. not annotated with @RMethod.) <br>
	 * 
	 * Static factory methods can be used instead.
	 * @param logMessage - a message which will be logged
	 */
	@RMethod(examples = {
			"minExample = J$FeatureTest$new('Hello from Java constructor!')",
		})
	public FeatureTest(String logMessage) {
		log.info(logMessage);
		this.message = logMessage;
	}
	
	//END_SNIP_1
	//START_SNIP_2
	
	/**
	 * Description of a hello world function
	 * @return this java method returns a String
	 */
	@RMethod(examples = {
			"minExample = J$FeatureTest$new('Hello, R World!')",
			"minExample$doHelloWorld()"
		})
	public RCharacter doHelloWorld() {
		return RConverter.convert("Hello world from Java!");
	}
		
	/**
	 * The doSum function description = it adds two numerics
	 * @param a the A parameter, can be NA
	 * @param b the B parameter
	 * @return A+B of course, NAs in inputs are converted to null in Java. This catches the resulting NPE in java idiom and returns an explicit NA. 
	 * This only matters if you care about the difference between NA_real_ and NaN in R. 
	 */
	@RMethod
	public RNumeric doSum(RNumeric a, RNumeric b) {
		try {
			return RConverter.convert(a.get()+b.get());
		} catch (NullPointerException e) {
			log.info("Java threw a NPE - could have had a NA input?");
			return RNumeric.NA;
		}
	}
	
	
	/**
	 * Do sum 2 uses native ints rather than RNumerics
	 * It should throw an error if given something that cannot be coerced to an integer. 
	 * This also demonstrated the use of the `@RDefault` annotation
	 * @param a the A parameter
	 * @param b the B parameter
	 * @return A+B of course
	 */
	@RMethod
	public int doSum2(int a, @RDefault(rCode = "10") int b) {
		return a+b;
	}
	
	/**
	 * Static methods are also supported. These are accessed through the
	 * root of the R api.
	 * @param message a message
	 */
	@RMethod(examples = {
			"J$FeatureTest$demoStatic('Ola, el mundo')",
	})
	public static void demoStatic(String message) {
		log.info(message);
	}
	
	//END_SNIP_2
	//START_SNIP_3
	
	/**
	 * message desciption
	 * @return The message (previously set by the constructor)
	 */
	@RMethod
	public RCharacter getMessage() {
		return RConverter.convert(message);
	}	
	
	/**
	 * A fluent method which updates the message in this object, returning the
	 * same object. This is differentiated from factory methods which produce a new
	 * instance of the same class by checking to see if the returned Java object is equal
	 * to the calling Java object.  
	 * @param message the message is a string
	 * @return this should return exactly the same R6 object.
	 */
	@RMethod
	public FeatureTest fluentSetMessage(@RDefault(rCode = "\"hello\nworld\"") RCharacter message) {
		this.message = message.toString();
		return this;
	}
	
	//END_SNIP_3
	//START_SNIP_4
	
	/**
	 * A factory or builder method which constructs an object of another class from some parameters 
	 * @param a the first parameter
	 * @param b the second parameter
	 * @return A MoreFeatureTest R6 reference
	 */
	@RMethod
	public MoreFeatureTest factoryMethod(RCharacter a, @RDefault(rCode = "as.character(Sys.Date())") RCharacter b) {
		return new MoreFeatureTest(a,b);
	}
	
	@RMethod
	public String objectAsParameter(MoreFeatureTest otherObj) {
		return otherObj.toString();
	}

	//END_SNIP_4
	//START_SNIP_5
	
	/**
	 * Consumes a data frame and logs its length
	 * @param dataframe a dataframe
	 */
	@RMethod
	public void doSomethingWithDataFrame(RDataframe dataframe) {
		log.info("dataframe length: "+dataframe.nrow());
	}
	
	/**
	 * Creates a basic dataframe and returns it
	 * @return a daatframe
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
	 * A copy of the ggplot2::diamonds dataframe serialised into java, using
	 * RObject.writeRDS, saved within the jar file of the package, and exposed here
	 * using RObject.readRDS. 
	 * @return the ggplot2::diamonds dataframe
	 * @throws IOException if the serialised data file could not be found 
	 */
	@RMethod(examples = {
			"J$FeatureTest$diamonds()",
	})
	public static RDataframe diamonds() throws IOException {
		InputStream is = FeatureTest.class.getResourceAsStream("/diamonds.ser");
		if(is==null) throw new IOException("Could not locate /diamonds.ser");
		return RObject.readRDS(RDataframe.class, is);
	}
	
	//END_SNIP_5
	//START_SNIP_1
}
//END_SNIP_1
