package main.java;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApertureParser {

	public static void main(String[] args) {

		try {

			File helicalShutterConfigFile = new File("C:\\\\Users\\\\503054866\\\\eclipse-workspace\\\\Practise\\\\src\\\\resources\\\\xml\\\\Ctdi.xml");
			String rowNum = String.valueOf(16);
			String rowWidth = String.valueOf(0.625);
			if (!helicalShutterConfigFile.exists()) {
				System.out.println("HelicalShutter: /usr/g/config/Ctdi.xml FILE NOT FOUND");
				throw new FileNotFoundException();
			}
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(helicalShutterConfigFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getDocumentElement().getElementsByTagName("FocalSpot");
			 double apertureIndex = 0.0;
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (eElement.getAttribute("name").equals("SMALL")) {
						NodeList focalSpotList = nNode.getChildNodes();
						for (int j = 0; j < focalSpotList.getLength(); j++) {
							Node macroRowNumNode = focalSpotList.item(j);
							if (macroRowNumNode.getNodeType() == Node.ELEMENT_NODE) {
								Element macroRowNumElement = (Element) macroRowNumNode;
								if (macroRowNumElement.getAttribute("name").equals(rowNum)) {
									NodeList macroRowWidthList = macroRowNumNode.getChildNodes();	
									for (int k = 0; k < macroRowWidthList.getLength(); k++) {
										Node macroRowWidthNode = macroRowWidthList.item(k);
										if (macroRowWidthNode.getNodeType() == Node.ELEMENT_NODE) {
											Element macroRowWidthElement = (Element) macroRowWidthNode;	
											if (macroRowWidthElement.getAttribute("name").equals(rowWidth)) {
													 String aperureFactor = macroRowWidthElement.getAttribute("value");
													 apertureIndex = Double.parseDouble(aperureFactor);
													 System.out.println(apertureIndex);
													 break;
									 		 }
										}
									}
								}
							}
						}
					}
				}
			}
		//	return apertureIndex;
		} catch(Exception e) {
			
		}
		
		
		
		
	}

}
