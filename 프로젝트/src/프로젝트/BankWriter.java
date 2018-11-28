package 프로젝트;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankWriter extends JPanel{
	private int WIDTH = 300;
	private int HEIGHT = 200;
	private BankAccount bank;
	private String last_transaction = "";
	
	public BankWriter(String title, BankAccount b) {
		bank = b;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle(title);
		f.setSize(WIDTH,HEIGHT);
		f.setBackground(Color.WHITE);
		f.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0,0,WIDTH,HEIGHT);
		g.setColor(Color.BLACK);
		int text_margin = 50;
		int text_baseline = 50;
		g.drawString(last_transaction,text_margin,text_baseline);
		g.drawString("현재 잔고는 $" + bank.getBalance(),text_margin,text_baseline + 20);
	}
	
	public void showTransaction(String message) {
		last_transaction = message;
		this.repaint();
	}
}
