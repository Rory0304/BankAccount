package ������Ʈ;

import javax.swing.*;
import java.awt.*;

public class Frame2 extends JFrame{
	private AccountController ac;
	TextField want_price;
	public Frame2() {
		//contentpane�� ������Ʈ�� �÷� ���� �� �ִ� ����
		Container cp = getContentPane();
		cp.setLayout(null);
		//flowlayout�� ������Ʈ���� ���ʿ��� ���������� �߰��Ǵ� ����
		JLabel input_label = new JLabel("���Ͻô� �ݾ��� �Է��ϼ���");
		cp.add(input_label);
		input_label.setBounds(58,50,200,50);
		want_price = new TextField();
		JButton depo_btn = new JButton("�Ա�");
		cp.add(want_price);
		cp.add(depo_btn);
		cp.add(new ExitButton("���"));
		want_price.setBounds(45,110,190,40);
		want_price.getText();
		depo_btn.setBounds(30,170,60,30);
//		cancel.setBounds(100,170,60,30);
		setSize(300,500);
		setVisible(true);		
	}
	
	public static void main(String[] args)
	  { 
		new Frame2();
	  }
	
}
