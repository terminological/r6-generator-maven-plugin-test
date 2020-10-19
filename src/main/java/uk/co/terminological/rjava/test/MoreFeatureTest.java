package uk.co.terminological.rjava.test;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RCharacter;
import uk.co.terminological.rjava.types.RDataframe;
import uk.co.terminological.rjava.types.RObject;


/**
 * This has no documentation
 */
@RClass
public class MoreFeatureTest {

	String message1;
	String message2;
	
	static Logger log = LoggerFactory.getLogger(MoreFeatureTest.class); 
	
	/**
	 * the first constructor is used if there are none annotated 
	 * @param message1 - the message to be printed 
	 * @param message2 - will be used for toString
	 */
	public MoreFeatureTest(RCharacter message1, RCharacter message2) {
		this.message1 = message1.toString();
		this.message2 = message2.toString();
		log.warn("A warning");
		log.info("A info");
		log.debug("A debug");
		log.trace("A trace");
	}
	
	/** A static object constructor
	 * @param message1
	 * @param message2
	 * @return
	 */
	@RMethod(examples = {
		"J = testRapi::JavaApi$new()",
		"J$MoreFeatureTest$create('Hello,',' World')",
	})
	public static MoreFeatureTest create(RCharacter message1, RCharacter message2) {
		return new MoreFeatureTest(message1,message2);
	}
	
	@RMethod
	public static RCharacter concat(RCharacter message1, RCharacter message2) {
		return RConverter.convert(message1.toString()+message2.toString());
	}
		
	@RMethod
	public RCharacter throwCatchable() throws Exception {
		throw new Exception("A catchable exception has been thrown");
	}
	
	@RMethod
	public void printMessage() {
		System.out.println("Printed in java: "+message1);
	}
	
	@RMethod
	public RCharacter throwRuntime() {
		throw new RuntimeException("A runtime exception has been thrown");
	}
	
	public String toString() {
		return "toString: "+message2;
	}
	
	
}
