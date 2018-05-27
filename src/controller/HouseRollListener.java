package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import model.PlayerRolled;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class HouseRollListener implements ActionListener{
	private GameEngine gameEngine;
	private MainFrame ui;
	private PlayerRolled playerRolled;
	
	public HouseRollListener (GameEngine gameEngine, MainFrame ui, PlayerRolled playerRolled){
		this.gameEngine = gameEngine;
		this.ui = ui;
		this.playerRolled = playerRolled;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Collection<Player> players = gameEngine.getAllPlayers();
		
		 if (players.size() == 0)
		 {
			 JOptionPane.showMessageDialog(ui, "No Players!");
			 return;
		 }
		
		for (Player player: players)
		{
			if (playerRolled.playerRolled(player) == false)
			{
				JOptionPane.showMessageDialog(ui, "House can only roll after all players have rolled!");
				return;
			}
		}
		
		new Thread() {
			@Override
			public void run() {
				gameEngine.rollHouse( 1, 500, 100);
			}
		}.start();
		
	}
	
	
}
