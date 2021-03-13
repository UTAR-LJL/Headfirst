package C14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaverTest {
	public static void main(String[] args) {
		GameCharacter one = new GameCharacter(50, "EJF", new String[] {"bow", "sword", "dust"});
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big ax"});
		 GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});
		
		 try {
			
			 ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			 out.writeObject(one);
			 out.writeObject(two);
			 out.writeObject(three);
			 out.close();
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		one = two = three = null;
		 
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestore = (GameCharacter) in.readObject();
			GameCharacter twoRestore = (GameCharacter) in.readObject();
			GameCharacter threeRestore = (GameCharacter) in.readObject();
			
			System.out.println(oneRestore.getType());
			System.out.println(twoRestore.getType());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
