package chat.controller;

import chat.view.PopupDisplay;

public class ChatRunner
{
	public static void main(String [] args)
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("words");
		ChatController appController = new ChatController();
		appController.start();
		
		
	}
}

