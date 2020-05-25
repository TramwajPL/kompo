package data;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;

import logic.TravelInformation;

/**
 *Klasa s³u¿¹ca zapisowi i odczytowi 
 *danych z plików xml.
 */
public class XMLParser {
	
	public void convert(TravelInformation info) {
		XStream xstream = new XStream();
		xstream.alias("info", TravelInformation.class);
		String xml = xstream.toXML(info);      
    }
	
	public TravelInformation convertFromXml(TravelInformation info) {
		SpeedContainer speeds = new SpeedContainer();
		XStream xstream = new XStream();
		File plik = new File("../xml.xml");
		info = (TravelInformation)xstream.fromXML(plik);	
		return info;
    }
}
