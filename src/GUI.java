import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;

public class GUI extends JFrame{
	private JFrame frame;
	
	private JPanel screen1;
	private JLabel quizLabel;
	private JComboBox<String> quizBox;
	private String[] quizNumbers;
	private JButton startButton;
	private int quizNumber;
	
	private JTextArea textArea1;
	private JScrollPane scrollbar1;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel titleLabel;
	private JTextField titleField;
	private JTextArea textArea2;
	private JScrollPane scrollbar2;
	private JPanel screen2;
	private JButton nextButton;
	private JButton checkButton;
	private JLabel correctName;
	private JLabel correctTitle;
	private Quiz quiz;
	private int passageIndex;
	
	
	
	GUI() {
		frame = new JFrame("DISC 2305 Final (made by Andrew Reis)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 750);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)(screenSize.getWidth() / 2 - frame.getWidth() / 2), (int)(screenSize.getHeight() / 2 - frame.getHeight() / 2));
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		screen1 = new JPanel();
		screen1.setLayout(null);
		quizLabel = new JLabel("Please select a quiz");
		quizLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		quizLabel.setBounds(516, 274, 274, 37);
		screen1.add(quizLabel);
		quizNumbers = new String[] {"Quiz 1", "Quiz 2", "Quiz 3"};
		quizBox = new JComboBox<String>(quizNumbers);
		quizBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		quizBox.setBounds(839, 271, 127, 37);
		screen1.add(quizBox);
		startButton = new JButton("Take the Quiz!");
		startButton.addActionListener(new Listener());
		startButton.setBounds(700, 375, 167, 29);
		screen1.add(startButton);
		frame.getContentPane().add(screen1, BorderLayout.CENTER);
		
		screen2 = new JPanel();
		screen2.setLayout(null);
		
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setWrapStyleWord(true);
		textArea1.setLineWrap(true);
		textArea1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea1.setRows(20);
		scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollbar1.setBounds(15, 0, 701, 688);
		screen2.add(scrollbar1);
		
		nameLabel = new JLabel("Enter the Last Name of the Author: ");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(767, 111, 336, 37);
		screen2.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameField.setBounds(1129, 118, 268, 26);
		screen2.add(nameField);
		nameField.setColumns(20);
		
		titleLabel = new JLabel("Enter the title of the work: ");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLabel.setBounds(767, 201, 336, 20);
		screen2.add(titleLabel);
		
		titleField = new JTextField();
		titleField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleField.setBounds(1129, 200, 268, 26);
		screen2.add(titleField);
		titleField.setColumns(20);
		
		textArea2 = new JTextArea();
		textArea2.setText("Why is this passage important? (Optional)");
		textArea2.setWrapStyleWord(true);
		textArea2.setLineWrap(true);
		textArea2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollbar2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollbar2.setBounds(767, 293, 630, 316);
		screen2.add(scrollbar2);
		
		checkButton = new JButton("Check Your Answers");
		checkButton.setBounds(1046, 625, 179, 29);
		screen2.add(checkButton);
		checkButton.addActionListener(new Listener());
		
		nextButton = new JButton("Next Passage");
		nextButton.setBounds(1240, 625, 143, 29);
		screen2.add(nextButton);
		nextButton.addActionListener(new Listener());
		
		
		correctName = new JLabel("Correct Name: ");
		correctName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		correctName.setBounds(1015, 149, 382, 20);
		screen2.add(correctName);
		correctName.setVisible(false);
		
		correctTitle = new JLabel("Correct Title: ");
		correctTitle.setBounds(1015, 237, 382, 20);
		correctTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		screen2.add(correctTitle);
		correctTitle.setVisible(false);
	
		nextButton.setEnabled(false);
		
		frame.setVisible(true);
	}
	
	private class Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == startButton) {
				frame.remove(screen1);
				frame.getContentPane().add(screen2, BorderLayout.CENTER);
				frame.revalidate();
				
				
				quiz = new Quiz(quizBox.getSelectedIndex());
				
				
				passageIndex = 0;
				textArea1.setText(quiz.passages.get(passageIndex).passages[quiz.index]);
			}
			if (e.getSource() == checkButton) {
				checkButton.setEnabled(false);
				nextButton.setEnabled(true);
				if (nameField.getText().equalsIgnoreCase(quiz.passages.get(passageIndex).lastName)) {
					nameField.setBackground(Color.GREEN);
				}
				else {
					nameField.setBackground(Color.RED);
					correctName.setVisible(true);
					correctName.setText("Correct Name: " + quiz.passages.get(passageIndex).lastName);
				}
				if (titleField.getText().equalsIgnoreCase(quiz.passages.get(passageIndex).title)) {
					titleField.setBackground(Color.GREEN);
				}
				else {
					titleField.setBackground(Color.RED);
					correctTitle.setVisible(true);
					correctTitle.setText("Correct Title: " + quiz.passages.get(passageIndex).title);
				}
			}
			
			if (e.getSource() == nextButton) {
				++passageIndex;
				if (passageIndex == quiz.passages.size() - 1) {
					nextButton.setText("Finish Quiz " + (quiz.index + 1));
				}
				if (passageIndex == quiz.passages.size()) {
					frame.dispose();
					passageIndex = 0;
				}
				correctTitle.setVisible(false);
				correctName.setVisible(false);
				nextButton.setEnabled(false);
				checkButton.setEnabled(true);
				nameField.setText("");
				nameField.setBackground(Color.WHITE);
				titleField.setText("");
				titleField.setBackground(Color.WHITE);
				textArea2.setText("Why is this passage important? (Optional)");
				
				textArea1.setText(quiz.passages.get(passageIndex).passages[quiz.index]);
			}
		}
		
	}
}
