package ������Ʈ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LogInOut {
//	private BufferedWriter user_info; //���� ����, ���α׷��� ����Ǿ �α��� ����
	private BufferedReader readfile;
	public static boolean status = false;
	private static String r_id;
	private static String r_pw;
	
	public boolean login(String id,String pw) throws IOException{
		try {
			readfile = new BufferedReader(new FileReader("ȸ������.txt"));
			String line;
			while((line = readfile.readLine()) != null) {
				String[] userinfo = line.split("/"); 
				String f_id = userinfo[1];
				String f_pw = userinfo[2];
				if(id.equals(f_id) && pw.equals(f_pw)) {
					r_id = f_id;
					r_pw = f_pw;
					status = true;
				}
			}
			if(status == false) {
				JOptionPane.showMessageDialog(null,"���̵� �Ǵ� ��й�ȣ�� �ٽ� Ȯ���ϼ���.");
			}
			readfile.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException : "+ e.getMessage());
		}
		return status;
	
	}

	public void logout() {
		status = false;
		JOptionPane.showMessageDialog(null,"�α׾ƿ� �Ǿ����ϴ�.");
		System.exit(0);
	}
	
	public static String getR_id() {
		return r_id;
	}
	
	public static String getR_pw() {
		return r_pw;
	}
	
}
