package view;

import java.awt.BorderLayout;

import javax.activation.UnsupportedDataTypeException;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import javafx.scene.layout.Border;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import sun.reflect.generics.tree.VoidDescriptor;

public class MainFrame extends JFrame{

	private GameEngine gameEngine = new GameEngineImpl();
	private ToolBar toolBar = new ToolBar(this.gameEngine,this);
	private StatusBar statusBar = new StatusBar();
	private InfoPanel infoPanel = new InfoPanel();
	
	// Need Test: Player cannot place bet after rolled and before this round end
	// Need Test: Player cannot roll until place bet
	// Need Test: Player can only roll once in every round
	// Need Test: House can only roll after player rolls
	public MainFrame()
	{
	
		super("Simple Dice Game");
		
		this.setLayout(new BorderLayout());
		
		
	    add(toolBar, BorderLayout.NORTH);
	    add(statusBar, BorderLayout.SOUTH);
	    add(infoPanel, BorderLayout.CENTER);
	   
						
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void updatePlayerList()
	{
		toolBar.updateList(gameEngine);
	}
	
	public Player getSelectPlayer()
	{
		Player player = gameEngine.getPlayer(toolBar.getSelectedPlayer());
		return player;
	}
	
	public void updateStatus(Player player)
	{
		statusBar.updateStatus(player);
	}
	
}
