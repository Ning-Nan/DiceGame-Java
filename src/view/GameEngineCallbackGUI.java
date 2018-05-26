package view;

import java.util.logging.Level;

import javax.swing.SwingUtilities;

import com.sun.security.auth.NTDomainPrincipal;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import controller.HouseRollListener;
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

		
		String message = "<html>" + getMessage(null, result, "*RESULT*") + "<br>";
		
		int houseSum = result.getDice1() + result.getDice2();
		
		for (Player player: gameEngine.getAllPlayers()){
			
			int playerSum = player.getRollResult().getDice1() + player.getRollResult().getDice2();
			
			if (playerSum > houseSum)
			{
				message = message + "Win! ";
			}
			else if (playerSum == houseSum)
			{
				message = message + "Draw! ";
			}
			else if (playerSum < houseSum)
			{
				message = message + "Lose! ";
			}
			
			message = message + player.toString() + ", Result Sum: " + playerSum +  "<br>"; 
			
			player.setRollResult(null);
		}
		
		final String resultMessage = message + "<br>Note: This round is end and the player dice result is reset!" + "</html>";
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				ui.updatePanel(resultMessage);
				ui.updateStatus(ui.getSelectPlayer());
			}
		});
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
				ui.updateStatus(ui.getSelectPlayer());
			}
		});
	}

}
