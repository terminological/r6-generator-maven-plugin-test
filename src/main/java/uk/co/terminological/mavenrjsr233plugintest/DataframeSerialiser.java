package uk.co.terminological.mavenrjsr233plugintest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RDataframe;

/** Actually useful class which takes an R dataframe and a filename
 * string and serialises the dataframe so it can be used natively in java
 * for testing purposes.
 * @author terminological
 *
 */
@RClass
public class DataframeSerialiser {

	Logger log = LoggerFactory.getLogger(DataframeSerialiser.class);
	
	@RMethod
	public void serialise(RDataframe dataframe, String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dataframe);
		oos.flush();
		oos.close();
		fos.close();
	}
	
}
