package 프로젝트;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class EnterAmountScreen extends JFrame  {

	private JButton ok, cancel, check_balance;
	private JTextField enter_money, enter_trans_an;
	private JComboBox<String> combo,accombo;
	private BufferedReader user_reader;
	private String label;

	public EnterAmountScreen(String label) {
		this.label = label;
	}

	// 입금,출금 전용
	public void EnterAmountScreen() throws IOException {

		Container cp = getContentPane();
		cp.setLayout(null);
		String line;

		JLabel l_main = new JLabel(label + "할 금액과 원하는 계좌를 입력하세요.");
		l_main.setFont(new Font(null, Font.BOLD, 18));
		enter_money = new JTextField();
		ok = new JButton("확인");
		cancel = new JButton("나가기");
		check_balance = new JButton("잔액");
		
		
		user_reader = new BufferedReader(new FileReader("회원정보.txt"));
		Vector<String> v = new Vector<String>();
		while ((line = user_reader.readLine()) != null) {
			String[] user_info = line.split("/");
			String f_id = user_info[1];
			if (f_id.equals(LogInOut.getR_id())) {
				String an = user_info[4];
				String[] an_info = an.split(",");
				for (int i = 0; i < an_info.length; i++) {
					v.add(an_info[i]);
				}
			}
		}

		combo = new JComboBox<String>(v);

		l_main.setBounds(110, 70, 400, 20);
		enter_money.setBounds(200, 150, 200, 30);
		combo.setBounds(200, 200, 200, 40);
		check_balance.setBounds(170, 300, 80, 40);
		ok.setBounds(260, 300, 80, 40);
		cancel.setBounds(350, 300, 80, 40);

		cp.add(l_main);
		cp.add(enter_money);
		cp.add(combo);
		cp.add(ok);
		cp.add(cancel);
		cp.add(check_balance);

		ok.addActionListener(new EnterAmountController(this,label));
		cancel.addActionListener(new EnterAmountController(this,label));
		check_balance.addActionListener(new EnterAmountController(this,label));

		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 이체 전용
	public void EnterTransScreen() throws IOException {
		String line;
		Container cp = getContentPane();
		cp.setLayout(null);

		JLabel l_main = new JLabel(label + "할 금액과 원하는 계좌를 입력하세요.");
		l_main.setFont(new Font(null, Font.BOLD, 18));

		JLabel l_trans = new JLabel("이체할 계좌  ");
		JLabel l_myan = new JLabel("내 계좌 ");
		JLabel l_enter = new JLabel("금액  ");

		enter_money = new JTextField();
		enter_trans_an = new JTextField();

		ok = new JButton("확인");
		cancel = new JButton("나가기");
		check_balance = new JButton("잔액");

		user_reader = new BufferedReader(new FileReader("회원정보.txt"));
		Vector<String> v = new Vector<String>();
		while ((line = user_reader.readLine()) != null) {
			String[] user_info = line.split("/");
			String f_id = user_info[1];
			if (f_id.equals(LogInOut.getR_id())) {
				String an = user_info[4];
				String[] an_info = an.split(",");
				for (int i = 0; i < an_info.length; i++) {
					v.add(an_info[i]);
				}
			}
		}

		combo = new JComboBox<String>(v);
		accombo = new JComboBox<String>();
		accombo.addItem("한양 은행");
		accombo.addItem("기타");

		l_main.setBounds(130, 50, 400, 20);
		l_trans.setBounds(130, 100, 200, 20);
		accombo.setBounds(440,100,100,20);
		enter_trans_an.setBounds(230, 100, 200, 30);
		l_myan.setBounds(130, 140, 200, 20);
		combo.setBounds(230, 140, 200, 30);
		l_enter.setBounds(130, 180, 200, 20);
		enter_money.setBounds(230, 180, 200, 30);

		check_balance.setBounds(160, 300, 80, 40);
		ok.setBounds(250, 300, 80, 40);
		cancel.setBounds(340, 300, 80, 40);

		cp.add(l_main);
		cp.add(l_trans);
		cp.add(l_myan);
		cp.add(l_enter);
		cp.add(enter_trans_an);
		cp.add(enter_money);
		cp.add(combo);
		cp.add(ok);
		cp.add(cancel);
		cp.add(check_balance);
		cp.add(accombo);

		ok.addActionListener(new EnterAmountController(this,label));
		cancel.addActionListener(new EnterAmountController(this,label));
		check_balance.addActionListener(new EnterAmountController(this,label));

		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getCombo() {
		String an = combo.getSelectedItem().toString();
		return an;
	}
	
	public String getAccombo() {
		String ac = accombo.getSelectedItem().toString();
		return ac;
	}
	
	public String getEntermoney() {
		String amount = enter_money.getText();
		return amount;
	}
	
	public String getTransan() {
		String an = enter_trans_an.getText();
		return an;
	}
	
	public void ShowOff() {
		this.dispose();
	}
	
}
