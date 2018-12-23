package 프로젝트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClientManager {
	private String name,f_id,f_pw,f_spw,an;
	private BufferedReader user_reader;
	private BufferedWriter user_writer;
	private ArrayList<ClientInfo> clientList = new ArrayList<ClientInfo>();
	
	public ClientManager() throws IOException{
		try {
			user_reader = new BufferedReader(new FileReader("회원정보.txt")); 
			String line;
			while((line = user_reader.readLine())!=null) {
				String[] userinfo = line.split("/");
				name = userinfo[0];
				f_id = userinfo[1];
				f_pw = userinfo[2];
				f_spw = userinfo[3];
				an = userinfo[4];
				ClientInfo clientInfo = new ClientInfo(name,f_id,f_pw,f_spw,an);
				clientList.add(clientInfo);
			}
			
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"파일을 찾을 수 없습니다. 다시 시도하세요.");
			user_writer = new BufferedWriter(new FileWriter("회원정보.txt"));
		}
	}

	public ArrayList<ClientInfo> getClientList() {
		return clientList;
	}
}
