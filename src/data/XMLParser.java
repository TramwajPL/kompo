package data;

import java.io.*;

import com.thoughtworks.xstream.XStream;

import logic.TravelInformation;
/**
 *Klasa s�u��ca zapisowi i odczytowi 
 *danych z plik�w xml.
 */
public class XMLParser {
	
	/**
	 * Funkcja wpisuj�ca informacje zawarte w Travelinformation do 
	 * pliku xml
	 * @param info
	 */
	public void convert(TravelInformation info) {
		XStream xstream = new XStream();
		String xml = xstream.toXML(info);

        BufferedReader reader = new BufferedReader(new StringReader(xml));
        BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("../xml.xml", true));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

        try {
			while ((xml = reader.readLine()) != null) {

			    try {
					writer.write(xml + System.getProperty("line.separator"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	/**
	 * Funkcja wpisuj�ca informacje zawarte w pliku xml do 
	 * Travelinformation
	 * @param info
	 */
	public TravelInformation convertFromXml(TravelInformation info) {
		SpeedContainer speeds = new SpeedContainer();
		XStream xstream = new XStream();
		File plik = new File("../xml.xml");
		info = (TravelInformation)xstream.fromXML(plik);	
		return info;
    }
}
