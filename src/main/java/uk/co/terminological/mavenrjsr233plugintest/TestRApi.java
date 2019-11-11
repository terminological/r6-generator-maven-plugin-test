package uk.co.terminological.mavenrjsr233plugintest;

import uk.co.terminological.jsr223.RClass;
import uk.co.terminological.jsr223.RMethod;

@RClass(
		licence = "MIT", 
		packageName = "apitest", 
		title = "Some function",
		version = "0.1"
		)
public class TestRApi {

	String message;
	
	@RMethod(title = "Shows a hello world message")
	public String doHelloWorld() {
		return "Hello world from Java!";
	}
	
	@RMethod(title = "sets a message")
	public TestRApi fluentSetMessage(String message) {
		this.message = message;
		return this;
	}
	
	@RMethod(title = "gets the message")
	public String getMessage() {
		return message;
	}
	
	@RMethod(title = "does a sum")
	public int doSum(int a, int b) {
		return a+b;
	}
}
