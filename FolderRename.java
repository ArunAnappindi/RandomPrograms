package main.java;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class FolderRename {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			
				rename("C:\\Users\\503054866\\NGX\\");
		}
	}
	
	
	
	public static void rename(String folderPath) {
		
		try {
		 // Path of folder where files are located 
        String folder_path = 
        		folderPath; 
  
        // creating new folder 
        File parentFolder = new File(folder_path); 
  
        File[] file_array = parentFolder.listFiles(); 
        for (int i = 0; i < file_array.length; i++) 
        { 
  
            if (file_array[i].isDirectory()) 
            { 
            	
            	/*rename(file_array[i].getPath());
            } else {*/
                /*File myfile = new File(folder_path + 
                         "\\" + file_array[i].getName()); 
                String long_file_name = file_array[i].getName(); 
                String[] tokens = long_file_name.split("\\s"); 
                String new_file_name = tokens[1]; 
                System.out.println(long_file_name); 
                System.out.print(new_file_name); 
  
                // file name format: "Snapshot 11 (12-05-2017 11-57).png" 
                // To Shorten it to "11.png", get the substring which 
                // starts after the first space character in the long 
                // _file_name. 
                myfile.renameTo(new File(folder_path + 
                             "\\" + new_file_name + ".png")); */
            	
            	
            	File myfolder = new File(folder_path + 
                        "\\" + file_array[i].getName()); 
               String long_file_name = file_array[i].getName(); 
               
               if (long_file_name.contains("cine")) {
            	   String newFileName = long_file_name.replaceAll("cine", "helical");
            	   System.out.println(folder_path +"  FileName  "  +long_file_name + "   NewFileName:  "+ newFileName); 
            	  myfolder.renameTo(new File(folder_path + "\\" + newFileName));
            	  // rename(folder_path + "\\" + newFileName);
            	   
            	   //Deleting folders recursively
            	   
            	  // System.out.println(folder_path + "\\" + long_file_name); 
            	   //myfolder.renameTo(new File(folder_path + "\\" + newFileName));
            	   
            	   rename(folder_path + "\\" + newFileName);
            	   
            	  // FileUtils.deleteQuietly(new File(folder_path + "\\" + long_file_name));
            	   
            	   
               }
               
               rename(folder_path + "\\" + file_array[i].getName());
               
 
               // file name format: "Snapshot 11 (12-05-2017 11-57).png" 
               // To Shorten it to "11.png", get the substring which 
               // starts after the first space character in the long 
               // _file_name. 
            //   myfolder.renameTo(new File(folder_path + 
              //              "\\" + new_file_name + ".png")); 
            	
            } 
        }
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
