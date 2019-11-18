package uk.co.terminological.mavenrjsr233plugintest;

import uk.co.terminological.jsr223.RClass;
import uk.co.terminological.jsr223.RMethod;


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
public class TestRApi {

	String message;
	
	/**
	 * Description of a hello world function
	 * @return this java method returns a String
	 */
	@RMethod(examples = {
					"An example",
					"Spans many lines"
			})
	public String doHelloWorld() {
		return "Hello world from Java!";
	}
	
	/**
	 * A fluent method description
	 * @param message the message is a string
	 * @return nothing as this is a fluent method
	 */
	@RMethod
	public TestRApi fluentSetMessage(String message) {
		this.message = message;
		return this;
	}
	
	/**
	 * A fluent method description
	 * @param message the message is a string
	 * @return nothing as this is a fluent method
	 */
	@RMethod
	public AnotherTestRApi factoryMethod(String a, String b) {
		return new AnotherTestRApi(a,b);
	}
	
	/**
	 * message desciption
	 * @return A message previously set or maybe null
	 */
	@RMethod
	public String getMessage() {
		return message;
	}
	
	/**
	 * The doSum function description
	 * @param a the A parameter
	 * @param b the B parameter
	 * @return A+B of course
	 */
	@RMethod
	public Double doSum(Double a, Double b) {
		return a+b;
	}
}
