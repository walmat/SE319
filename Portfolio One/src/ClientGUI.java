package portfolio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
<<<<<<< HEAD:Portfolio One/src/ClientGUI.java
=======
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

>>>>>>> Donavan:cs319-lab01/src/portfolio1/ClientGUI.java
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientGUI extends JFrame {

	private static final long serialVersionUID = 5380090635516117072L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea chatArea;

	volatile boolean newTextMessage = false;
	volatile boolean newImageMessage = false;
	private String message;
	public boolean startRound;
	private JButton btnSend;
	private String user;
<<<<<<< HEAD:Portfolio One/src/ClientGUI.java
	private JTextField scoreField;
=======
	
	//Score labels
	JLabel lblScore1;
	JLabel lblScore2;
	JLabel lblScore3;
	JLabel lblScore4;
>>>>>>> Donavan:cs319-lab01/src/portfolio1/ClientGUI.java

	/**
	 * Create the frame.
	 */
<<<<<<< HEAD:Portfolio One/src/ClientGUI.java
	public ClientGUI(String username, Color color, boolean type) {
		user = username;
		setTitle(user);
=======
	public ClientGUI(String username, Color color, boolean type)
	{
		user = username;
		setTitle(username);
>>>>>>> Donavan:cs319-lab01/src/portfolio1/ClientGUI.java
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(color);

		chatArea = new JTextArea();
		chatArea.setForeground(Color.BLACK);
		chatArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chatArea.setEnabled(false);
		chatArea.setBounds(6, 6, 175, 69);
		chatArea.setLineWrap(true);
		contentPane.add(chatArea);

		textField = new JTextField();
		textField.setBounds(24, 197, 306, 23);
		contentPane.add(textField);
		textField.setColumns(10);
<<<<<<< HEAD:Portfolio One/src/ClientGUI.java

=======
		
>>>>>>> Donavan:cs319-lab01/src/portfolio1/ClientGUI.java
		btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

			}
		});
		btnSend.setBounds(337, 199, 89, 23);
		contentPane.add(btnSend);

		// when btnsend pressed, send the message
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Set format of message and do some action to send it.
				newTextMessage = true;
			}
		});

		// allow for hitting enter to send a chat message
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// when user press Enter the message should be submit.
					newTextMessage = true;
				}

			}
		});

		JLabel lblChatHistory = new JLabel("Question");
		lblChatHistory.setBounds(17, 30, 161, 16);
		contentPane.add(lblChatHistory);

		JScrollPane scrollBar = new JScrollPane(chatArea);
		scrollBar.setLocation(24, 58);
		scrollBar.setSize(402, 101);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollBar);

		JLabel lblTypeYourAnswer = new JLabel("Type your fake answer");
		lblTypeYourAnswer.setBounds(17, 171, 161, 14);
		contentPane.add(lblTypeYourAnswer);
<<<<<<< HEAD:Portfolio One/src/ClientGUI.java

		scoreField = new JTextField();
		scoreField.setEditable(false);
		scoreField.setDragEnabled(false);
		scoreField.setBounds(377, 246, 67, 26);
		contentPane.add(scoreField);
		scoreField.setColumns(10);

		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(337, 252, 46, 14);
		contentPane.add(lblScore);

		if (type == true) {

=======
	
		if(type == true) {
			
>>>>>>> Donavan:cs319-lab01/src/portfolio1/ClientGUI.java
			JButton btnStart = new JButton("Start Round");
			btnStart.setBounds(275, 20, 147, 23);
			contentPane.add(btnStart);
			btnStart.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							startRound = true;
						}
					});
				}
			});
		}
<<<<<<< HEAD:Portfolio One/src/ClientGUI.java

		if (startRound == true) {
			startRound = false;
		}
	}

	public String getMessage() {
		if (newTextMessage == true) {
			newTextMessage = false;
			message = textField.getText();
		} else if (newImageMessage == true) {
			newImageMessage = false;
		}

		return message;

	}

	public void recieveMessage(String message) {
		if (!message.trim().equals("")) {
			chatArea.append(message + "\n");
		}
		textField.setText("");
	}

	public void changeBtnSendText(String txt) {
		btnSend.setText(txt);
	}
	
	public void changeScoreText(String score){
		scoreField.setText(score + "");
	}
=======
		
		if(startRound == true) {
			startRound = false;
		}
		
		// Initializing score labels
		lblScore1 = new JLabel();
		lblScore1.setBounds(450, 30, 161, 16);

		lblScore2 = new JLabel();
		lblScore2.setBounds(450, 60, 161, 16);
	
		lblScore3 = new JLabel();
		lblScore3.setBounds(450, 90, 161, 16);
	
		lblScore4 = new JLabel();
		lblScore4.setBounds(450, 120, 161, 16);
}

public String getMessage()
{		
	if(newTextMessage == true) {
		newTextMessage = false;
		message = textField.getText();
	}
	else if(newImageMessage == true) {
		newImageMessage = false;
	}
	
	return message;

}

public void recieveMessage(String message)
{
	if (!message.trim().equals("")){
		chatArea.append(message + "\n");
	}
	textField.setText("");
}	

public void changeBtnText(String txt) {
	btnSend.setText(txt);
}
	
// Updates UI to display everyones scores
public void updateScoreUI(ArrayList<Score> scores) { 
	
	if(scores.size() >= 1) {
		lblScore1.setText(scores.get(0).username + ": " + scores.get(0).score);
		contentPane.add(lblScore1);
	}
	
	if(scores.size() >= 2) {
		lblScore2.setText(scores.get(1).username + ": " + scores.get(1).score);
		contentPane.add(lblScore2);
	}
	
	if(scores.size() >= 3) {
		lblScore3.setText(scores.get(2).username + ": " + scores.get(2).score);
		contentPane.add(lblScore3);
	}
	
	if(scores.size() >= 4) {
		lblScore4.setText(scores.get(3).username + ": " + scores.get(3).score);
		contentPane.add(lblScore4);
	}
}
		
	
>>>>>>> Donavan:cs319-lab01/src/portfolio1/ClientGUI.java
}
