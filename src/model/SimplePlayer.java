package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player{

	private String playerId;
	private String playerName;
	private int points;
	private int bet;
	private DicePair dicePair;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints){
		
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
		
	}
	
	
	
	@Override
	public String getPlayerName() {
		
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		
		this.playerName = playerName;
		
	}

	@Override
	public int getPoints() {

		return this.points;
	}

	@Override
	public void setPoints(int points) {
		
		this.points = points;
		
	}

	@Override
	public String getPlayerId() {

		return this.playerId;
	}

	@Override
	public boolean placeBet(int bet) {

		//sufficient points
		if (this.points >=  bet){
			
			this.bet = bet;
			return true;
		}
		
		return false;
	}

	@Override
	public int getBet() {
		
		return this.bet;
	}

	@Override
	public DicePair getRollResult() {
		
		return this.dicePair;
	}

	@Override
	public void setRollResult(DicePair rollResult) {
		
		this.dicePair = rollResult;
		
	}
	
	@Override
	public String toString(){
		
		String message = String.format("Player: id=%s, name=%s, points=%d",
				playerId,playerName,points);
		
		return message;
		
	}

	
}
