package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.util.Collection;

import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import sun.applet.Main;
import view.MainFrame;

public class PlaceBetListener implements ActionListener{
	
	private MainFrame ui;

	public PlaceBetListener( MainFrame ui){
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Player player = ui.getSelectPlayer();
		
		if (player == null)
		{
			JOptionPane.showMessageDialog(ui, "No Players!");
			return;
		}
		
		// cannot place bet after roll
		if (player.getRollResult() != null)
		{
			JOptionPane.showMessageDialog(ui, "This player has already rolled!! Cannot place bet until this round end!");
			return;
		}
		
		String str = JOptionPane.showInputDialog(ui,"Enter bets you want to place: ");
		int bets = 0;
		
		if (str == null)
		{
			return;
		}
		
		//validation
		try {
			bets = Integer.parseInt(str);
			if (bets <= 0)
			{
				throw new NumberFormatException();
			}
		} catch (NumberFormatException exception ) {
			JOptionPane.showMessageDialog(ui, "Invalid Bets!");
			return;
		}
		
		if (player.placeBet(bets) == false)
		{
			JOptionPane.showMessageDialog(ui, "Points Not Enough!");
			return;
		}
		
		//update status bar
		ui.updateStatus(player);
		
		
	}

}
