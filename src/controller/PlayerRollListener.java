package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.PlayerRolled;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class PlayerRollListener implements ActionListener{

	private GameEngine gameEngine;
	private MainFrame ui;
	private Player player;
	private PlayerRolled playerRolled;
	
	public PlayerRollListener(GameEngine gameEngine, MainFrame ui, PlayerRolled playerRolled) {
		this.gameEngine = gameEngine;
		this.ui = ui;
		this.playerRolled = playerRolled;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		player = ui.getSelectPlayer();
		
		if (player == null)
		{
			JOptionPane.showMessageDialog(ui, "No Players!");
			return;
		}
		
		//cannot roll if does not place bet
		if (player.getBet() == 0)
		{			
			JOptionPane.showMessageDialog(ui, "This Player has not placed the bet!");
			return;
		}
		
		//cannot roll twice
		if (playerRolled.playerRolled(player) == true)
		{
			JOptionPane.showMessageDialog(ui, "This Player has already rolled this round!");
			return;
		}
		
		playerRolled.addToRolledPlayer(player);
		
		new Thread() {
			@Override
			public void run() {
				gameEngine.rollPlayer(player, 1, 500, 100);
			}
		}.start();

		
	}

}
