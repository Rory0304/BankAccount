package ������Ʈ;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame{
	
	public MainScreen() {
		
		Container cp = getContentPane();
		cp.setLayout(null);

		JLabel l_main = new JLabel("�Ѿ� ����");
		l_main.setFont(new Font(null, Font.BOLD, 22));
		
		MainController logout = new MainController("�α׾ƿ�");
		logout.setFont(new Font(null, Font.BOLD, 11));

		MainController make_account = new MainController("���� ����");
		make_account.setFont(new Font(null, Font.BOLD, 13));

		MainController deposit = new MainController("�Ա�");
		deposit.setFont(new Font(null, Font.BOLD, 13));

		MainController history = new MainController("�ŷ� ����");
		history.setFont(new Font(null, Font.BOLD, 13));

		MainController withdraw = new MainController("���");		
		withdraw.setFont(new Font(null, Font.BOLD, 13));

		MainController transfer = new MainController("��ü");
		transfer.setFont(new Font(null, Font.BOLD, 13));

		l_main.setBounds(250, 20, 100, 40);
		logout.setBounds(25, 25, 85, 30);
		make_account.setBounds(250, 90, 100, 30);
		deposit.setBounds(250, 130, 100, 30);
		history.setBounds(250, 170, 100, 30);
		withdraw.setBounds(250, 210, 100, 30);
		transfer.setBounds(250, 250, 100, 30);

		cp.add(l_main);
		cp.add(logout);
		cp.add(make_account);
		cp.add(deposit);
		cp.add(withdraw);
		cp.add(history);
		cp.add(transfer);
		
		
		setVisible(true);
		setSize(600, 400);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
