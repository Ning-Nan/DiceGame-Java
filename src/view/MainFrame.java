package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainFrame extends JFrame{

	private GameEngine gameEngine = new GameEngineImpl();
	private ToolBar toolBar = new ToolBar(this.gameEngine,this);
	private StatusBar statusBar = new StatusBar();
	private InfoPanel infoPanel = new InfoPanel();
	private PullDownMenu pullDownMenu = new PullDownMenu(gameEngine, this);
	
	private GameEngineCallbackImpl gameEngineCallbackImpl = new GameEngineCallbackImpl();
	private GameEngineCallbackGUI gameEngineCallbackGUI = new GameEngineCallbackGUI(this);
	
	private Collection<Player> rolledPlayers = new ArrayList<Player>();
	

	public MainFrame()
	{
	
		super("Simple Dice Game");
		
		this.setLayout(new BorderLayout());
		
		
	    add(toolBar, BorderLayout.NORTH);
	    add(statusBar, BorderLayout.SOUTH);
	    add(infoPanel, BorderLayout.CENTER);
	    setJMenuBar(pullDownMenu);
						
		setBounds(100, 100, 800, 600);
        setMinimumSize(new Dimension(480, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameEngine.addGameEngineCallback(gameEngineCallbackGUI);
		gameEngine.addGameEngineCallback(gameEngineCallbackImpl);
		
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
	
	public void updatePanel(String message)
	{
		infoPanel.updatePanel(message);
	}
	
	//do this in the view class is much better in any other classes. Too many passing and calling method.
	//And we are not allowed to modify it in gameEngine. And here it is simple.
	public boolean playerRolled(Player player){
		
		if (rolledPlayers.contains(player))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void addToRolledPlayer(Player player)
	{
		rolledPlayers.add(player);
	}
	
	public void emptyRolledPlayer()
	{
		rolledPlayers.removeAll(rolledPlayers);
	}
}
