package 프로젝트;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ReadFile {
	private BufferedReader account_reader;
	boolean result = false;
	public boolean readFile(String an) throws IOException {
		try {
			account_reader = new BufferedReader(new FileReader(an + ".txt"));
			if(account_reader.ready()) result = true; return result;
		}
		catch(FileNotFoundException e) {
			return result;
		}
	}
}
