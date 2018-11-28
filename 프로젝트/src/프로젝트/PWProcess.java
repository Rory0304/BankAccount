package 프로젝트;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PWProcess extends JFrame {
	JButton[] buttons = new JButton[12];
	String num[] = {"1","2","3","4","5","6","7","8","9","OK","0","X"};
	public PWProcess(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		for(int i=0;i<12;i++) {
			buttons[i] = new JButton(num[i]);
			buttons[i].setPreferredSize(new Dimension(45,45));
			c.add(buttons[i]);
		}
		setTitle("Example2");
		setSize(300,500);			// pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PWProcess();
	}

}
