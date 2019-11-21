package uk.co.terminological.mavenrjsr233plugintest;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import uk.co.terminological.jsr223.RClass;

import uk.co.terminological.jsr223.RMethod;
import static uk.co.terminological.jsr223.ROutput.*; 

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
	

	@RMethod
	public String objectAsParameter(AnotherTestRApi otherObj) {
		return otherObj.toString();
	}
	
	/**
	 * Should pass and return by reference
	 * @param rowMajorDf
	 */
	@RMethod
	public File fluentRandomObjectAsParamerer(File file) {
		return file;
	}
	
	/**
	 * Should not pass by reference
	 * @param colMajorDf
	 */
	@RMethod
	public void doSomethingWithDataFrame(Map<String,Object[]> colMajorDf) {
		
	}
	
	/**
	 * Should pass by reference unless rowMajor is allowed
	 * @param rowMajorDf
	 */
	@RMethod
	public void doSomethingWithOtherDataFrame(List<Map<String,Object>> rowMajorDf) {
		
	}
	
	/**
	 * Should not pass by reference
	 */
	@RMethod
	public List<Map<String,Object>> generateRowMajorDataFrame() {
		List<Map<String,Object>> out = new ArrayList<Map<String,Object>>();
		for (int i=0; i<10; i++) {
			Map<String,Object> tmp = new LinkedHashMap<String,Object>();
			tmp.put("index", i);
			tmp.put("value", 10-i);
			out.add(tmp);
		}
		return out;
		
	}
	
	/**
	 * Should not pass by reference
	 */
	@RMethod
	public Map<String,Object[]> generateColMajorDataFrame() {
		return 
			Arrays.asList("Hello","World","Stream","Support","in","Java")
			.stream()
			.collect(toDataframe(
					mapping("original", s-> s),
					mapping("lowercase", s-> s.toLowerCase()),
					mapping("uppercase", s-> s.toUpperCase()),
					mapping("subst", s-> s.substring(0,Math.min(3,s.length())))
					));
		
	}
}
