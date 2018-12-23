package 프로젝트;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;

//메인 화면 버튼 컨트롤러
public class MainController extends JButton implements ActionListener {
	private EnterAmountScreen a;
	private LogInOut l;
	private MakeAccount m;
	private ShowHistory s;
	
	public MainController(String label) {
		super(label);
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "계좌 생성":
			try {
				m = new MakeAccount();
			} catch (IOException e1) {
				e1.printStackTrace(); // 에러메세지도 수정해야함
			}
			break;

		case "입금":
			a = new EnterAmountScreen(e.getActionCommand());
			try {
				a.EnterAmountScreen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;

		case "거래 내역":
			s = new ShowHistory();
			try {
				s.ShowHistroyScreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "출금":
			a = new EnterAmountScreen(e.getActionCommand());
			try {
				a.EnterAmountScreen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
			
		case "이체":
			a = new EnterAmountScreen(e.getActionCommand());
			try {
				a.EnterTransScreen();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			break;

		case "로그아웃":
			l = new LogInOut();
			l.logout();
			break;
		}
	}
}
