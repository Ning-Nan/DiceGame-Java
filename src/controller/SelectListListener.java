package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import model.interfaces.Player;
import view.MainFrame;

public class SelectListListener implements ActionListener{
	private MainFrame ui;
	
	public SelectListListener(MainFrame ui) {

		this.ui = ui;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Switch user and display related data in the panel and status bar
		Player player = ui.getSelectPlayer();
		
		if (player == null)
		{
			return;
		}
		
		ui.updateStatus(player);
		
		/*
		if (player.getRollResult() == null)
		{
			String message = "Not Rolled Yet!";
			ui.updatePanel(message);
		}
		else
		{
			String message = String.format("%s: *RESULT* %s Total: %d", player.getPlayerName(),
					player.getRollResult(),
					player.getRollResult().getDice1()+player.getRollResult().getDice2());
			
			ui.updatePanel(message);
		}
		*/
	}

}
