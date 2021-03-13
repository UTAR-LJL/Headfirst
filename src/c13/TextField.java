package c13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextField {
	JTextField field;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextField tf = new TextField();
		tf.go();
	}
	
	void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    field = new JTextField(20);
		field.addActionListener(new Action1());
		JTextField field2 = new JTextField("your name");
		
		frame.getContentPane().add(BorderLayout.NORTH,field);
		frame.getContentPane().add(BorderLayout.SOUTH, field2);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	class Action1 implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			field.setText("jlk;");
		}
	}
}
