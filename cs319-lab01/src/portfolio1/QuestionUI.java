package portfolio1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.EventQueue;

public class QuestionUI extends JFrame
{
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5380090635516117072L;
	private JPanel contentPane;
	volatile boolean newAnswerMessage = false; 
	public String chosenAnswer;
	private String message;
	private JTextPane questionField;
	JLabel lblTimer;
	public int numAnswer;
	public ArrayList<Answer> a;
	private int clientPort;
	JButton button1 = new JButton("");
	JButton button2 = new JButton("");
	JButton button3 = new JButton("");
	JButton button4 = new JButton("");

	/**
	 * Create the frame.
	 */
	public QuestionUI(String q, ArrayList<Answer> answers, int port_, Color color)
	{
		numAnswer = answers.size();
		a = answers;
		clientPort = port_;
		
		setTitle("Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(color);

		
		JLabel lblTypeYourAnswer = new JLabel("Select your answer");
		lblTypeYourAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTypeYourAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeYourAnswer.setBounds(148, 102, 142, 31);
		contentPane.add(lblTypeYourAnswer);
		
		// This GUI takes an arraylist of answers and only adds the appropriate amount of buttons, based on the size of the answer Arraylist.
		// There can be no more than 4 buttons
		
		if (numAnswer >= 1){
			
			button1.setBounds(51, 150, 163, 23);
			button1.setText(answers.get(0).answer);
			
			button1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							newAnswerMessage = true;
							chosenAnswer = button1.getText();
						}
					});
				}
			});
			contentPane.add(button1);
		}
		
		
		if (numAnswer >= 2){
			
			button2.setBounds(226, 150, 163, 23);
			button2.setText(answers.get(1).answer);
			
			button2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							newAnswerMessage = true;
							chosenAnswer = button2.getText();
						}
					});
				}
			});
			contentPane.add(button2);
		}

		if (numAnswer >= 3){
			
			button3.setBounds(51, 201, 163, 23);
			button3.setText(answers.get(2).answer);
			
			button3.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							newAnswerMessage = true;
							chosenAnswer = button3.getText();
						}
					});
				}
			});
			contentPane.add(button3);
		}
		
		if (numAnswer >= 4){
			
			button4.setBounds(226, 201, 163, 23);
			button4.setText(answers.get(3).answer);
			button4.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							newAnswerMessage = true;
							chosenAnswer = button4.getText();
						}
					});
				}
			});			
			contentPane.add(button4);
		}
		
		questionField = new JTextPane();
		StyledDocument doc = questionField.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		questionField.setFont(new Font("Gotham Medium", Font.BOLD, 25));
		questionField.setBounds(24, 18, 404, 80);
		questionField.setText(q);
		contentPane.add(questionField);
		
		lblTimer = new JLabel();
		lblTimer.setBounds(10, 100, 100, 50);
		contentPane.add(lblTimer);
	}
	
	public String getMessage()
	{		
		if(newAnswerMessage == true) {
			newAnswerMessage = false;
		}
		return chosenAnswer;
	}
	
	/**
	 * Changes the timer label to the msg parameter
	 * @param msg
	 */
	public void changeTimerText(String msg) {
		lblTimer.setText("Time Left: " + msg);
	}
	
	/**
	 * Highlights the correct answer in green, and it finds it based on port number
	 */
	public void highlightRightAnswer() {
		int buttonIndex = 0;
		for(int i = 0; i < numAnswer; i++) {
			if(a.get(i).port.equals(String.valueOf(clientPort))) {
				buttonIndex = i;
			}
		}
		
		if(buttonIndex == 0) {
			button1.setBackground(Color.GREEN);
		}
		else if(buttonIndex == 1) {
			button2.setBackground(Color.GREEN);
		}
		else if(buttonIndex == 2) {
			button3.setBackground(Color.GREEN);
		}
		else if(buttonIndex == 3) {
			button4.setBackground(Color.GREEN);
		}
	}
}

