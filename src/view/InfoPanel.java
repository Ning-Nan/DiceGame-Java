package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel  {
	
	private JLabel diceInfo = new JLabel("No Rolling yet");
	private JLabel label = new JLabel("Rolling Data");
	public InfoPanel()
	{
		setLayout(new BorderLayout());
		Font font = new Font("Arial", 1, 16);
		
		diceInfo.setFont(font);
		diceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(diceInfo, BorderLayout.CENTER);
		add(label, BorderLayout.NORTH);
		
		
		
	}
	
	public void updatePanel(String message){
		
		diceInfo.setText(message);
		
	}
}
