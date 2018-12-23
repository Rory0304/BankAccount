package 프로젝트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class WriteTransaction {
	private BufferedWriter account_writer;
	private String command;
	private int amount;
	private int balance;
	private String an;
	private boolean result = false;
//	private BankAccount bankaccount;
	private String info;
	
	//label, amount, an, bal, " "
	//String line, s_id;

	public WriteTransaction(String command, int amount, String an,int bal,String info) throws IOException {
		this.command = command; 
		this.amount = amount;
		this.an = an;
		this.balance = bal;
		this.info = info;
	}

	public boolean process() throws IOException {
		if(an.equals("계좌가 없습니다.")) return result;
		else {
			account_writer = new BufferedWriter(new FileWriter(an + ".txt", true));
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, a hh:mm:ss");

			try {
				account_writer.write(sdf.format(today).toString() + "/" + amount + "/" + command + "/" + balance + "/" + info);
				account_writer.newLine();
				account_writer.close();
				result = true;
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,"계좌가 없습니다.");
			}
		}
		return result;

	}
}
