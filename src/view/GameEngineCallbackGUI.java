package view;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback {

	private MainFrame ui;

	public GameEngineCallbackGUI(MainFrame ui) {
		this.ui = ui;
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		
		String message = getMessage(player, dicePair, "ROLLING");
		
		roll(message);
		

	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		String message = getMessage(player, result, "*RESULT*");
		
		roll(message);
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		String message = getMessage(null, dicePair, "ROLLING");
		
		roll(message);
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		String message = getMessage(null, result, "*RESULT*");
		
		
		roll(message);

	}

	private String getMessage(Player player, DicePair dicePair, String action) {
		// house player
		if (player == null) {

			return String.format("House: %s %s Total: %d", action,
					dicePair, 
					dicePair.getDice1() + dicePair.getDice2());
		}

		// player
		else {

			return String.format("%s: %s %s Total: %d", player.getPlayerName(), 
					action, 
					dicePair,
					dicePair.getDice1() + dicePair.getDice2());

		}
	}
	
	private void roll(String str){
		
		final String message = str;
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				ui.updatePanel(message);
			}
		});
	}

}
