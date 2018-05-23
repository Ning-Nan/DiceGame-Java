package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class GameEngineCallbackGUI extends JFrame{
	
	public GameEngineCallbackGUI()
	{	
		//Title
		super("Dice Game");
		this.setLayout(new BorderLayout());
		
		
		JToolBar toolBar = new  ToolBar();
	    add(toolBar, BorderLayout.NORTH);
	    
	    
						
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
