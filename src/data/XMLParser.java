package data;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;

import logic.TravelInformation;

/**
 *Klasa s�u��ca zapisowi i odczytowi 
 *danych z plik�w xml.
 */
public class XMLParser {
	private TravelInformation info = new TravelInformation();
	
	public void convert(TravelInformation info) {
		XStream xstream = new XStream();
		xstream.alias("person", SpeedContainer.class);
		String xml = xstream.toXML(info);      
    }
	
	public TravelInformation convert() {
		SpeedContainer speeds = new SpeedContainer();
		XStream xstream = new XStream();
		File plik = new File("../xml.xml");
		info = (TravelInformation)xstream.fromXML(plik);	
		return info;
    }
}
