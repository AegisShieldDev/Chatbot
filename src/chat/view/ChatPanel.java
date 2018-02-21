package chat.view;

import javax.swing.*;
import chat.controller.ChatbotController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JTextField inputField;
	private JButton checkerButton, tweetButton, searchButton, loadButton, saveButton, chatButton;
	private JLabel infoLabel;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JScrollPane chatScrollPane;
	/**
	 * Creator of the ChatPanel
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Init		
		chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		tweetButton = new JButton("Twitter", new ImageIcon(getClass().getResource("/chat/view/images/twitter.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		chatArea = new JTextArea(25,25);
		inputField = new JTextField(20);
		infoLabel = new JLabel();
		appLayout = new SpringLayout();
		
		chatScrollPane = new JScrollPane();
		
		checkerButton = new JButton("Check");
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	/**
	 * Sets up the Scroll pane within the text area
	 */
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * Sets up the panel, adding buttons and other features
	 */
	private void setupPanel()
	{
		this.setBackground(Color.cyan);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(tweetButton);
		this.add(searchButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(checkerButton);
		this.add(infoLabel);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}
	
	/**
	 * Provides formatting for parts setup
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 49, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, loadButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -6, SpringLayout.WEST, loadButton);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, -70, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -50, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, -40, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, -40, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -20, SpringLayout.SOUTH, this);
	}
	
	/**
	 * Adds listeners to various parts including the chat button, check button, input field, and passButtons
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
		loadButton.addActionListener(new ActionListener() 
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
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
			}
		});
		
	}
}
