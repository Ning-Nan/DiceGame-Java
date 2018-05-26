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

	private JLabel statusLabel1 = new JLabel("No Data", JLabel.LEFT);
	private JLabel statusLabel2 = new JLabel("No Data", JLabel.CENTER);
	private JLabel statusLabel3 = new JLabel("No Data", JLabel.RIGHT);

	public StatusBar()
	{
		setLayout(new GridLayout(1, 3));
		
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		statusLabel1.setBorder(blackBorder);
		statusLabel2.setBorder(blackBorder);
		statusLabel3.setBorder(blackBorder);
		Font font = new Font("Arial", 1, 16);
		statusLabel1.setFont(font);
		statusLabel2.setFont(font);
		statusLabel3.setFont(font);

		
		add(statusLabel1);
		add(statusLabel2);
		add(statusLabel3);
		
	}
	
	public void updateStatus(Player player)
	{
		statusLabel1.setText(String.format("ID: %s Name: %s", player.getPlayerId(), player.getPlayerName()));
		statusLabel2.setText(String.format("Points: %d", player.getPoints()));
		statusLabel3.setText(String.format("Bet: %d", player.getBet()));
	}
}
