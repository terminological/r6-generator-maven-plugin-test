package uk.co.terminological.mavenrjsr233plugintest;

import uk.co.terminological.jsr223.RClass;
import uk.co.terminological.jsr223.RMethod;


/**
 * This has no documentation
 */
@RClass
public class AnotherTestRApi {

	String message1;
	String message2;
	
	/**
	 * the first constructor is used if there are none annotated 
	 * @param message1 - the message to be printed 
	 * @param message2 - will be used for toString
	 */
	public AnotherTestRApi(String message1, String message2) {
		this.message1 = message1;
		this.message2 = message2;
	}
	
	@RMethod
	public static AnotherTestRApi create(String message1, String message2) {
		return new AnotherTestRApi(message1,message2);
	}
	
	@RMethod
	public static String concat(String message1, String message2) {
		return message1+message2;
	}
	
	@RMethod
	public String throwCatchable() throws Exception {
		throw new Exception("A catchable exception has been thrown");
	}
	
	@RMethod
	public void printMessage() {
		System.out.println("Printed in java: "+message1);
	}
	
	@RMethod
	public String throwRuntime() {
		throw new RuntimeException("A runtime exception has been thrown");
	}
	
	public String toString() {
		return "toString: "+message2;
	}
	
}
