package 프로젝트;

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
			JOptionPane.showMessageDialog(null,"잘못된 입력 금액입니다.");
		else if(amount==0)
			JOptionPane.showMessageDialog(null,"이체 금액을 입력해주세요.");
		else {
			balance = balance + amount;
			result = true;
		}
		return result;
	}
	
	public boolean withdraw(int amount) {
		boolean result = false;
		if(balance < amount)
			JOptionPane.showMessageDialog(null,"잔고가 부족합니다.");
		else if(amount==0)
			JOptionPane.showMessageDialog(null,"이체 금액을 입력해주세요.");
		else if(amount<0)
			JOptionPane.showMessageDialog(null,"잘못된 입력 금액입니다.");
		else {
			balance = balance - amount;
			result = true;
		}
		return result;
	}
	
	
}
