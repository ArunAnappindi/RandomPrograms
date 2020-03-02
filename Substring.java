package main.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Substring {
	private static DecimalFormat df3 = new DecimalFormat(".###");
	static Map<Substring, String> test1 = new HashMap<>();
	private String arun = "";
	
	
	
	public Substring(String abc) {
		arun = abc;
	}
	
	@Override
	public int hashCode() {
		System.out.println("InHashcode");
		return 6;
	}
	
	@Override
	public boolean equals(Object test) {
		System.out.println("InHashcodeEquals");
		
		return true;
	}
	
	
	public void put() {
		//test.put("arunqqq", "testq");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//String a = "$setview /vobs/com_util/tools/scripts/ppack.py -t i386 /vobs/com_util/packages/h2_o2less_ocroot-oc.xml $VROOT/package ${VIEW} |& tee ${BF_STEPNAME}/packages/.log";
		
		File f = new File("C:\\Users\\503054866\\eclipse-workspace\\Practise\\src\\resources\\xml\\Test_Update.txt");
		FileReader fis = new FileReader(f);
		BufferedReader bis = new BufferedReader(fis);
		String a = bis.readLine();
		/*while(a != null) {
		
		
			String[] strArray = a.split(" ");
			
			String[] xmlNameArray = strArray[4].split("/");
			
			String xmlName = xmlNameArray[4];
			
			String name = xmlName.replaceAll(".xml", "");
			
			
			System.out.println(a+"/"+name+".log");
			
			a = bis.readLine();
		}*/
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter("C:\\Users\\503054866\\eclipse-workspace\\Practise\\src\\resources\\xml\\generated.txt"));
		while(a != null) {
			String[] strArray = a.split(" from ");
			String fileName = strArray[0];
			System.out.println(fileName);
			a = bis.readLine();
			
			 
			 writer.append("\n");
			 writer.append(fileName);
		    
		}
		writer.close();
		fis.close();
		bis.close();
		/*int CENTER_DOSE_FACTOR = 32;
		double PERIPHERY_DOSE_FACTOR = 2.0 / 3.0;
		double pitch =17;
		double pitchDoubleValue = pitch/CENTER_DOSE_FACTOR;
		double pitchValue = Double.parseDouble((new DecimalFormat(".###").format(pitchDoubleValue)));
		String paramName = "32x0.625S";*/
		
		//System.out.println(pitchValue);
		//String test = "0.535:1";
		/*if ((paramName.indexOf(",,") != -1) || (paramName.indexOf("..") != -1)) {
		//	System.out.println("true");
		}
			
			
		String[] testabs = test.split(":");
		double pitch = Double.parseDouble(testabs[0]);
		System.out.println(pitch);
		int no = 32;
		double width = 0.625;
		
		System.out.println( String.valueOf(no) + "   " + String.valueOf(width));*/
		
	}

}
