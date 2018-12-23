package ������Ʈ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;

//���� ȭ�� ��ư ��Ʈ�ѷ�
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
		case "���� ����":
			try {
				m = new MakeAccount();
			} catch (IOException e1) {
				e1.printStackTrace(); // �����޼����� �����ؾ���
			}
			break;

		case "�Ա�":
			a = new EnterAmountScreen(e.getActionCommand());
			try {
				a.EnterAmountScreen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;

		case "�ŷ� ����":
			s = new ShowHistory();
			try {
				s.ShowHistroyScreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "���":
			a = new EnterAmountScreen(e.getActionCommand());
			try {
				a.EnterAmountScreen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
			
		case "��ü":
			a = new EnterAmountScreen(e.getActionCommand());
			try {
				a.EnterTransScreen();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			break;

		case "�α׾ƿ�":
			l = new LogInOut();
			l.logout();
			break;
		}
	}
}
