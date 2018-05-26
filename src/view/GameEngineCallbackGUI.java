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
		
		final String message = getMessage(player, dicePair, "ROLLING");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				ui.updatePanel(message);
			}
		});
		

	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		final String message = getMessage(player, result, "*RESULT*");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				ui.updatePanel(message);
			}
		});
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub

	}

	private String getMessage(Player player, DicePair dicePair, String action) {
		// house player
		if (player == null) {

			return String.format("House: %s %s Total: %d", action, dicePair, dicePair.getDice1() + dicePair.getDice2());
		}

		// player
		else {

			return String.format("%s: %s %s Total: %d", player.getPlayerName(), action, dicePair,
					dicePair.getDice1() + dicePair.getDice2());

		}
	}

}
