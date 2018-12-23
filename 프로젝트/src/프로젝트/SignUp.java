package 프로젝트;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;

public class SignUp {
	private BufferedWriter user_info; // 파일 생성, 프로그램이 종료되어도 로그인 가능
	public boolean status = false;
	private ClientManager c;

	public boolean Register(String name, String id, String pw, String spw) throws IOException{
		if(checkIDPW(id)) {
			try {
				user_info = new BufferedWriter(new FileWriter("회원정보.txt", true));
				user_info.write(name + "/");
				user_info.write(id + "/");
				user_info.write(pw + "/");
				user_info.write(spw + "/");
				user_info.write("계좌가 없습니다."); // 생성된 계좌 번호, 회원가입을 했기 때문에 계좌가 없는 상태
				user_info.newLine();
				user_info.close();
				status = true;
				return status;
			}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "회원 정보 파일이 손상되었습니다.");}
		}
		else {
			JOptionPane.showMessageDialog(null, "아이디를 사용할 수 없습니다.");
		}
		return status;
	}
	
	public boolean checkIDPW(String check_id) throws IOException {
		boolean result = true;
		ArrayList<ClientInfo> clientList = new ArrayList<ClientInfo>();
		c = new ClientManager();
		clientList = c.getClientList();
		for (ClientInfo client : clientList) {
			String ids = client.getID();
			if (check_id.equals(ids)) {
				result = false;
				return result;
			}
		}
		return result;
	}
}
