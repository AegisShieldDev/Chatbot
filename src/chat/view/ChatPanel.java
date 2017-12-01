package chat.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import chat.controller.ChatbotController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JTextField inputField;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton passButtonDos;
	private JButton passButtonTres;
	private JLabel infoLabel;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	/**
	 * Creator of the ChatPanel
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Init		
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check");
		passButtonDos = new JButton();
		passButtonDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passButtonTres = new JButton();
		inputField = new JTextField(20);
		chatArea = new JTextArea(10,25);
		appLayout = new SpringLayout();
		infoLabel = new JLabel();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	
	/**
	 * Setups the panel, adding buttons and other features
	 */
	private void setupPanel()
	{
		this.setBackground(Color.cyan);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		this.add(checkerButton);
		this.add(passButtonDos);
		this.add(passButtonTres);
		this.add(infoLabel);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}
	
	/**
	 * Provides formatting for parts setup
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 49, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, passButtonTres, 0, SpringLayout.SOUTH, passButtonDos);
		appLayout.putConstraint(SpringLayout.EAST, passButtonTres, -6, SpringLayout.WEST, passButtonDos);
		appLayout.putConstraint(SpringLayout.NORTH, passButtonDos, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, passButtonDos, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 2, SpringLayout.SOUTH, checkerButton);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 10, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatArea);
	}
	
	/**
	 * Adds listeners to various parts
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		checkerButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
			}
		});
		inputField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		checkerButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		passButtonTres.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
			}
		});
		
	}
}
