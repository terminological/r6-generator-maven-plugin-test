package uk.co.terminological.rjava.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RDataframe;
import uk.co.terminological.rjava.types.RList;
import uk.co.terminological.rjava.types.RNamedList;

/** Actually useful class which takes an R dataframe and a filename
 * string and serialises the dataframe so it can be used natively in java
 * for testing purposes.
 * @author terminological
 *
 */
@RClass
public class Serialiser {

	static Logger log = LoggerFactory.getLogger(Serialiser.class);
	
	@RMethod
	public static void serialiseDataframe(RDataframe dataframe, String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		dataframe.writeRDS(fos);
		log.info("dataframe written to: "+filename);
	}
	
	@RMethod
	public static void serialiseList(RList dataframe, String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		dataframe.writeRDS(fos);
		log.info("list written to: "+filename);
	}
	
	@RMethod
	public static void serialiseNamedList(RNamedList dataframe, String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		dataframe.writeRDS(fos);
		log.info("named list written to: "+filename);
	}
	
}
