package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.Player;
import view.MainFrame;

public class SelectListListener implements ActionListener{
	private MainFrame ui;
	
	public SelectListListener(MainFrame ui) {

		this.ui = ui;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Player player = ui.getSelectPlayer();
		
		if (player == null)
		{
			return;
		}
		
		ui.updateStatus(player);

	}

}
