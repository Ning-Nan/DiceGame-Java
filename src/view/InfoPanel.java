package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InfoPanel extends JPanel  {
	
	private JLabel diceInfo = new JLabel("No Result yet");
	
	
	public InfoPanel()
	{
		setLayout(new BorderLayout());
		Font font = new Font("Arial", 1, 16);
		
		diceInfo.setFont(font);
		diceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(diceInfo,BorderLayout.CENTER);
		
		
	}
	
	public void updatePanel(String message){
		
		diceInfo.setText(message);
		
	}
}
