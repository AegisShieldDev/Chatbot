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
	
	
	//Creates the chatbot
	public ChatbotController()
	{
		chatbot = new Chatbot("Wyatt Miller");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	
	//Startup method for bot, initial window
	public void start()
	{
		String response = display.getResponse("What do you want to talk about?");
		
		
	}
	
	//processed whenever the chatbot gets input. Passes code to processConversation for the rest of the words.
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
	public Chatbot getChatbot()
	{
		return chatbot;
	}
}
