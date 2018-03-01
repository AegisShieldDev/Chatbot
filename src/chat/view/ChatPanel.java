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
		inputField = new JTextField(20);
		infoLabel = new JLabel();
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -68, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -25, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -90, SpringLayout.EAST, loadButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -6, SpringLayout.NORTH, loadButton);
		chatScrollPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		checkerButton = new JButton("Check");
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, checkerButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -72, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 2, SpringLayout.SOUTH, checkerButton);
		chatArea = new JTextArea(20,20);
		
		
		
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
		chatArea = new JTextArea(20,25);
		appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, 330, SpringLayout.NORTH, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, 350, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		
		add(chatArea);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}
	
	/**
	 * Provides formatting for parts setup
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 6, SpringLayout.SOUTH, tweetButton);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -370, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -76, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, -8, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatButton);
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
		tweetButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
				
			}
		});
		searchButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				
				chatArea.setText(appController.search(usernameToSearch));
			}
		});
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				
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
		
		
	}
	
	
}
