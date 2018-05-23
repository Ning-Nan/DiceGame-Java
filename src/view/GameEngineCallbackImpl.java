package view;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
	private Logger logger = Logger.getLogger("assignment1");
	

	public GameEngineCallbackImpl()
	{
		// FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.FINE);
		
		//make the FINE visible in console
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
	{
		
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, getMessage(player, dicePair, gameEngine, "ROLLING"));

	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{

		// final results logged at Level.INFO
		logger.log(Level.INFO, getMessage(player, result, gameEngine, "*RESULT*"));
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, getMessage(null, dicePair, gameEngine, "ROLLING"));
		
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, getMessage(null, result, gameEngine, "*RESULT*"));
		
		//get result from the players that stored in gameEngine
		for (Player player: gameEngine.getAllPlayers()){
			
			logger.log(Level.INFO, player.toString());
		}
		
		
	}

	
	//helper method to generate log message
	private String getMessage(Player player, DicePair dicePair, GameEngine gameEngine, String action){
		
		//house player
		if (player == null){
			
			return String.format("House: %s %s Total: %d",
					action,
					dicePair,
					dicePair.getDice1()+dicePair.getDice2());
		}
		
		//player
		else{
			
			return String.format("%s: %s %s Total: %d",
					player.getPlayerName(),
					action,
					dicePair,
					dicePair.getDice1()+dicePair.getDice2());
			
		}
	}
}
