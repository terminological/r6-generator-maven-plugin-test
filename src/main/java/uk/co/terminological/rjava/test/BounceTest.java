package uk.co.terminological.rjava.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.*;

@RClass
public class BounceTest {

	Logger log = LoggerFactory.getLogger(BounceTest.class);
		
	@RMethod
	public BounceTest() {
		log.info("Tests the round tripping of supported datatypes");
	}
	
	@RMethod
	public void bounceVoid() {
		log.info("java void");
	}
	
	@RMethod
	public int bounceInt(int x) {
		log.info("java: "+x);
		return x;
	}
	
	@RMethod
	public double bounceDouble(double x) {
		log.info("java: "+x);
		return x;
	}
	
	@RMethod
	public String bounceString(String x) {
		log.info("java: "+x);
		return x;
	}
	
	@RMethod
	public RNull bounceNull(RNull x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RCharacter bounceCharacter(RCharacter x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RCharacterVector bounceCharacterVector(RCharacterVector x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RInteger bounceInteger(RInteger x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RIntegerVector bounceIntegerVector(RIntegerVector x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RDate bounceDate(RDate x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RDateVector bounceDateVector(RDateVector x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RFactor bounceFactor(RFactor x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RFactorVector bounceFactorVector(RFactorVector x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RLogical bounceLogical(RLogical x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RLogicalVector bounceLogicalVector(RLogicalVector x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RNumeric bounceNumeric(RNumeric x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RNumericVector bounceNumericVector(RNumericVector x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RDataframe bounceDataframe(RDataframe x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		System.out.println(x.rConversion());
		return x;
	}
	
	@RMethod
	public RList bounceList(RList x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
	
	@RMethod
	public RNamedList bounceNamedList(RNamedList x) {
		log.info("java: "+x);
		System.out.println(x.rCode());
		return x;
	}
//	
//	@RMethod
//	public RMatrix<?> bounceMatrix(RMatrix<?> x) {
//		log.info("java: "+x);
//		return x;
//	}
	
}
