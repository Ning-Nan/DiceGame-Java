package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine {

	private ArrayList<Player> players;
	private ArrayList<GameEngineCallback> callBacks;
	private Player house;

	public GameEngineImpl() {
		players = new ArrayList<>();
		callBacks = new ArrayList<>();
		
		//house do not need ID
		house = new SimplePlayer(null, "house", 0);
	}

	@Override
	public boolean placeBet(Player player, int bet) {

		return player.placeBet(bet);
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {

		rollHelper(player, initialDelay, finalDelay, delayIncrement);

	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {

		rollHelper(house, initialDelay, finalDelay, delayIncrement);
	}

	@Override
	public void addPlayer(Player player) {

		//if ID exits, simply replace it with the new one
		//here use iterator so we will not get exceptions
		Iterator<Player> it = players.iterator();
		
		while(it.hasNext()) {  
			
			Player tempPlayer = it.next();  
			
			if(player.getPlayerId().equals(tempPlayer.getPlayerId())) {
				it.remove();
			}
		}

			
		players.add(player);

	}
		

	@Override
	public Player getPlayer(String id) {

		for (Player player : players) {

			if (player.getPlayerId().equals(id)) {
				return player;
			}
		}

		return null;
	}

	@Override
	public boolean removePlayer(Player player) {

		return players.remove(player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {

		callBacks.add(gameEngineCallback);

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {

		return callBacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {

		//unmodifiable collection
		return Collections.unmodifiableCollection(players);
	}

	//roll helper that will deal with different role rolls
	private void rollHelper(Player player, int initialDelay, int finalDelay, int delayIncrement) {

		int delay = initialDelay;

		while (delay < finalDelay) {

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			DicePair dicePair = randomDice();

			for (GameEngineCallback callback : callBacks) {

				if (player == house) {

					callback.intermediateHouseResult(dicePair, this);

				} else {

					callback.intermediateResult(player, dicePair, this);
				}

			}

			delay = delay + delayIncrement;
		}

		//halt for a while
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		DicePair dicePair = randomDice();

		for (GameEngineCallback callback : callBacks) {

			if (player == house) {
				
				player.setRollResult(dicePair);
				caculateResult();
				callback.houseResult(dicePair, this);
				
			} else {
				
				player.setRollResult(dicePair);
				callback.result(player, dicePair, this);
			}

		}

	}

	
	private DicePair randomDice(){
		Random random = new Random();
		Random random1 = new Random();
		
		DicePair dicePair = new DicePairImpl(random.nextInt(NUM_FACES) + 1, random1.nextInt(NUM_FACES) + 1, NUM_FACES);
		return dicePair;
	}
	
	
	//update the result in player
	private void caculateResult(){
		
		int houseSum = Sum(house.getRollResult().getDice1(), house.getRollResult().getDice2());
		
		for (Player player: players){
			//update results
			//reset bet
			int playerSum = Sum(player.getRollResult().getDice1(), player.getRollResult().getDice2());
			
			if (playerSum > houseSum){
				player.setPoints(player.getPoints() + player.getBet());
				player.placeBet(0);
			}
			else if (playerSum == houseSum){
				player.placeBet(0);
			}
			else if (playerSum < houseSum){
				player.setPoints(player.getPoints() - player.getBet());
				player.placeBet(0);
			}
		}
		
		
	}
	
	private int Sum(int a, int b)
	{
		return a + b;
	}

}
