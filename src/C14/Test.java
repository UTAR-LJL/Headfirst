package C14;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test  {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = "sfa sdfs  wr sf ? sfs / sdfa";
		String[] words = line.split("/");
		for(String item : words)
			System.out.println(item);
	}

}
