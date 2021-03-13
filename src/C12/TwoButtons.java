package C12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TwoButtons {
	
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoButtons t = new TwoButtons();
		t.go();
	}
	
	void go() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("color");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("this is a label");
		MyDrawPanel dp = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.getContentPane().add(BorderLayout.CENTER, dp);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}
	
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String s = Math.random() + "";
			label.setText(s);
		}
	}
	
	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

}
