package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Simple GUI class usingJOptionPane
 * @author Wyatt Miller
 * @version 1.0 11.17.2017
 */
public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/2.png"));
		windowTitle = "Chatbot says";
	}
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public String getResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
}