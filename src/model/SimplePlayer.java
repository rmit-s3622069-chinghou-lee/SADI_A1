package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	
	   private String playerID;
	   private String playerNAME;
	   private int playerBET;
	   private int playerPOINTS;
	   private DicePair rollRESULT;

	   public SimplePlayer(String playerID, String playerNAME, int playerPOINTS)
	   {
	     
	      this.playerID = playerID;
	      this.playerNAME = playerNAME;
	      this.playerBET = 0;
	      this.playerPOINTS = playerPOINTS;
	      this.rollRESULT = null;
	   }

	@Override
	public String getPlayerName() {
		return playerNAME;
	}

	@Override
	public void setPlayerName(String playerName) {
		 this.playerNAME = playerNAME;		
	}

	@Override
	public int getPoints() {
		return playerPOINTS;
	}

	@Override
	public void setPoints(int points) {
		this.playerPOINTS = playerPOINTS;
		
	}

	@Override
	public String getPlayerId() {
		return playerID;
	}

	@Override
	public boolean placeBet(int bet) {
		// if bet = 0, ?
		// if bet < points, ?
		// if bet > points, ?
		return false;
	}

	@Override
	public int getBet() {
		return playerBET;
	}

	@Override
	public DicePair getRollResult() {
		return rollRESULT;
	}

	@Override
	public void setRollResult(DicePair rollResult) {
		this.rollRESULT = rollResult;
		
	}

}
