package uk.co.terminological.mavenrjsr233plugintest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RDataframe;

//
/**
 * This class is a very basic example of the features of the rJava maven plugin. <br/>
 * 
 * The class is annotated with an @RClass to identify it as part of the R API. <br/>
 * 
 * R code and documentation will be generated to allow the use of these functions in R through 
 * R6 Classes.
 * 
 * @author rob challen
 */
@RClass
public class MinimalExample {

	// the logging system is SLF4J - the backend is Log4J2
	static Logger log = LoggerFactory.getLogger(MinimalExample.class);
	
	// 
	
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
		"minExample = J$MinimalExample$new('initialising....')",
	})
	public MinimalExample(String logMessage) {
		log.info(logMessage);
	}
	
	
	@RMethod(examples = {
		"J = testRapi::JavaApi$new()",
		"minExample = J$MinimalExample$new()",
		"dfTest = tibble::tibble(input=c(1,2,3))",
		"minExample$demo(dataframe=dfTest,message='Hello world')"
	})
	/**
	 * The majority of the documentation of the method can be done in JavaDoc
	 * and these will be reflected in the R documentation 
	 * @param dataframe - a dataframe with an arbitrary number of columns
	 * @param message - a message
	 * @return the dataframe unchanged
	 *  
	 */
	public RDataframe demo(RDataframe dataframe, String message) {
		log.info("this dataframe has nrow="+dataframe.nrow());
		log.info(message);
		return dataframe;
	}
	
	/**
	 * Static methods are also supported. These are accessed through the
	 * root of the R api.
	 * @param message
	 */
	@RMethod(examples = {
			"J = testRapi::JavaApi$new()",
			"J$MinimalExample$demoStatic('Ola, el mundo')",
	})
	public static void demoStatic(String message) {
		log.info(message);
	}
	
}
