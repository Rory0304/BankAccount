package ������Ʈ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//������ : �̹� ���� �ɷ� ������ ������. �� �α��� �ؽ�Ʈ �ʵ忡 �̹� �����ɷ�
public class LoginScreen extends JFrame implements ActionListener{
	private ExitButton exit;
	JLabel l_main;
	JTextField f_id,f_pw;
	JButton login,signup;
	public LoginScreen() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		l_main = new JLabel("�α���");
		l_main.setFont(new Font(null, Font.BOLD,20));
		
		f_id = new JTextField();
		f_pw = new JTextField();
		
		login = new JButton("�α���");
		signup = new JButton("ȸ������");
		
		l_main.setBounds(250,20,100,40);
		f_id.setBounds(100,80,35,35);
		f_pw.setBounds(100,120,65,35);
		login.setBounds(200,300,80,40);
		signup.setBounds(300,300,80,40);
		
		cp.add(l_main);
		cp.add(f_id);
		cp.add(f_pw);
		cp.add(login);
		cp.add(signup);
		
		signup.addActionListener(this);
		setVisible(true);
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginScreen();
	}

	public void actionPerformed(ActionEvent arg0) {
		new SignUpScreen();
	
	}
	

}
