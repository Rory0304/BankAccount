package 프로젝트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LogInOut {
//	private BufferedWriter user_info; //파일 생성, 프로그램이 종료되어도 로그인 가능
	private BufferedReader readfile;
	public static boolean status = false;
	private static String r_id;
	private static String r_pw;
	
	public boolean login(String id,String pw) throws IOException{
		try {
			readfile = new BufferedReader(new FileReader("회원정보.txt"));
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
				JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호를 다시 확인하세요.");
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
		JOptionPane.showMessageDialog(null,"로그아웃 되었습니다.");
		System.exit(0);
	}
	
	public static String getR_id() {
		return r_id;
	}
	
	public static String getR_pw() {
		return r_pw;
	}
	
}
