package 프로젝트;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SignUp {
	private ArrayList<ClientInfo> ClientList = new ArrayList<ClientInfo>();
	public SignUp() {
//		String name = ID, PW,SimplePW,RRN,AN;
		
	}
	
	public void Register(String name, String id, String pw, String spw) {
		ClientInfo AN;
		AN = new ClientInfo();
		
		ClientInfo clientInfo = new ClientInfo(name,id,pw,spw,AN);
		ClientList.add(clientInfo);
		JOptionPane.showMessageDialog(null,"성공적으로 등록되었습니다.");
	}
}

