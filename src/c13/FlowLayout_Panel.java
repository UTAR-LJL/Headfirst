package c13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayout_Panel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowLayout_Panel p = new FlowLayout_Panel();
		p.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton button = new JButton("click me");
		JButton buttonTwo = new JButton("bliss");
		JButton buttonThree = new JButton("hush?");
		panel.add(button);
		panel.add(buttonTwo);
		panel.add(buttonThree);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		
		frame.setSize(330,300);
		frame.setVisible(true);
	}
}
