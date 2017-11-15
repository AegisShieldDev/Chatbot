package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatController;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JTextField inputField;
	private JButton chatButton;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		
		//Init		
		chatButton = new JButton("chat");
		inputField = new JTextField(20);
		chatArea = new JTextArea(10,25);
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.cyan);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
	}
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
	
	}
}
