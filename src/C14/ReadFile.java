package C14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

import com.sun.java.util.jar.pack.Package.File;
import com.sun.org.apache.bcel.internal.classfile.Field;

public class ReadFile {
	
	public static void main(String[] args) {
		
		try {
			
			File myFile = new File("C:\\Users\\13358\\eclipse-workspace\\Headfirst\\src\\C14\\MyText.txt");
			FileReader fileReader = new FileReader(myFile);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while( (line = reader.readLine() ) != null) {
				System.out.println(line);
			}
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
}
