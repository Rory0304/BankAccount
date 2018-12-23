package 프로젝트;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
public class LoginScreen extends JFrame implements ActionListener{

	private JPasswordField f_pw;
	private JTextField f_id;
	private LogInOut l;
	
	public LoginScreen() {
		JLabel l_main,id,pw;
		JButton login,signup;
		Container cp = getContentPane();
		cp.setLayout(null);
		
		l_main = new JLabel("로그인");
		l_main.setFont(new Font(null, Font.BOLD,20));
		
		id = new JLabel("아이디");
		pw = new JLabel("비밀번호");
		
		f_id = new JTextField(13);
		f_pw = new JPasswordField(13);
		
		login = new JButton("로그인");
		signup = new JButton("회원가입");
		
		//디자인 : 이미 적힌 걸로 했으면 좋겠음. 그 로그인 텍스트 필드에 이미 적힌걸로
		l_main.setBounds(250,20,100,40);
		id.setBounds(160,100,100,35);
		f_id.setBounds(220,100,140,35);
		pw.setBounds(150,140,120,35);
		f_pw.setBounds(220,140,140,35);
		login.setBounds(190,200,80,40);
		signup.setBounds(280,200,100,40);
		
		cp.add(l_main);
		cp.add(id);
		cp.add(pw);
		cp.add(f_id);
		cp.add(f_pw);
		cp.add(login);
		cp.add(signup);
		
		login.addActionListener(this);
		signup.addActionListener(this);
		
		setVisible(true);
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("회원가입")) {
			//자동 x
			dispose();
			new SignUpScreen(); //회원가입 화면으로
		}
		
		if(e.getActionCommand().equals("로그인")){
			String id = f_id.getText();
			String pw = f_pw.getText();
			if(id.length()!=0 && pw.length()!=00) {
			//예외 처리
				try {
					l = new LogInOut();
					if(l.login(id, pw)) {
						dispose();
						new MainScreen();
					}
				} catch (IOException e1) {
					e1.getMessage();
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호를 다시 확인하세요.");
			}
		}
	}
}
