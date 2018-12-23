package 프로젝트;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class IsTransaccount {
	boolean result = false;
	private String trans_an;
	private BufferedReader user_reader;
	
	public IsTransaccount(String trans_an) {
		this.trans_an = trans_an;
	}

	// 한양 은행의 계좌인지 조회
	public boolean IsTransaccount() throws IOException {
		File trans_file = new File(trans_an + ".txt");
		if (trans_file.exists()) {
			String line;
			user_reader = new BufferedReader(new FileReader("회원정보.txt"));
			while ((line = user_reader.readLine()) != null) {
				String[] userinfo = line.split("/");
				String an[] = userinfo[4].split(",");
				for (int i = 0; i < an.length; i++) {
					if (an[i].equals(trans_an)) {
						String name = userinfo[0];
						int ans = JOptionPane.showConfirmDialog(null, "받는 분" + name + "이 맞습니까?", "확인",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
						if (ans == 0) {
							result = true;
							return result;
						}
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "한양은행 계좌가 존재하지 않습니다.");
		}
		return result;
	}
	
	public String getTrans_an() {
		return trans_an;
	}
	
}
