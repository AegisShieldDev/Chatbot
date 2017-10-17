package chat.view;

import javax.swing.JOptionPane;

/**
 * Simple GUI class usingJOptionPane
 * @author Wyatt Miller
 * @version 1.0 11.17.2017
 */
public class PopupDisplay
{
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	public String getResponse(String fromQuestion)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, fromQuestion);
		
		return answer;
	}
}