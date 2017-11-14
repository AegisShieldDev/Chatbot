package chat.view;

import chat.controller.ChatController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	public ChatController appController;
	
	public ChatFrame(ChatController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(600,600);
		this.setTitle("Chatting with the chatbot");
		this.setResizable(false);
		this.setContentPane(appPane);
		this.setVisible(true);
	}
}
