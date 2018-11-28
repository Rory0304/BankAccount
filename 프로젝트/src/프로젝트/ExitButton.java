package 프로젝트;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JButton;

public class ExitButton extends JButton implements ActionListener{
	public ExitButton(String label) {
			addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
