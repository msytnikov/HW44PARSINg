//  Streaming API for XML

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXHW44 {
	public static void main(String args[]) throws XMLStreamException, IOException {

		URL url = new URL("http://learn2test.net/sdc.xml");

	

		

		
		XMLStreamReader r = XMLInputFactory.newInstance().createXMLStreamReader(url.openStream());
		int eventType = r.getEventType();
		
		while (r.hasNext()) {

		eventType = r.next();

		if (eventType == XMLStreamReader.START_ELEMENT) {
			if (r.getLocalName() == "orig-kw") {
			System.out.println("Key Word: " + r.getElementText());
			}
			if (r.getLocalName() == "engine") {
			System.out.println("Engine: " + r.getElementText());
			}
			if (r.getLocalName() == "kadu-version") {
			System.out.println("Version: " + r.getElementText());
			}
			if (r.getLocalName() == "response-time") {
			System.out.println("Response time: " + r.getElementText());
			}
			if (r.getLocalName() == "deals") {
			System.out.println("Number of deals: " + r.getAttributeValue(0));
			}
		}
		}
	}
}


