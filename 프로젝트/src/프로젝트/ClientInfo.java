package ������Ʈ;
//���� ���α׷����� ���̴� ������ �Է�
public class ClientInfo extends UserInfo{ 
	private String ID;
	private String PW;
	private String SimplePW;// �Ա�,���,��ü�Ҷ� ��� 4�ڸ�
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
