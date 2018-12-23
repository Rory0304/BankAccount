package ������Ʈ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class SignUpScreen extends JFrame implements ActionListener{
	
	private SignUp s;
	JLabel l1,Name,ID,PW,SimplePW;
	JTextField name,id,pw,agiapw,simplepw;
	JButton ok,cancel,check;
	
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
		check = new JButton("�ߺ�Ȯ��");
		
		l1.setBounds(250,20,100,40);
		Name.setBounds(100,80,35,35);
		name.setBounds(140,80,100,30);
		ID.setBounds(100,120,65,35);
		id.setBounds(150,120,120,30);
		check.setBounds(300,120,100,35);
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
		cp.add(check);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		check.addActionListener(this);
		
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
		
		if(e.getSource()==ok) {
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
				s = new SignUp();
				try {
					if(s.Register(strname,strid,strpw,strspw)) {
						JOptionPane.showMessageDialog(null,"���������� ��ϵǾ����ϴ�.");
						dispose();
						new LoginScreen();
						//ȸ�� ������ �Է���.
					}
					else {
						JOptionPane.showMessageDialog(null,"ȸ�� ���Կ� �����߽��ϴ�.");
					}
				} catch (HeadlessException | IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		else if (e.getSource() == check) {
			s = new SignUp();
			try {
				if(s.checkIDPW(strid)) {
					JOptionPane.showMessageDialog(null,"���̵� ����� �� �ֽ��ϴ�.");
					id.requestFocusInWindow();
				}
				else {
					JOptionPane.showMessageDialog(null,"���̵� ����� �� �����ϴ�.");
					id.requestFocusInWindow();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else {
			dispose();
		}
		
	}

}
