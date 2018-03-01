package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;
import chat.model.CTECTwitter;

/**
 * Manages the chatbot application including model and frame of the view package
 * @author Wyatt Miller
 * @version 21.11.17
 */


public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	/**
	 * Creates the chatbot, popup display, and chat frame
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Wyatt Miller");
		myTwitter = new CTECTwitter(this);
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}

	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
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
	
	/**
	 * Getter for chatframe
	 * @return ChatFrame
	 */
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
	
	/**
	 * Runs all the checkers onto inputted text
	 * @param text
	 * @return response
	 */
	public String useCheckers(String text)
	{
		String response  ="";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "This text matches the cuteAnimalMemeChecker";
		}
		if(chatbot.htmlTagChecker(text))
		{
			response += "This text matches the htmlTagChecker";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "This text matches the keyboardMashChecker";
		}
		if(chatbot.movieGenreChecker(text))
		{
			response += "This text matches the movieGenreChecker";
		}
		if(chatbot.movieTitleChecker(text))
		{
			response += "This text matches the movieTitleChecker";
		}
		if(chatbot.shoppingListChecker(text))
		{
			response += "This text matches the shoppingListChecker";
		}
		if(chatbot.userNameChecker(text))
		{
			response += "This text matches the UsernameChecker";
		}
		return response;
	}
	
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
	
}
