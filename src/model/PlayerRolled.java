package model;

import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.Player;

public class PlayerRolled {

	private Collection<Player> playersRolled;
	
	public PlayerRolled() {

		playersRolled = new ArrayList<>();
	}
	
	public boolean playerRolled(Player player){
		
		if (playersRolled.contains(player))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void addToRolledPlayer(Player player)
	{
		playersRolled.add(player);
	}
	
	public void emptyRolledPlayer()
	{
		playersRolled.removeAll(playersRolled);
	}
}
