package data;

import java.io.File;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLParser {
	public void convert(SpeedContainer speeds) {
	     
        JAXBContext jaxbContext;
        Marshaller jaxbMarshaller;
		try {
			jaxbContext = JAXBContext.newInstance(SpeedContainer.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
	        
	        FileWriter writer = new FileWriter("book.xml");
	        jaxbMarshaller.marshal(speeds, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
		}        
    }
	
	public SpeedContainer convert() {
		SpeedContainer speeds = new SpeedContainer();
		File file = null;
        JAXBContext jaxbContext;
        file = new File("events.xml");
        if(file.exists()==false) {
        	System.err.println("Plik nie istnieje");
        	return speeds;
        }
		try {
	        file = new File("events.xml");

			jaxbContext = JAXBContext.newInstance(SpeedContainer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    speeds = (SpeedContainer) jaxbUnmarshaller.unmarshal(file);
		
		} catch (JAXBException e) {
			System.err.println("Problem z konwertowaniem"); 
		}		
		return speeds;
    }
}
