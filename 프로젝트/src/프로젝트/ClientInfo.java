package 프로젝트;
//은행 프로그램에서 쓰이는 정보를 입력
public class ClientInfo extends UserInfo{ 
	private String ID;
	private String PW;
	private String SimplePW;// 입금,출금,이체할때 사용 4자리
	private String AN;//account number
	
	public ClientInfo(String name,String ID, String PW,String SimplePW,String AN) {
		super(name);
		this.ID = ID;
		this.PW = PW;
		this.SimplePW = SimplePW;
		this.AN = AN;
	}
	

	public String getID() {
		return ID;
	}




	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getSimplePW() {
		return SimplePW;
	}

	public void setSimplePW(String simplePW) {
		SimplePW = simplePW;
	}


	public String getAN() {
		return AN;
	}


	public void setAN(String aN) {
		AN = aN;
	}
	

	
}
