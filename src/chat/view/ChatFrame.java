package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	/**
	 * creates the ChatFrame, calls setupframe
	 * @param ChatbotController appController
	 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	
	/**
	 * Sets the settings for the chatframe
	 */
	private void setupFrame()
	{	
		this.setContentPane(appPanel);
		this.setSize(600,600);
		this.setTitle("Chatting with the chatbot");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * Getter for the appController
	 * @return
	 */
	public ChatbotController getBaseController()
	{
		return(appController);
	}
}
