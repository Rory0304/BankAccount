package 프로젝트;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class EnterAmountController implements ActionListener {

	private WriteTransaction transaction_p;
	private WriteTransaction transaction_s;
	private BankAccount bankaccount_p;
	private BankAccount bankaccount_s;
	private ReadFile r;
	private IsTransaccount it;
	private EnterAmountScreen view;
	private String label;
	private String an;

	public EnterAmountController(EnterAmountScreen v, String label) {
		view = v;
		this.label = label;
	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "확인":
			try {
				an = view.getCombo();
				int amount = Integer.parseInt(view.getEntermoney());
				bankaccount_p = new BankAccount(an);
				if (label == "입금") {
					if (bankaccount_p.deposit(amount)) {
						int bal = bankaccount_p.getBalance();
						transaction_p = new WriteTransaction(label, amount, an, bal, " ");
						if (transaction_p.process()) {
							JOptionPane.showMessageDialog(null, amount + "원이 성공적으로 입금되었습니다.");
						} else {
							JOptionPane.showMessageDialog(null, "입금에 실패하였습니다.");
						}
					}
				}
				if (label == "출금") {
					if (bankaccount_p.withdraw(amount)) {
						int bal = bankaccount_p.getBalance();
						transaction_p = new WriteTransaction(label, amount, an, bal, " ");
						if (transaction_p.process()) {
							JOptionPane.showMessageDialog(null, amount + "원이 성공적으로 출금되었습니다.");
						} else {
							JOptionPane.showMessageDialog(null, "출금에 실패하였습니다.");
						}
					}
				}

				if (label == "이체") {
					String trans_an = view.getTransan();
					String trans_ac = view.getAccombo();
					if (trans_ac.equals("한양 은행")) {
						it = new IsTransaccount(trans_an);
						if (it.IsTransaccount()) {
							bankaccount_s = new BankAccount(trans_an);
							if (bankaccount_p.withdraw(amount)) {
								bankaccount_s.deposit(amount);
								int bal_p = bankaccount_p.getBalance();
								int bal_s = bankaccount_s.getBalance();
								transaction_p = new WriteTransaction(label, amount, an, bal_p, trans_an);
								transaction_s = new WriteTransaction("입금", amount, trans_an, bal_s, an);

								if (transaction_p.process() && transaction_s.process()) {
									JOptionPane.showMessageDialog(null, amount + "원이 성공적으로 이체되었습니다.");
								} else {
									JOptionPane.showMessageDialog(null, "이체에 실패하였습니다.");
								}
							}
						}
					}
					else {
						if (bankaccount_p.transfer(amount)){
							int bal_p = bankaccount_p.getBalance();
							transaction_p = new WriteTransaction(label, amount, an, bal_p, trans_an);
							if (transaction_p.process()) {
								JOptionPane.showMessageDialog(null, amount + "원이 성공적으로 이체되었습니다.");
							} else {
								JOptionPane.showMessageDialog(null, "이체에 실패하였습니다.");
							}
						}
					}
				}

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "계좌가 존재하지 않습니다.");
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "형식이 올바르지 않습니다.");
			}
			break;

		case "나가기":

			view.ShowOff();
			break;

		case "잔액":

			try {
				r = new ReadFile();
				an = view.getCombo();
				if (r.readFile(an)) {
					bankaccount_p = new BankAccount(an);
					JOptionPane.showMessageDialog(null, "잔액 : " + bankaccount_p.getBalance() + " 원");
				} else {
					JOptionPane.showMessageDialog(null, "계좌가 존재하지 않습니다");
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;

		}
	}
}
