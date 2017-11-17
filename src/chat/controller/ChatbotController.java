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
		String response = display.getResponse("What do you want to talk about?");
		
		
	}
	/**
	*processed whenever the chatbot gets input. Passes code to processConversation for the rest of the words.
	*@param String chat
	*@return String chatbotSays
	*/
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
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
}
