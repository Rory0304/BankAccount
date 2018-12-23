package 프로젝트;
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
		
		l1 = new JLabel("회원 가입");
		l1.setFont(new Font(null, Font.BOLD,20));
		Name = new JLabel("이름 : ");
		ID = new JLabel("아이디 : ");
		PW = new JLabel("비밀번호 : ");
		SimplePW = new JLabel("간편 비밀번호 : ");
		
		name = new JTextField();
		id = new JTextField();
		pw = new JTextField();
		simplepw = new JTextField();
		
		ok = new JButton("확인");
		cancel = new JButton("취소");
		check = new JButton("중복확인");
		
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
		
		//취소 버튼 확인
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
				JOptionPane.showMessageDialog(null,"이름은 필수 입력 사항입니다.");
				name.requestFocusInWindow();
			}
			else if(strid.equals("")){
				JOptionPane.showMessageDialog(null,"아이디는 필수 입력 사항입니다.");
				id.requestFocusInWindow();
			}
			else if(strpw.equals("")){
				JOptionPane.showMessageDialog(null,"비밀번호는 필수 입력 사항입니다.");
				pw.requestFocusInWindow();
			}
			else if(strspw.equals("")){
				JOptionPane.showMessageDialog(null,"간편 비밀번호는 필수 입력 사항입니다.");
				simplepw.requestFocusInWindow();
			}
			else {
				s = new SignUp();
				try {
					if(s.Register(strname,strid,strpw,strspw)) {
						JOptionPane.showMessageDialog(null,"성공적으로 등록되었습니다.");
						dispose();
						new LoginScreen();
						//회원 정보를 입력함.
					}
					else {
						JOptionPane.showMessageDialog(null,"회원 가입에 실패했습니다.");
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
					JOptionPane.showMessageDialog(null,"아이디를 사용할 수 있습니다.");
					id.requestFocusInWindow();
				}
				else {
					JOptionPane.showMessageDialog(null,"아이디를 사용할 수 없습니다.");
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
