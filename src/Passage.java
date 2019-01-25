import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Passage {
	protected int numberOfPassages;
	protected String[] passages;
	protected String title;
	protected String lastName;
	
	Passage(String fileName, String lastName, String title) {
		this.title = title;
		this.lastName = lastName;
		Scanner fin = null;
		
		try {
			fin = new Scanner(new File(fileName));
			String contents = "";
			while (fin.hasNext()) {
				contents += fin.nextLine();
			}
			passages = contents.split("@");
			numberOfPassages = passages.length;
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Missing File: " + fileName, "FILE IO ERROR", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			if (fin != null) {
				fin.close();
			}
		}
	}
}
