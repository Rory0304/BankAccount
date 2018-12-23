package ������Ʈ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MakeAccount {
	
	private BufferedWriter account;
	private BufferedReader user_reader; //ȸ�� ����
	private BufferedWriter new_user_info; //��� ���ο� ����
	private BankAccount bankaccount;
	private WriteTransaction transaction;
	private ClientManager c; 
	private String accountnum,str_accountnum;
	private ReadFile r;
	
	public MakeAccount() throws IOException { 
		
		if(MakeNewFile()) {
			String str_money = JOptionPane.showInputDialog("���¹�ȣ�� " + str_accountnum +"\n" + "�Ա��� �ݾ��� �Է��ϼ���");
			//numberformatexception �߰�
			try {
				int int_money = Integer.parseInt(str_money);
				bankaccount = new BankAccount(accountnum);
				
				if(bankaccount.deposit(int_money)) {
					transaction = new WriteTransaction("�Ա�",int_money,accountnum,int_money," ");
					if(transaction.process()) {
						JOptionPane.showMessageDialog(null,"���������� ��ϵǾ����ϴ�.");
					}
					else {
						JOptionPane.showMessageDialog(null,"���� ������ �����߽��ϴ�.");
					}
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"�ùٸ� ������ �ƴմϴ�.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"������ �ջ�Ǿ� ���¸� ������ �� �����ϴ�..");
		}
	}
	
	
	public boolean MakeNewFile() throws IOException {
		
		r = new ReadFile(); //ȸ�� ������� ������ �����ϴ��� Ȯ��
		if(r.readFile("ȸ������")) {
			accountnum = MakeAn();
			//���ο� ���� ��ȣ�� ������.
			String first = accountnum.substring(0,4);
			String second = accountnum.substring(4,7);
			String last = accountnum.substring(7);
			str_accountnum =  first +" - " + second + " - " +last;
			
			user_reader = new BufferedReader(new FileReader("ȸ������.txt")); 
			account =  new BufferedWriter(new FileWriter(accountnum+ ".txt",true));
			//���¹�ȣ�� text file�� account�� ������. -> �ŷ� ������ ����ϰ� �ֱ� �ŷ� ������ Ȯ���ϱ� ����.
			
			String line;
			String old_info = "";//���ŵǴ� ������ �����ϴ� ��
			while((line = user_reader.readLine())!=null) {
				String[] userinfo = line.split("/");
				String f_id = userinfo[1];
				if(!(f_id.equals(LogInOut.getR_id()))) old_info += (line +"\r\n");
				else {
					String name = userinfo[0];
					String f_pw = userinfo[2];
					String f_spw = userinfo[3];
					if(userinfo[4].equals("���°� �����ϴ�.")) {
						old_info += (name +"/" + f_id +"/" + f_pw + "/" + f_spw + "/" + accountnum + "," + "\r\n");
					}
					else {
						old_info += (name +"/" + f_id +"/" + f_pw + "/" + f_spw + "/" + userinfo[4]  + accountnum + ","+ "\r\n");
					}
				}
			}
		new_user_info = new BufferedWriter(new FileWriter("ȸ������.txt")); //���ο� ������ ����
		new_user_info.write(old_info);
		new_user_info.close();
		user_reader.close();
		account.close();
		return true;
		}
		else {
			return false;
		}
	}
	
	
	//�ߺ��Ǵ� ���� ��ȣ�� ������ �ȵǱ� ������ arraylist�� ���� ���� ��ȣ���� �о �������� ���� ���� ��ȣ�� ��
	public String MakeAn() throws IOException {
		accountnum = String.valueOf(Math.random()).substring(2,14);
		ArrayList<ClientInfo> clientList = new ArrayList<ClientInfo>();
		c = new ClientManager();
		clientList = c.getClientList();
		for(ClientInfo client : clientList) {
			String accounts = client.getAccountNum();
			String[] account = accounts.split(",");
			for(int i=0;i<account.length;i++) {
				if(account[i].equals(accountnum)) {
					return MakeAn();
				}
			}
		}
		return accountnum;
	}
}
