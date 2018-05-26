package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.Player;

public class StatusBar extends JPanel{

	private JLabel statusLabel1 = new JLabel("No Player", JLabel.CENTER);
	private JLabel statusLabel2 = new JLabel("No Player", JLabel.CENTER);
	private JLabel statusLabel3 = new JLabel("No Player", JLabel.CENTER);
	private JLabel statusLabel4 = new JLabel("No Player", JLabel.CENTER);

	public StatusBar()
	{
		setLayout(new GridLayout(1, 4));
		
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		statusLabel1.setBorder(blackBorder);
		statusLabel2.setBorder(blackBorder);
		statusLabel3.setBorder(blackBorder);
		statusLabel4.setBorder(blackBorder);
		
		Font font = new Font("Arial", 1, 16);
		statusLabel1.setFont(font);
		statusLabel2.setFont(font);
		statusLabel3.setFont(font);
		statusLabel4.setFont(font);

		
		add(statusLabel1);
		add(statusLabel2);
		add(statusLabel3);
		add(statusLabel4);
		
	}
	
	public void updateStatus(Player player)
	{
		statusLabel1.setText(String.format("ID: %s Name: %s", player.getPlayerId(), player.getPlayerName()));
		statusLabel2.setText(String.format("Points: %d", player.getPoints()));
		statusLabel3.setText(String.format("Bet: %d", player.getBet()));
		if(player.getRollResult() != null){
			statusLabel4.setText(String.format("Roll Result: %d", player.getRollResult().getDice1()+player.getRollResult().getDice2()));
		}
		else{
			statusLabel4.setText("Roll Result: No result yet");
		}
	}
}
