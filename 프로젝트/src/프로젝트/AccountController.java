package 프로젝트;

public class AccountController {
	private BankReader reader;
	private BankWriter writer;
	private BankAccount account;
	
	public AccountController(BankReader r,BankWriter w,BankAccount a) {
		reader = r;
		account = a;
		writer = w;
	}
	
	public void processTransactions() {
		
	}
	
	
	
	
	
	}
