package 프로젝트;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class ShowHistory extends JFrame implements ActionListener {
	
	JLabel enter_main;
	JButton ok, cancel;
	private JTextArea text_area;
	private JScrollPane sp;
	private static JComboBox<String> combo;
	private BufferedReader user_reader;
	private BufferedReader history_reader;

	public void ShowHistroyScreen() throws IOException {
		text_area = new JTextArea();
		sp = new JScrollPane(text_area);
		JLabel l_main;
		String line;
		Container cp = getContentPane();
		cp.setLayout(null);

		l_main = new JLabel("최근 거래 내역");
		l_main.setFont(new Font(null, Font.BOLD, 20));
		ok = new JButton("확인");
		cancel = new JButton("나가기");

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

		l_main.setBounds(220, 15, 200, 40);
		combo.setBounds(150, 60, 150, 30);
		ok.setBounds(330, 60, 80, 30);
		sp.setBounds(42, 110, 500, 200);
		cancel.setBounds(250, 320, 80, 30);

		ok.addActionListener(this);
		cancel.addActionListener(this);

		cp.add(l_main);
		cp.add(combo);
		cp.add(ok);
		cp.add(sp);
		cp.add(cancel);

		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void History(String an) throws IOException {
		try {
			history_reader = new BufferedReader(new FileReader(an + ".txt"));
			String line;
			text_area.setText(
					"[날짜]" + "\t" + "\t" + "[거래 금액]" + "\t" + "[거래유형]" + "\t" + "[잔액]" + "\t" + "[이체정보]" + "\n");
			while ((line = history_reader.readLine()) != null) {
				String history[] = line.split("/");
				String date = history[0];
				String commandM = history[1];
				String command = history[2];
				String balance = history[3];
				String info = history[4];
				text_area.append(date + "\t" + commandM + "\t" + command + "\t" + balance +"\t" + info +  "\n");
				text_area.append("\n");
				text_area.setCaretPosition(text_area.getDocument().getLength());
				
			}
			history_reader.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"계좌가 존재하지 않습니다.");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			String c = combo.getSelectedItem().toString();
			try {
				History(c);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == cancel) {
			this.dispose();
		}
	}

}
