package ������Ʈ;

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
		case "Ȯ��":
			try {
				an = view.getCombo();
				int amount = Integer.parseInt(view.getEntermoney());
				bankaccount_p = new BankAccount(an);
				if (label == "�Ա�") {
					if (bankaccount_p.deposit(amount)) {
						int bal = bankaccount_p.getBalance();
						transaction_p = new WriteTransaction(label, amount, an, bal, " ");
						if (transaction_p.process()) {
							JOptionPane.showMessageDialog(null, amount + "���� ���������� �ԱݵǾ����ϴ�.");
						} else {
							JOptionPane.showMessageDialog(null, "�Աݿ� �����Ͽ����ϴ�.");
						}
					}
				}
				if (label == "���") {
					if (bankaccount_p.withdraw(amount)) {
						int bal = bankaccount_p.getBalance();
						transaction_p = new WriteTransaction(label, amount, an, bal, " ");
						if (transaction_p.process()) {
							JOptionPane.showMessageDialog(null, amount + "���� ���������� ��ݵǾ����ϴ�.");
						} else {
							JOptionPane.showMessageDialog(null, "��ݿ� �����Ͽ����ϴ�.");
						}
					}
				}

				if (label == "��ü") {
					String trans_an = view.getTransan();
					String trans_ac = view.getAccombo();
					if (trans_ac.equals("�Ѿ� ����")) {
						it = new IsTransaccount(trans_an);
						if (it.IsTransaccount()) {
							bankaccount_s = new BankAccount(trans_an);
							if (bankaccount_p.withdraw(amount)) {
								bankaccount_s.deposit(amount);
								int bal_p = bankaccount_p.getBalance();
								int bal_s = bankaccount_s.getBalance();
								transaction_p = new WriteTransaction(label, amount, an, bal_p, trans_an);
								transaction_s = new WriteTransaction("�Ա�", amount, trans_an, bal_s, an);

								if (transaction_p.process() && transaction_s.process()) {
									JOptionPane.showMessageDialog(null, amount + "���� ���������� ��ü�Ǿ����ϴ�.");
								} else {
									JOptionPane.showMessageDialog(null, "��ü�� �����Ͽ����ϴ�.");
								}
							}
						}
					}
					else {
						if (bankaccount_p.transfer(amount)){
							int bal_p = bankaccount_p.getBalance();
							transaction_p = new WriteTransaction(label, amount, an, bal_p, trans_an);
							if (transaction_p.process()) {
								JOptionPane.showMessageDialog(null, amount + "���� ���������� ��ü�Ǿ����ϴ�.");
							} else {
								JOptionPane.showMessageDialog(null, "��ü�� �����Ͽ����ϴ�.");
							}
						}
					}
				}

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "���°� �������� �ʽ��ϴ�.");
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "������ �ùٸ��� �ʽ��ϴ�.");
			}
			break;

		case "������":

			view.ShowOff();
			break;

		case "�ܾ�":

			try {
				r = new ReadFile();
				an = view.getCombo();
				if (r.readFile(an)) {
					bankaccount_p = new BankAccount(an);
					JOptionPane.showMessageDialog(null, "�ܾ� : " + bankaccount_p.getBalance() + " ��");
				} else {
					JOptionPane.showMessageDialog(null, "���°� �������� �ʽ��ϴ�");
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;

		}
	}
}
