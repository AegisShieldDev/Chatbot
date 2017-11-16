package chat.view;

import javax.swing.JPanel;
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
	private JButton passButton;
	private JButton passButtonDos;
	private JButton passButtonTres;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Init		
		chatButton = new JButton("chat");
		passButton = new JButton("pass");
		passButtonDos = new JButton();
		passButtonTres = new JButton();
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
		this.add(passButton);
		this.add(passButtonDos);
		this.add(passButtonTres);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 49, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -21, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
	}
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
			}
		});
		passButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
			}
		});
		passButtonDos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
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
