package parser;

/** Program to parse the parts xml  and load into the database
 *  Programmed by Ajay and Karan 
 *  for Project SOA -566
 */
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.DaoModel;

public class PartsParser {
	
	 
	public void partsParse() {
		
		String tableName="carParts";
		DaoModel dao = new DaoModel();
		dao.createPartsTable(tableName);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
                        String xmlFile="./src/xmlfiles/parts.xml";
			//File file = new File("./src/xmlfiles/parts.xml");
			Document xmlDoc = builder.parse(new org.xml.sax.InputSource(xmlFile));
			
			xmlDoc.getDocumentElement().normalize();
			System.out.println ("Root element of the doc is " + xmlDoc.getDocumentElement().getNodeName());
			
			NodeList listOfParts = xmlDoc.getElementsByTagName("part");
						
						
			
			for (int i = 0 ; i < listOfParts.getLength() ; i++) {
			    Node node = listOfParts.item(i);
			    List<String> values = Arrays.asList(getAttrValue(node, "id"),
			    		getTextContent(node, "name"),getTextContent(node, "type"),
                                        getTextContent(node, "description"),getTextContent(node, "retailprice"),
			    		getTextContent(node, "price"),getTextContent(node, "color") ,
                                        getTextContent(node, "sku"),getTextContent(node, "stock"),
			    		getTextContent(node, "quantitystock"),getTextContent(node, "imageurl") 
			    		);

			    for (int n = 0 ; n < values.size() ; n++) {
			    	System.out.println(values.get(n));
			    }				    
			    
			  //calling the the model to insert the values into the database.
			    dao.insertCarParts(values,tableName);		    
			  
			}
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}

	static private String getAttrValue(Node node,String attrName) {

	    if ( ! node.hasAttributes() ) 
	    	return "";
	    
	    NamedNodeMap nmap = node.getAttributes();
	    if ( nmap == null ) 
	    	return "";
	    
	    Node n = nmap.getNamedItem(attrName);
	    if ( n == null ) 
	    	return "";
	         
	    return n.getNodeValue();

	}

	static private String getTextContent(Node parentNode,String childName) {

	    NodeList nlist = parentNode.getChildNodes();
	    for (int i = 0 ; i < nlist.getLength() ; i++) {
	          Node n = nlist.item(i);
	          String name = n.getNodeName();	          
	          
	          if ( name != null && name.equals(childName) )
	              return n.getTextContent();
	          }

	    return "";

	}
		

	
}
