package ������Ʈ;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;

public class SignUp {
	private BufferedWriter user_info; // ���� ����, ���α׷��� ����Ǿ �α��� ����
	public boolean status = false;
	private ClientManager c;

	public boolean Register(String name, String id, String pw, String spw) throws IOException{
		if(checkIDPW(id)) {
			try {
				user_info = new BufferedWriter(new FileWriter("ȸ������.txt", true));
				user_info.write(name + "/");
				user_info.write(id + "/");
				user_info.write(pw + "/");
				user_info.write(spw + "/");
				user_info.write("���°� �����ϴ�."); // ������ ���� ��ȣ, ȸ�������� �߱� ������ ���°� ���� ����
				user_info.newLine();
				user_info.close();
				status = true;
				return status;
			}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "ȸ�� ���� ������ �ջ�Ǿ����ϴ�.");}
		}
		else {
			JOptionPane.showMessageDialog(null, "���̵� ����� �� �����ϴ�.");
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
