package 프로젝트;

import javax.swing.*;
import java.awt.*;

public class Frame2 extends JFrame{
	private AccountController ac;
	TextField want_price;
	public Frame2() {
		//contentpane은 컴포넌트를 올려 놓을 수 있는 공간
		Container cp = getContentPane();
		cp.setLayout(null);
		//flowlayout은 컴포넌트들이 왼쪽에서 오른쪽으로 추가되는 형태
		JLabel input_label = new JLabel("원하시는 금액을 입력하세요");
		cp.add(input_label);
		input_label.setBounds(58,50,200,50);
		want_price = new TextField();
		JButton depo_btn = new JButton("입금");
		cp.add(want_price);
		cp.add(depo_btn);
		cp.add(new ExitButton("취소"));
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
