package ������Ʈ;

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

	// �ܾ�
	public BankAccount(String an) throws IOException {
		account_reader = new BufferedReader(new FileReader(an + ".txt"));
		String line;
		String[] last_line = null;
		while ((line = account_reader.readLine()) != null) {
			last_line = line.split("/");
		}
		// ���� �����Ҷ� ���� �Ա��ؾ� �ϴµ�, �ƹ��͵� ������ �ʾƼ� nullpointer���� �߻�
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
			JOptionPane.showMessageDialog(null, "�߸��� �Է� �ݾ��Դϴ�.");
		else if (amount == 0)
			JOptionPane.showMessageDialog(null, "�Ա� �ݾ��� �Է����ּ���.");
		else {
			balance = balance + amount;
			result = true;
		}
		return result;
	}

	public boolean withdraw(int amount) {
		boolean result = false;
		if (balance < amount)
			JOptionPane.showMessageDialog(null, "�ܰ� �����մϴ�.");
		else if (amount == 0)
			JOptionPane.showMessageDialog(null, "��� �ݾ��� �Է����ּ���.");
		else if (amount < 0)
			JOptionPane.showMessageDialog(null, "�߸��� �Է� �ݾ��Դϴ�.");
		else {
			balance = balance - amount;
			result = true;
		}
		return result;
	}

	// ��ü�Ҷ� �Ѿ� ������ �����̸� ������ ���� x, �ƴϸ� ������ ����
	public boolean transfer(int amount) {
		boolean result = false;
		if (balance < amount)
			JOptionPane.showMessageDialog(null, "�ܰ� �����մϴ�.");
		else if (amount == 0)
			JOptionPane.showMessageDialog(null, "��ü �ݾ��� �Է����ּ���.");
		else if (amount < 0)
			JOptionPane.showMessageDialog(null, "�߸��� �Է� �ݾ��Դϴ�.");
		else {
			balance = balance - amount-50;
			result = true;
		}
		return result;
	}

}
