package exercicio3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipfile{
	private byte[] buffer;
	
	
	public Zipfile() {
		this.buffer = new byte[1024];
	}

 
    public boolean zipar(String source, String name, String path, String exitname){
    	
    	try{
    		
    		FileOutputStream fos = new FileOutputStream(path+"/"+exitname);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry(name);
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(source);
   	   
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();
           
    		//remember close it
    		zos.close();
          
    		System.out.println("Done zip");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
		
	
    	return true;
	}



}	
	
    	
	



