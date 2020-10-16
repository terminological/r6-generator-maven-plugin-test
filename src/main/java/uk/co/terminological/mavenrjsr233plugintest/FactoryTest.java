package uk.co.terminological.mavenrjsr233plugintest;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.MapRule;
import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.*;

@RClass
public class FactoryTest {

	Logger log = LoggerFactory.getLogger(FactoryTest.class);
	
	@RMethod
	public FactoryTest() {
		log.info("Tests the java creation of supported datatypes");
	}
	
	@RMethod
	public RCharacter generateCharacter() {
		return RPrimitive.of("Hello world");
	}
	
	@RMethod
	public RNumeric generateNumeric() {
		return RPrimitive.of(123.0);
	}
	
	@RMethod
	public RInteger generateInteger() {
		return RPrimitive.of(345);
	}
	
	public static enum Test {
		ONE,TWO,THREE
	}
	
	@RMethod
	public RFactor generateFactor() {
		return RPrimitive.of(Test.ONE);
	}
	
	@RMethod
	public RLogical generateLogical() {
		return RPrimitive.of(true);
	}
	
	@RMethod
	public RCharacterVector generateCharacterVec() {
		return RVector.with("Hello world","Ola el mundo","Bonjour le monde", null);
	}
	
	@RMethod
	public RNumericVector generateNumericVec() {
		return RVector.with(3.0, 4.3, 2.1, null);
	}
	
	@RMethod
	public RIntegerVector generateIntegerVec() {
		return RVector.with(345, 678, null, 89);
	}
	
	@RMethod
	public RFactorVector generateFactorVec() {
		return RVector.with(Test.ONE,Test.THREE,null,Test.TWO);
	}
	
	@RMethod
	public RLogicalVector generateLogicalVec() {
		return RVector.with(true,false,null);
	}
	
	@RMethod
	public RDataframe generateDataframe() {
		return RDataframe.create()
			.withCol("A", RVector.with(3.0, 4.3, 2.1))
			.withCol("B", RVector.with(Test.ONE,Test.THREE,Test.TWO))
			.withCol("C", RVector.with("Hello world","Ola el mundo","Bonjour le monde"));
	}
	
	@RMethod
	public RDataframe generateStreamDataFrame() {
		return 
			Arrays.asList("Hello","World","Stream","Support","in","Java")
			.stream()
			.collect(RConverter.dataframeCollector(
				MapRule.mapping("original", s-> s),
				MapRule.mapping("lowercase", s-> s.toLowerCase()),
				MapRule.mapping("uppercase", s-> s.toUpperCase()),
				MapRule.mapping("subst", s-> s.substring(0,Math.min(3,s.length()))),
				MapRule.mapping("length", s-> s.length())
			));
		
	}
	
	@RMethod
	public RList generateList() {
		return RList.with("one", Test.TWO, 3.0);
	}
	
	@RMethod
	public RNamedList generateNamedList() {
		return RNamedList
				.with("A","one")
				.and("B", Test.TWO)
				.and("C", RVector.with(3.0, 4.3, 2.1));
	}
}
