import java.io.IOException;
import java.util.jar.Attributes;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XpathDomHW44 {
	public static void main(String[] args){
	String fileOnMyComuter ="http://learn2test.net/sdc.xml";
		String attribute1 = "//deals/@count";// Attribute of the tag <deals> 
		String element1 = "//server/orig-kw";
		String element2 = "//server/engine";
		String element3 = "//server/kadu-version";
		String element4 = "//response-time"; //Tag that has a text node
		
	
		//changes for the git hub
	try {
		
		
	Document dc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileOnMyComuter);
	
	XPath xp = XPathFactory.newInstance().newXPath();
	

	System.out.println("Key Word: " + xp.compile(element1).evaluate(dc));
	System.out.println("Engine: " + xp.compile(element2).evaluate(dc));
	System.out.println("Version: " + xp.compile(element3).evaluate(dc));
	System.out.println("Response time: " + xp.compile(element4).evaluate(dc));
	System.out.println("Number of deals: " + xp.compile(attribute1).evaluate(dc));
 	
//xp.compile(element.   ========Compile an XPath expression for later evaluation
//evaluate(dc)  ================Evaluate the compiled XPath expression in the specified context and return the result as a String.
	
	
	
	} catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}