package C14;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DungeonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DungeonGame d = new DungeonGame();
		
		System.out.println(d.getX() + d.getY() + d.getZ());
		
		try {
			
			FileOutputStream fos = new FileOutputStream("dg.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(d);
			out.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			
			FileInputStream fis = new FileInputStream("dg.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			DungeonGame d = (DungeonGame) ois.readObject();
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		
	}

}
