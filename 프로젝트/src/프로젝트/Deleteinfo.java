//package 프로젝트;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Vector;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//
//public class Deleteinfo extends JFrame {
//	BufferedReader user_reader;
//	BufferedWriter new_user_info;
//	boolean success = false;
//	
//	public void AcDeleteScreen() {
//
//	}
//
//	// 계좌만 삭제
//	public boolean AcDelete(String f_an) throws IOException {
//		user_reader = new BufferedReader(new FileReader("회원정보.txt"));
//		String line;
//		String old_info = "";// 갱신되는 정보를 저장하는 곳
//
//		while ((line = user_reader.readLine()) != null) {
//			String[] userinfo = line.split("/");
//			String f_id = userinfo[1];
//			if (!(f_id.equals(LogInOut.getR_id())))
//				old_info += (line + "\r\n");
//			else {
//				String an = userinfo[4];
//				String[] an_info = an.split(",");
//				for (int i = 0; i < an_info.length; i++) {
//					if (f_an.equals(an_info[i])) {
//						File file = new File("an_info[i]" + ".txt");
//						File new_file = new File(file.getPath());
//						if (new_file.exists()) {
//							if (!new_file.delete()) {
//								JOptionPane.showMessageDialog(null, "계좌 삭제에 실패했습니다.");
//								return success;
//							} else {success = true;}
//						} 
//						else {
//							JOptionPane.showMessageDialog(null, "계좌가 존재하지 않습니다.");
//							return success;
//						}
//					}
//				}
//			}
//		}
//		JOptionPane.showMessageDialog(null,"계좌 삭제에 성공했습니다.");
//		new_user_info=new BufferedWriter(new FileWriter("회원정보.txt"));
//		new_user_info.write(old_info);return success;
//
//	}
//
//	// 탈퇴
//	public void InfoDelete() throws IOException {
//
//		user_reader = new BufferedReader(new FileReader("회원정보.txt"));
//		String line;
//		String old_info = "";// 갱신되는 정보를 저장하는 곳
//
//		while ((line = user_reader.readLine()) != null) {
//			String[] userinfo = line.split("/");
//			String f_id = userinfo[1];
//			if (!(f_id.equals(LogInOut.getR_id()))) {
//				old_info += (line + "\r\n");
//			}
//			// 회원 정보 없애기
//			else {
//				String an = userinfo[4];
//				String[] an_info = an.split(",");
//				for (int i = 0; i < an_info.length; i++) {
//					File file = new File(an_info[i] + ".txt");
//					File new_file = new File(file.getPath().toString());
//
//					if (new_file.exists()) {
//						if (!new_file.delete()) {
//							JOptionPane.showMessageDialog(null, "계좌 삭제에 실패했습니다. " + an_info[i]);
//							break;
//						}
//						else {
//							success=true;
//						}
//					} else {
//						JOptionPane.showMessageDialog(null, "계좌가 존재하지 않습니다.");
//						break;
//					}
//				}
//				// 계좌 없애기
//				if(success==true) {
//					new_user_info = new BufferedWriter(new FileWriter("회원정보.txt"));
//					new_user_info.write(old_info);
//					JOptionPane.showMessageDialog(null, "계좌 삭제에 성공했습니다.");
//					new_user_info.close();
//					new LoginScreen();
//				}
//				user_reader.close();
//			}
//			
//		}
//
//	}
//}
