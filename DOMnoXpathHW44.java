import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.IOException;

import org.xml.sax.SAXException;

public class DOMnoXpathHW44 {
  //main method= the entry point into the Java program
 	public static void main(String[] args)/*throws ParserConfigurationException, SAXException, IOException*/{	
 		 
 		
		String fileOnMyComuter ="http://learn2test.net/sdc.xml"; // XML file we are parsing into DOM and breaking it down into 
		//meaningful peaces and we can manipulate the structure of the parsed XML document usingDOM format
 		String node1 = "server"; // Child node of the Parent = 'kadu-response'
 		String node2 = "kadu-response"; //Parent of the child 'server'
 		String node3 = "deals"; //Child node of the Parent = 'kadu-response'
 		String attribute1 = "count";// Attribute of the tag <deals> 
 		String element1 = "orig-kw";
 		String element2 = "engine";
 		String element3 = "kadu-version";
 		String element4 = "response-time"; //Tag that has a text node
 		

 	
 		
 			//----------Parsing XML doc on my hard drive
			DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance(); //newInstance returns an Object of DocumentBuilderFactory



			try {
			DocumentBuilder DB = DBF.newDocumentBuilder();
			Document D = DB.parse(fileOnMyComuter);


			// name of the file that we want to parse
			// Parsing = breaking down the traversed XML document into
			//meaningful peaces(Element name, Attribute name, Text nodes and such)
 
			//----------Parsing from Tag 'server'
			//Key Word: sony
			//Engine: phx-dkadu1
			//Version: kadu.6918
			NodeList NL0 = D.getElementsByTagName(node1);//get element by tag name from the D object
			//it will go searching thought the 'server NODE LIST' block and will look for the children we are interested in

			int NL2 = NL0.getLength();//getLength tells us how many elements in that node list 'server'

			for (int i = 0; i< NL2; i++){

			Node  n = NL0.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {			
			Element nodeE1 = (Element) n; // down casting "n" from "Node" to "Element"
			String s =nodeE1.getElementsByTagName(element1).item(0).getChildNodes().item(0).getNodeValue();
			System.out.println("Key Word:		" + s);

			Element nodeE2 = (Element) n; // down casting "n" from "Node" to "Element"
			String s1 =nodeE2.getElementsByTagName(element2).item(0).getChildNodes().item(0).getNodeValue();
			System.out.println("Engine:			" + s1);

			Element nodeE3 = (Element) n; // down casting "n" from "Node" to "Element"
			String s2 =nodeE3.getElementsByTagName(element3).item(0).getChildNodes().item(0).getNodeValue();
			System.out.println("Version:		" + s2);
			}
			}//end of FOR loop
			//----------Parsing from Tag 'kadu-response'
			//Response time: 63929

			NodeList NL5 = D.getElementsByTagName(node2);

			int NL4 = NL5.getLength();

			for (int i = 0; i< NL4; i++){

			Node  n3 = NL5.item(i);
			if (n3.getNodeType() == Node.ELEMENT_NODE) {			
			Element nodeE4 = (Element) n3; // down casting "n" from "Node" to "Element"
			String s3 =nodeE4.getElementsByTagName(element4).item(0).getChildNodes().item(0).getNodeValue();
			 System.out.println("Response time:		" + s3);
			}//end of IF block
			}//end of FOR loop
			//----------Parsing from Tag 'deals', and from attribute 'count'
			//Number of deals: 40

			NodeList NL = D.getElementsByTagName(node3);

			int NL1 = NL.getLength();


			for (int i1 = 0; i1< NL1; i1++){

			Node  n1 = NL.item(i1);

			if (n1.getNodeType() == Node.ELEMENT_NODE) {			
			Element nodeE5 = (Element) n1; // down casting "n" from "Node" to "Element"
			String s4 =nodeE5.getAttribute(attribute1).trim();
			System.out.println("Number of deals:	" + s4);
			}//end of IF block
			}//end of FOR loop
			}//End of try block
 

 		
 	 
	catch (ParserConfigurationException e) {
		e.printStackTrace();
	}//end of catch block

	 catch (SAXException | IOException e) {
		e.printStackTrace();
	} //end of catch block
 	
 	}// end of main method block
 	}//end of class  
