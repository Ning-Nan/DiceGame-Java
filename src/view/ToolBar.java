package view;



import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import controller.AddPlayerListener;
import controller.PlaceBetListener;
import controller.PlayerRollListener;
import controller.SelectListListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class ToolBar extends JToolBar {

	private JButton addPlayer = new JButton("Add Player");	
	private JButton placeBet = new JButton("Place Bet");
	private JButton playerRoll = new JButton("Player Roll");
	private JButton houseRoll = new JButton("House Roll");
	
	private JComboBox<String> selectPlayer = new JComboBox<>();
	private JLabel select = new JLabel("Select Player: ");
	
	public ToolBar(GameEngine gameEngine, MainFrame ui){
		
		selectPlayer.addItem("No players yet");
		add(select);
		add(selectPlayer);
		add(addPlayer);
		add(placeBet);
		add(playerRoll);
		add(houseRoll);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		AddPlayerListener addPlayerListener  = new AddPlayerListener(gameEngine,ui);
		addPlayer.addActionListener(addPlayerListener);
		
		SelectListListener selectListListener = new SelectListListener(ui);
		selectPlayer.addActionListener(selectListListener);
		
		PlaceBetListener placeBetListener = new PlaceBetListener(gameEngine, ui);
		placeBet.addActionListener(placeBetListener);
		
		PlayerRollListener playerRollListener = new PlayerRollListener(gameEngine, ui);
		playerRoll.addActionListener(playerRollListener);
	}
	
	
	public void updateList(GameEngine gameEngine)
	{
		//selectPlayer.removeActionListener(l);
		selectPlayer.removeAllItems();
		Collection<Player> players = gameEngine.getAllPlayers();
		for (Player player: players)
		{
			selectPlayer.addItem( String.format("%s %s", player.getPlayerId(), player.getPlayerName()));
		}
		
		//selectPlayer.addActionListener(l);
	}
	
	public String getSelectedPlayer()
	{	
		return (selectPlayer.getSelectedIndex() +1 )+ "";
	}
	
}
