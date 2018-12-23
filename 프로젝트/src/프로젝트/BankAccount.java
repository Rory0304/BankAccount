package 프로젝트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class BankAccount {
	private BufferedReader account_reader;
	private int balance;

	// 잔액
	public BankAccount(String an) throws IOException {
		account_reader = new BufferedReader(new FileReader(an + ".txt"));
		String line;
		String[] last_line = null;
		while ((line = account_reader.readLine()) != null) {
			last_line = line.split("/");
		}
		// 계좌 생성할때 돈을 입금해야 하는데, 아무것도 적히지 않아서 nullpointer오류 발생
		if (last_line != null && last_line.length > 0) {
			balance = Integer.parseInt(last_line[3]);
		} else {
			balance = 0;
		}
	}

	public int getBalance() {
		return balance;
	}

	public boolean deposit(int amount) {
		boolean result = false;
		if (amount < 0)
			JOptionPane.showMessageDialog(null, "잘못된 입력 금액입니다.");
		else if (amount == 0)
			JOptionPane.showMessageDialog(null, "입금 금액을 입력해주세요.");
		else {
			balance = balance + amount;
			result = true;
		}
		return result;
	}

	public boolean withdraw(int amount) {
		boolean result = false;
		if (balance < amount)
			JOptionPane.showMessageDialog(null, "잔고가 부족합니다.");
		else if (amount == 0)
			JOptionPane.showMessageDialog(null, "출금 금액을 입력해주세요.");
		else if (amount < 0)
			JOptionPane.showMessageDialog(null, "잘못된 입력 금액입니다.");
		else {
			balance = balance - amount;
			result = true;
		}
		return result;
	}

	// 이체할때 한양 은행의 계좌이면 수수료 적용 x, 아니면 수수료 적용
	public boolean transfer(int amount) {
		boolean result = false;
		if (balance < amount)
			JOptionPane.showMessageDialog(null, "잔고가 부족합니다.");
		else if (amount == 0)
			JOptionPane.showMessageDialog(null, "이체 금액을 입력해주세요.");
		else if (amount < 0)
			JOptionPane.showMessageDialog(null, "잘못된 입력 금액입니다.");
		else {
			balance = balance - amount-50;
			result = true;
		}
		return result;
	}

}
