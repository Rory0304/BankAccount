package 프로젝트;

import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/** Frame1 is a frame with a label and a button */
public class Frame1 extends JFrame implements ActionListener{
	/** Constructor  Frame1  creates a frame with a label and button */
	private Frame2 ac;
	public Frame1(Frame2 a){
		ac = a;
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		JButton depo_btn = new JButton("입금");
		cp.add(depo_btn);
		depo_btn.addActionListener(this);
		setTitle("MainOptions");
		setSize(300,500);
		setVisible(true);
		
//    JButton with_btn = new JButton("출금");
//    JButton recent_check = new JButton("최근 거래 내역");
//    Container c = getContentPane();
//    c.setLayout(new FlowLayout());
//    c.add(depo_btn);
//    c.add(with_btn);
//    c.add(recent_check);
//    
//    setTitle("Example1");
//    setSize(300,500);			// pack();
//    setVisible(true);
  }
	public void actionPerformed(ActionEvent e) {
		
	}
	
//	public void paint(Graphics g) {
//		g.setColor(Color.red);
//		g.fillRect(0,0,100,100);
//	}
  
public static void main(String[] args)
  { 
	Frame1 view = new Frame1(model);
  }
}
