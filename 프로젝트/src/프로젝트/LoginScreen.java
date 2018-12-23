package ������Ʈ;
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
		
		l_main = new JLabel("�α���");
		l_main.setFont(new Font(null, Font.BOLD,20));
		
		id = new JLabel("���̵�");
		pw = new JLabel("��й�ȣ");
		
		f_id = new JTextField(13);
		f_pw = new JPasswordField(13);
		
		login = new JButton("�α���");
		signup = new JButton("ȸ������");
		
		//������ : �̹� ���� �ɷ� ������ ������. �� �α��� �ؽ�Ʈ �ʵ忡 �̹� �����ɷ�
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
		
		if(e.getActionCommand().equals("ȸ������")) {
			//�ڵ� x
			dispose();
			new SignUpScreen(); //ȸ������ ȭ������
		}
		
		if(e.getActionCommand().equals("�α���")){
			String id = f_id.getText();
			String pw = f_pw.getText();
			if(id.length()!=0 && pw.length()!=00) {
			//���� ó��
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
				JOptionPane.showMessageDialog(null,"���̵� �Ǵ� ��й�ȣ�� �ٽ� Ȯ���ϼ���.");
			}
		}
	}
}
