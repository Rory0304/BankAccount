//package ������Ʈ;
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
//	// ���¸� ����
//	public boolean AcDelete(String f_an) throws IOException {
//		user_reader = new BufferedReader(new FileReader("ȸ������.txt"));
//		String line;
//		String old_info = "";// ���ŵǴ� ������ �����ϴ� ��
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
//								JOptionPane.showMessageDialog(null, "���� ������ �����߽��ϴ�.");
//								return success;
//							} else {success = true;}
//						} 
//						else {
//							JOptionPane.showMessageDialog(null, "���°� �������� �ʽ��ϴ�.");
//							return success;
//						}
//					}
//				}
//			}
//		}
//		JOptionPane.showMessageDialog(null,"���� ������ �����߽��ϴ�.");
//		new_user_info=new BufferedWriter(new FileWriter("ȸ������.txt"));
//		new_user_info.write(old_info);return success;
//
//	}
//
//	// Ż��
//	public void InfoDelete() throws IOException {
//
//		user_reader = new BufferedReader(new FileReader("ȸ������.txt"));
//		String line;
//		String old_info = "";// ���ŵǴ� ������ �����ϴ� ��
//
//		while ((line = user_reader.readLine()) != null) {
//			String[] userinfo = line.split("/");
//			String f_id = userinfo[1];
//			if (!(f_id.equals(LogInOut.getR_id()))) {
//				old_info += (line + "\r\n");
//			}
//			// ȸ�� ���� ���ֱ�
//			else {
//				String an = userinfo[4];
//				String[] an_info = an.split(",");
//				for (int i = 0; i < an_info.length; i++) {
//					File file = new File(an_info[i] + ".txt");
//					File new_file = new File(file.getPath().toString());
//
//					if (new_file.exists()) {
//						if (!new_file.delete()) {
//							JOptionPane.showMessageDialog(null, "���� ������ �����߽��ϴ�. " + an_info[i]);
//							break;
//						}
//						else {
//							success=true;
//						}
//					} else {
//						JOptionPane.showMessageDialog(null, "���°� �������� �ʽ��ϴ�.");
//						break;
//					}
//				}
//				// ���� ���ֱ�
//				if(success==true) {
//					new_user_info = new BufferedWriter(new FileWriter("ȸ������.txt"));
//					new_user_info.write(old_info);
//					JOptionPane.showMessageDialog(null, "���� ������ �����߽��ϴ�.");
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
