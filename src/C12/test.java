package C12;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		//JButton button = new JButton("click me");
		MyDrawPanel p = new MyDrawPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.getContentPane().add(button);
		frame.getContentPane().add(p);
		
		frame.setSize(300,300);
		
		frame.setVisible(true);
	}

}
