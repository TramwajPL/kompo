package data;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;

public class XMLParser {
	public void convert(SpeedContainer speeds) {
		XStream xstream = new XStream();
		xstream.alias("person", SpeedContainer.class);
		String xml = xstream.toXML(speeds);      
    }
	
	public SpeedContainer convert() {
		SpeedContainer speeds = new SpeedContainer();
		XStream xstream = new XStream();
		File plik = new File("../xml.xml");
		speeds = (SpeedContainer)xstream.fromXML(plik);	
		return speeds;
    }
}
