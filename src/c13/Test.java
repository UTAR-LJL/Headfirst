package c13;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test implements ItemListener{
	JCheckBox checkBox;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("click me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JButton button = new JButton("fasdffasf");
		//Font bf = new Font("serif", Font.BOLD, 28);
		//button.setFont(bf);
		//frame.getContentPane().add(BorderLayout.NORTH, button);
		
		checkBox = new JCheckBox("Goes to 11");
		checkBox.addItemListener(this);
		JPanel panel = new JPanel();
		panel.add(checkBox);
		
		frame.getContentPane().add(panel);
		
		frame.setSize(330,300);
		frame.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent event) {
		String state = "off";
		if (checkBox.isSelected()) {
			state = "on";
		}
		System.out.println(state);
	}
}
