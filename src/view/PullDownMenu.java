package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AddPlayerListener;
import model.interfaces.GameEngine;

public class PullDownMenu extends JMenuBar{
	
	private JMenu menu = new JMenu("Game");
	private JMenuItem addPlayer = new JMenuItem("Add Player");
	

	public PullDownMenu(GameEngine gameEngine, MainFrame ui){
		
		add(menu);
		menu.add(addPlayer);
		AddPlayerListener addPlayerListener = new AddPlayerListener(gameEngine, ui);
		addPlayer.addActionListener(addPlayerListener);
		
		
	}

}
