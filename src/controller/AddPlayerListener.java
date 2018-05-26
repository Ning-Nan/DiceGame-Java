package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.util.Collection;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class AddPlayerListener implements ActionListener{

	private MainFrame ui;
	private GameEngine gameEngine;
	
	public AddPlayerListener(GameEngine gameEngine, MainFrame ui) 
	{
		this.gameEngine = gameEngine;
		this.ui = ui;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//get Name and validation
		String playerName = JOptionPane.showInputDialog(ui,"Enter Player Name: ");
		
		if (playerName == null)
		{
			return;
		}
		
		if (playerName.equals(""))
		{
			JOptionPane.showMessageDialog(ui, "Name Cannot be empty!");
			return;
		}
		
		
		//get points and validation
		String str = JOptionPane.showInputDialog(ui,"Enter your points: ");
		
		if (str == null)
		{
			return;
		}
		
		int points = 0;
		
		try {
			points = Integer.parseInt(str);
			if (points <= 0)
			{
				throw new NumberFormatException();
			}
		} catch (NumberFormatException exception ) {
			JOptionPane.showMessageDialog(ui, "Invalid Points!");
			return;
		}
		
		
		//Add to gameEngine,update list, and auto-generate id
		Collection<Player> players = gameEngine.getAllPlayers();
		String id = (players.size() + 1) + "";
		Player player = new SimplePlayer(id, playerName, points);
		gameEngine.addPlayer(player);
		ui.updatePlayerList();
		
	}

}
