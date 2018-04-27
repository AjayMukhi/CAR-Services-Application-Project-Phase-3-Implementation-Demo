/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import model.DaoModel;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author AjayMukhi
 */
public class CarParser {
    
    
    public void carParse() {
		
		String tableName="car";
		DaoModel dao = new DaoModel();
		dao.createCarTable(tableName);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
                        String xmlFile="./src/xmlfiles/cars.xml";
			//File file = new File("./src/xmlfiles/cars.xml");
			Document xmlDoc = builder.parse(new org.xml.sax.InputSource(xmlFile));
			
			xmlDoc.getDocumentElement().normalize();
			System.out.println ("Root element of the doc is " + xmlDoc.getDocumentElement().getNodeName());
			
			NodeList listOfParts = xmlDoc.getElementsByTagName("product");
						
						
			
			for (int i = 0 ; i < listOfParts.getLength() ; i++) {
			    Node node = listOfParts.item(i);
			    List<String> values = Arrays.asList(getAttrValue(node, "id"),
			    		getTextContent(node, "name"),getTextContent(node, "model"),
                                        getTextContent(node, "vin"), getTextContent(node, "description"),
                                        getTextContent(node, "displayunder"),
                                        getTextContent(node, "retailprice"),getTextContent(node, "price"),
                                        getTextContent(node, "engine"),
                                        getTextContent(node, "body"),getTextContent(node, "trans"),
                                        getTextContent(node, "year"),getTextContent(node, "interior"),
                                        getTextContent(node, "exterior"),getTextContent(node, "imageurl") 
			    		);

			    for (int n = 0 ; n < values.size() ; n++) {
			    	System.out.println(values.get(n));
			    }				    
			    
			  //calling the the model to insert the values into the database.
			    dao.insertCars(values,tableName);		    
			  
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
