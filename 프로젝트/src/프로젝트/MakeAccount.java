package 프로젝트;

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
	private BufferedReader user_reader; //회원 정보
	private BufferedWriter new_user_info; //덮어쓸 새로운 파일
	private BankAccount bankaccount;
	private WriteTransaction transaction;
	private ClientManager c; 
	private String accountnum,str_accountnum;
	private ReadFile r;
	
	public MakeAccount() throws IOException { 
		
		if(MakeNewFile()) {
			String str_money = JOptionPane.showInputDialog("계좌번호는 " + str_accountnum +"\n" + "입금할 금액을 입력하세요");
			//numberformatexception 추가
			try {
				int int_money = Integer.parseInt(str_money);
				bankaccount = new BankAccount(accountnum);
				
				if(bankaccount.deposit(int_money)) {
					transaction = new WriteTransaction("입금",int_money,accountnum,int_money," ");
					if(transaction.process()) {
						JOptionPane.showMessageDialog(null,"성공적으로 등록되었습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null,"계좌 생성에 실패했습니다.");
					}
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"올바른 형식이 아닙니다.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"파일이 손상되어 계좌를 생성할 수 없습니다..");
		}
	}
	
	
	public boolean MakeNewFile() throws IOException {
		
		r = new ReadFile(); //회원 정보라는 파일이 존재하는지 확인
		if(r.readFile("회원정보")) {
			accountnum = MakeAn();
			//새로운 계좌 번호를 생성함.
			String first = accountnum.substring(0,4);
			String second = accountnum.substring(4,7);
			String last = accountnum.substring(7);
			str_accountnum =  first +" - " + second + " - " +last;
			
			user_reader = new BufferedReader(new FileReader("회원정보.txt")); 
			account =  new BufferedWriter(new FileWriter(accountnum+ ".txt",true));
			//계좌번호의 text file인 account를 생성함. -> 거래 내역을 기록하고 최근 거래 내역을 확인하기 위함.
			
			String line;
			String old_info = "";//갱신되는 정보를 저장하는 곳
			while((line = user_reader.readLine())!=null) {
				String[] userinfo = line.split("/");
				String f_id = userinfo[1];
				if(!(f_id.equals(LogInOut.getR_id()))) old_info += (line +"\r\n");
				else {
					String name = userinfo[0];
					String f_pw = userinfo[2];
					String f_spw = userinfo[3];
					if(userinfo[4].equals("계좌가 없습니다.")) {
						old_info += (name +"/" + f_id +"/" + f_pw + "/" + f_spw + "/" + accountnum + "," + "\r\n");
					}
					else {
						old_info += (name +"/" + f_id +"/" + f_pw + "/" + f_spw + "/" + userinfo[4]  + accountnum + ","+ "\r\n");
					}
				}
			}
		new_user_info = new BufferedWriter(new FileWriter("회원정보.txt")); //새로운 정보의 파일
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
	
	
	//중복되는 계좌 번호가 있으면 안되기 때문에 arraylist로 부터 계좌 번호들을 읽어서 무작위로 만든 계좌 번호와 비교
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
