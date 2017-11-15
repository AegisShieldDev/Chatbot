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

public class ChatPanel
{
	private ChatController appController;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		
	}
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
	
	}
}
