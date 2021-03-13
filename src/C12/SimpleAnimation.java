package C12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
	
	int x = 70;
	int y = 70;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleAnimation sa = new SimpleAnimation();
		sa.go();
	}
	
	public void go() {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel dp = new MyDrawPanel();
		
		frame.getContentPane().add(dp);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for(int i = 0; i < 130; i ++) {
			
			x ++;
			y ++;
			
			dp.repaint();
			
			try {
				Thread.sleep(50);
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	class MyDrawPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
	}

}
