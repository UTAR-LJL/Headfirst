package c13;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List implements ListSelectionListener{
	JList list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List t = new List();
		t.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("click me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JPanel panel = new JPanel();
		
		String [] listEntries = {
				"alpha", "beta", "gamma", "delta", 
				 "epsilon", "zeta", "eta", "theta "
		};
		list = new JList(listEntries);
		list.setVisibleRowCount(4);
		list.addListSelectionListener(this);
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroller = new JScrollPane(list );
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		
		frame.getContentPane().add(panel);
		
		frame.setSize(330,300);
		frame.setVisible(true);
	}
	
	public void valueChanged(ListSelectionEvent lsl) {
		if (!lsl.getValueIsAdjusting()) {
			String selection = (String) list.getSelectedValue();
			System.out.println(selection);
		}
	}
	
}
