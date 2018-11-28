package ������Ʈ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpScreen extends JFrame implements ActionListener{
	private ExitButton exit;
	private SignUp signup;
	JLabel l1,Name,ID,PW,SimplePW;
	JTextField name,id,pw,simplepw;
	JButton ok,cancel;
	public SignUpScreen() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		l1 = new JLabel("ȸ�� ����");
		l1.setFont(new Font(null, Font.BOLD,20));
		Name = new JLabel("�̸� : ");
		ID = new JLabel("���̵� : ");
		PW = new JLabel("��й�ȣ : ");
		SimplePW = new JLabel("���� ��й�ȣ : ");
		
		name = new JTextField();
		id = new JTextField();
		pw = new JTextField();
		simplepw = new JTextField();
		
		ok = new JButton("Ȯ��");
		cancel = new JButton("���");
		
		l1.setBounds(250,20,100,40);
		Name.setBounds(100,80,35,35);
		name.setBounds(140,80,100,30);
		ID.setBounds(100,120,65,35);
		id.setBounds(150,120,120,30);
		PW.setBounds(100,160,65,35);
		pw.setBounds(165,160,120,30);
		SimplePW.setBounds(100,200,90,35);
		simplepw.setBounds(190,200,90,30);
		ok.setBounds(200,300,80,40);
		cancel.setBounds(300,300,80,40);
		cp.add(l1);
		cp.add(Name);
		cp.add(name);
		cp.add(ID);
		cp.add(id);
		cp.add(PW);
		cp.add(pw);
		cp.add(SimplePW);
		cp.add(simplepw);
		cp.add(ok);
		cp.add(cancel);
		ok.addActionListener(this);
		cancel.addActionListener(new ExitButton("���"));
		
		//��� ��ư Ȯ��
		setVisible(true);
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		String strname = name.getText();
		String strid = id.getText();
		String strpw = pw.getText();
		String strspw = simplepw.getText();
		if(strname.equals("")){
			JOptionPane.showMessageDialog(null,"�̸��� �ʼ� �Է� �����Դϴ�.");
			name.requestFocusInWindow();
		}
		else if(strid.equals("")){
			JOptionPane.showMessageDialog(null,"���̵�� �ʼ� �Է� �����Դϴ�.");
			id.requestFocusInWindow();
		}
		else if(strpw.equals("")){
			JOptionPane.showMessageDialog(null,"��й�ȣ�� �ʼ� �Է� �����Դϴ�.");
			pw.requestFocusInWindow();
		}
		else if(strspw.equals("")){
			JOptionPane.showMessageDialog(null,"���� ��й�ȣ�� �ʼ� �Է� �����Դϴ�.");
			simplepw.requestFocusInWindow();
		}
		else {
			signup.Register(strname,strid,strpw,strspw);
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpScreen();
	}

}
