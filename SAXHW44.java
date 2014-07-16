import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SAXHW44 {
 
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			
		
		DefaultHandler dh= new DefaultHandler(){
		
			private Object e;
	 
/*
		public void startDocument() throws SAXException{
			//System.out.println("Prasing has began...");
			}
			
			public void endDocument(){
				//System.out.println("Prasing Just endededed");
			}
			
		public void startElement(String namespace, String localName, String qName, Attributes attribute) throws SAXException{
				//System.out.println( attribute);*/
				  
			public void startElement(String namespace, String localName, String qName, Attributes attribute)
					throws SAXException {
			
			e = qName;
				
				   if(e.equals("deals")){
					   int count = Integer.parseInt(attribute.getValue(0));
					   System.out.println("Number of deals: " + count + "  ");
				   }
				  
				  
				  
				  
				  
			}
			@Override

public void endElement(String namespace, String localName, String qName) throws SAXException{
				e= "";
				int count = -1;
 
			}
			@Override
public void characters(char [] charactersArray, int started, int lengthOfTeInBetweenTheTags){
				//changes for the git hub
	if(e.equals("orig-kw")){
		//System.out.print ("Key Word: ");
		String s1 = new String (charactersArray, started, lengthOfTeInBetweenTheTags );
		System.out.println ("Key Word: " +  s1 + "  ");
	
}		
		if(e.equals("engine")){
			String s2 = new String (charactersArray, started, lengthOfTeInBetweenTheTags );
			System.out.println ("Engine: " + s2  + "  ");
			
		
		}
		
		if(e.equals("kadu-version")){
			String s3 = new String (charactersArray, started, lengthOfTeInBetweenTheTags );
			System.out.println ("Version: " + s3 + "  " );
			}
		if(e.equals("response-time")){
			String s4 = new String (charactersArray, started, lengthOfTeInBetweenTheTags );
			System.out.println ("Response time: " + s4  + "  ");
			}
	
		
}

		};
		saxParser.parse("http://learn2test.net/sdc.xml", dh); 	

		}
	}
