package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	//private ChatFrame appFrame;
	
	
	/**
	 * Creates the chatbot, popup display, and chat frame
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Wyatt Miller");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * Called by the runner
	 */
	public void start()
	{
	}

	/**
	 * Quits Chatbot
	 */
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	/*
	 * Getter for the display
	 * @return display
	 */
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	/*
	 * Getter for the chatbot
	 * @return chatbot
	 */
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	
	/**
	 * Controls interaction with the chatbot
	 * @param input
	 * @return interaction
	 */
	public String interactWithChatbot(String input)
	{
		String interact = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		interact += chatbot.processConversation(input);
		
		return interact;
	}
}
