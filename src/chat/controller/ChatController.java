package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	//private ChatFrame appFrame;
	
	
	//Creates the chatbot
	public ChatController()
	{
		chatbot = new Chatbot("Wyatt Miller");
		display = new PopupDisplay();
	}
	
	
	//Startup method for bot, initial window
	public void start()
	{
		String response = display.getResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.getResponse(response);
		}
	}
	
	//processed whenever the chatbot gets input. Passes code to processConversation for the rest of the words.
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
