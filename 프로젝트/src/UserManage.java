import java.util.Scanner;

class UserManage {
	private String UserName;
	private String ID;
	private String PW;
	private int PN;
	String UserInfo[][] = new String[100][];
	
	public UserManage(String UserName,String ID,String PW,int PN) {
		UserName = UserName;
		ID = ID;
		PW = PW;
		PN = PN;
	}
	
	public void ReadUserInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ��� ");
		UserName = scan.next();
		if(UserName.length()>0) {
			
		}
		else {
			System.out.println("�߸��� ������ �̸��Դϴ�.");
		}
		
	}
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getPN() {
		return PN;
	}

	public void setPN(int pN) {
		PN = pN;
	}
	
}
