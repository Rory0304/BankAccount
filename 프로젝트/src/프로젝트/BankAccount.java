package ������Ʈ;

import javax.swing.JOptionPane;

public class BankAccount {
	private int balance;
	public BankAccount(int initial_amount) {
		if(initial_amount>0)
			balance = initial_amount;
		else
			balance = 0;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean deposit(int amount) {
		boolean result = false;
		if(amount<0) 
			JOptionPane.showMessageDialog(null,"�߸��� �Է� �ݾ��Դϴ�.");
		else if(amount==0)
			JOptionPane.showMessageDialog(null,"��ü �ݾ��� �Է����ּ���.");
		else {
			balance = balance + amount;
			result = true;
		}
		return result;
	}
	
	public boolean withdraw(int amount) {
		boolean result = false;
		if(balance < amount)
			JOptionPane.showMessageDialog(null,"�ܰ� �����մϴ�.");
		else if(amount==0)
			JOptionPane.showMessageDialog(null,"��ü �ݾ��� �Է����ּ���.");
		else if(amount<0)
			JOptionPane.showMessageDialog(null,"�߸��� �Է� �ݾ��Դϴ�.");
		else {
			balance = balance - amount;
			result = true;
		}
		return result;
	}
	
	
}
