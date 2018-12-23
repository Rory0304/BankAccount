
/* 계좌 삭제 및 탈퇴하는 스크린과 기능.. 미완*/

//package 프로젝트;
//
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.event.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Vector;
//
//import javax.swing.*;
//
//public class MyinfoScreen extends JFrame implements ActionListener {
//	
//	JButton checkinfo,ac_delete,info_delete,cancel,ok;
//	JTextField jpw;
//	BufferedReader user_reader;
//	private String pw;
//	private static JComboBox<String> combo;
//	
//	public MyinfoScreen() {
//		Container cp = getContentPane();
//		cp.setLayout(null);
//		
//		checkinfo = new JButton("내 정보 확인");
//		checkinfo.setFont(new Font(null, Font.BOLD, 11));
//
//		ac_delete = new JButton("계좌 삭제");
//		ac_delete.setFont(new Font(null, Font.BOLD, 11));
//
//		info_delete = new JButton("탈퇴");
//		info_delete.setFont(new Font(null, Font.BOLD, 11));
//		
//		ac_delete = new JButton("나가기");
//		ac_delete.setFont(new Font(null, Font.BOLD, 11));
//		
//		
//		checkinfo.setBounds(250, 90, 100, 30);
//		ac_delete.setBounds(250, 130, 100, 30);
//		info_delete.setBounds(250, 170, 100, 40);
//		
//		cp.add(checkinfo);
//		cp.add(ac_delete);
//		cp.add(info_delete);
//	
//		checkinfo.addActionListener(this);
//		ac_delete.addActionListener(this);
//		info_delete.addActionListener(this);
//		
//		
//		setSize(600, 400);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//	}
//	
//	public void AcDeleteScreen() throws IOException {
//		Container cp = getContentPane();
//		cp.setLayout(null);
//		String line;
//		
//		JLabel l_main = new JLabel("삭제를 원하는 계좌를 선택하세요");
//		l_main.setFont(new Font(null,Font.BOLD,15));
//		ok = new JButton("확인");
//		cancel = new JButton("나가기");
//		
//		user_reader = new BufferedReader(new FileReader("회원정보.txt"));
//		Vector<String> v = new Vector<String>();
//		while ((line = user_reader.readLine()) != null) {
//			String[] user_info = line.split("/");
//			String f_id = user_info[1];
//			if (f_id.equals(LogInOut.getR_id())) {
//				String an = user_info[4];
//				String[] an_info = an.split(",");
//				for (int i = 0; i < an_info.length; i++) {
//					v.add(an_info[i]);
//				}
//			}
//		}
//
//		combo = new JComboBox<String>(v);
//		combo.setBounds(200, 200, 200, 40);
//		ok.setBounds(200,300,80,40);
//		cancel.setBounds(300,300,80,40);
//		
//		ok.addActionListener(this);
//		cp.add(combo);
//		cp.add(ok);
//		cp.add(cancel);
//		cp.add(l_main);
//		
//	}
//	
//	public void actionPerformed(ActionEvent e) {
//		switch(e.getActionCommand()) {
//		case "탈퇴":
//			pw = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
//			if(LogInOut.getR_pw().equals(pw)) {
//				try {
//					new Deleteinfo().InfoDelete();
//				} catch (IOException e1) {
//					e1.getMessage();
//				}
//			}
//			else {
//				JOptionPane.showMessageDialog(null,"비밀번호가 일치하지 않습니다.");
//			}
//			
//			break;
//			
//		case "계좌 삭제":
//			pw = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
//			if(LogInOut.getR_pw().equals(pw)) {
//				try {
//					AcDeleteScreen();
//					String an = combo.getSelectedItem().toString();
//					if(e.getSource().equals("확인")) {
//						new Deleteinfo().AcDelete(an);
//					}
//					
//				} catch (IOException e1) {
//					e1.getMessage();
//				}
//			}
//			else {
//				JOptionPane.showMessageDialog(null,"비밀번호가 일치하지 않습니다.");
//			}
//			
//			break;
//		}
//		
//		
//		
//	}
//}
