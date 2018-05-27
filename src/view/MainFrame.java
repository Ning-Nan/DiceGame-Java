package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.PlayerRolled;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class MainFrame extends JFrame{
	
	private PlayerRolled playerRolled = new PlayerRolled();

	private GameEngine gameEngine = new GameEngineImpl();
	private ToolBar toolBar = new ToolBar(this.gameEngine,this,playerRolled);
	private StatusBar statusBar = new StatusBar();
	private InfoPanel infoPanel = new InfoPanel();
	private PullDownMenu pullDownMenu = new PullDownMenu(gameEngine, this);
	
	private GameEngineCallback gameEngineCallbackImpl = new GameEngineCallbackImpl();
	private GameEngineCallback gameEngineCallbackGUI = new GameEngineCallbackGUI(this, playerRolled);
	
	

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
	

}
