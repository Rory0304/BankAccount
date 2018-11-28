package 프로젝트;
import java.awt.event.*;

public class ButtonController implements ActionListener{
	private SignUpScreen view;
	private SignUp model;
	public ButtonController(SignUp m,SignUpScreen v) {
		view = v;
		model = m;
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}
