/**
 * 
 */
package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author 503054866
 *
 */
public class XMLParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		int macroRowNumber = 32;
		double rotationTime = 17.1;
		double pitch = 0.531;
		int gantry_type = 6;
	//	System.out.println( "HelicalShutter: READ HelicalShutter CONFIGURATION:" + " " + macroRowNumber + " " +  rotationTime + " " + pitch + " "+ gantry_type );
		
	//	ShutterParamsType shutterParamsType = new ShutterParamsType();
		
		String aperture = "";
		String product="";
		String rotation="";
		String phase_l="PHASE_1";
		String pitch_l="";
		
		if(gantry_type == 5) {
			product = "VCT";
		} else if(gantry_type == 6) {
			product = "NGX";
		} else if(gantry_type == 1) {
			product = "NGXF";
		}
		
		if(rotationTime >= 0.375) {
			rotation = "OTHER_ROTATIONS";
		} else {
			rotation = "0_35_ROTATION";
		}
		
		int pitchAbs = (int)Math.rint(pitch * 1000);
		switch (pitchAbs) {

		case 531:
			pitch_l = "PITCH_0531";
			break;
		case 969:
			pitch_l = "PITCH_0969";
			break;
		case 1375:
			pitch_l = "PITCH_1375";
			break;
		case 1531:
			pitch_l = "PITCH_1531";
			break;
		case 516:
			pitch_l = "PITCH_1516";
			break;
		case 984:
			pitch_l = "PITCH_0984";
			break;
		default:
			break;
		}
		
		// if macroRowNumber is 20/40  then aperture will be macroRowNumber/macro_row_width(0.625 constant for CJ/Revo) 
		if (macroRowNumber == 32) {
			aperture = "APERTURE_32x";
		} else if (macroRowNumber == 64) {
			aperture = "APERTURE_64x";
		}
		
		try {

			File helicalShutterConfigFile = new File("C:\\Users\\503054866\\eclipse-workspace\\Practise\\src\\resources\\xml\\ngx_legacy_integration.xml");
			
			if (!helicalShutterConfigFile.exists()) {
				System.out.println("HelicalShutter: /usr/g/config/HelicalShutterProperties.xml FILE NOT FOUND");
				throw new FileNotFoundException();
			}
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(helicalShutterConfigFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getDocumentElement().getElementsByTagName("Product");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (eElement.getAttribute("name").equals(product)) {
						NodeList productNodeList = nNode.getChildNodes();
						for (int j = 0; j < productNodeList.getLength(); j++) {
							Node rotationNode = productNodeList.item(j);
							if (rotationNode.getNodeType() == Node.ELEMENT_NODE) {
								Element rotationElement = (Element) rotationNode;
								if (rotationElement.getAttribute("name").equals(rotation)) {
									NodeList phaseNodeList = rotationNode.getChildNodes();
									for (int i = 0; i < phaseNodeList.getLength();i++) {
										Node phaseNode = phaseNodeList.item(i);
										if (phaseNode.getNodeType() == Node.ELEMENT_NODE) {
											Element phaseElement = (Element) phaseNode;
											if (phaseElement.getAttribute("name").equals(phase_l)) {
												NodeList apertureNodeList = phaseNode.getChildNodes();
												for (int k = 0; k < apertureNodeList.getLength(); k++) {
													Node apertureNode = apertureNodeList.item(k);
													if (apertureNode.getNodeType() == Node.ELEMENT_NODE) {
														Element apertureElement = (Element) apertureNode;
														if (apertureElement.getAttribute("name").equals(aperture)) {
															NodeList pitchNodeList = apertureNode.getChildNodes();
															for (int p = 0; p < pitchNodeList.getLength(); p++) {
																Node pitchNode = pitchNodeList.item(p);
																if (pitchNode.getNodeType() == Node.ELEMENT_NODE) {
																	Element pitchElement = (Element) pitchNode;
																	if (pitchElement.getAttribute("name").equals(pitch_l)) {
																		NodeList shutterParameters = pitchNode.getChildNodes();
																		for (int shutterParamLen =0; shutterParamLen <  shutterParameters.getLength(); shutterParamLen++) {
																			 Node shutterParamNode = shutterParameters.item(shutterParamLen);
																			 if (shutterParamNode.getNodeType() == Node.ELEMENT_NODE) {
																				 Element shutterParamElement = (Element) shutterParamNode;
																				 switch (shutterParamElement.getAttribute("name")) {
																					 case "leadCamHoldTimeMsec":
																						 String leadCamHoldTimeMsec = shutterParamElement.getAttribute("value");
																						 long test1 = Long.parseLong(leadCamHoldTimeMsec);
																						 System.out.println("HelicalShutter: leadCamHoldTimeMsec" + test1);
																						 break;
																					 case "leadCamTransitionTimeMsec":
																						 String leadCamTransitionTimeMsec = shutterParamElement.getAttribute("value");
																						 long test2 = Long.parseLong(leadCamTransitionTimeMsec.trim());
																						 System.out.println("HelicalShutter: leadCamTransitionTimeMsec" + test2);
																						 break;
																					 case "leadCamClosePositionMmd":
																						 String leadCamClosePositionMmd = shutterParamElement.getAttribute("value");
																						 long test3 = Long.parseLong(leadCamClosePositionMmd.trim());
																						 System.out.println("HelicalShutter: leadCamClosePositionMmd" + test3);
																						 break;
																					 case "trailingCamHoldTimeMsec":
																						 String trailingCamHoldTimeMsec = shutterParamElement.getAttribute("value");
																						 long test4 = Long.parseLong(trailingCamHoldTimeMsec.trim());
																						 System.out.println("HelicalShutter: trailingCamHoldTimeMsec" + test4);
																						 break;
																					 case "railingCamTransitionTimeMsec":
																						 String railingCamTransitionTimeMsec = shutterParamElement.getAttribute("value");
																						 long test5 =  Long.parseLong(railingCamTransitionTimeMsec.trim());
																						 System.out.println("HelicalShutter: railingCamTransitionTimeMsec" + test5);
																						 break;
																					 case "trailingCamClosePositionMmd":
																						 String trailingCamClosePositionMmd = shutterParamElement.getAttribute("value");
																						 long test6 = Long.parseLong(trailingCamClosePositionMmd.trim());
																						 System.out.println("HelicalShutter: trailingCamClosePositionMmd" + test6);
																						 break;
																					 case "leadCamMarginMmd":
																						 String leadCamMarginMmd = shutterParamElement.getAttribute("value");
																						 float test7 =  Float.parseFloat(leadCamMarginMmd.trim());
																						 System.out.println("HelicalShutter: leadCamMarginMmd" + test7);
																						 break;
																					 case "trailingCamMarginMmd":
																						 String trailingCamMarginMmd = shutterParamElement.getAttribute("value");
																						 float test8 = Float.parseFloat(trailingCamMarginMmd.trim());
																						 System.out.println("HelicalShutter: trailingCamMarginMmd" + test8);
																						 break;
																					 default:
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
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			//System.out.println("HelicalShutter: Exception while fetching shutterinfo from XML");
			e.printStackTrace();
	    }
	}
	
	/*@Activate
	public void activate() {
		logger.info("Inside Helicalshutter config service Activate");
	}*/
	
}

