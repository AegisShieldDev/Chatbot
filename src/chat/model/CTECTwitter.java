package chat.model;

import chat.controller.ChatbotController;

import twitter4j.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class CTECTwitter
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTwitter;
	private List<String> tweetedWords;
	private long totalWordCount;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.searchedTwitter = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.totalWordCount = 0;
		
	}
	
	public void sendTweet(String textToTweet)
	{
		try 
		{
			chatbotTwitter.updateStatus(textToTweet + " @ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			appController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			appController.handleErrors(otherError);
		}
	}
}
