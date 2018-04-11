package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	
	   private String playerId;
	   private String playerNAME;
	   private int playerBET;
	   private int playerPOINTS;
	   private DicePair rollRESULT;

	   public SimplePlayer(String playerId, String playerNAME, int playerPOINTS)
	   {
	     
	      this.playerId = playerId;
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
<<<<<<< HEAD
	public void setPlayerName(String playerNAME) {
		 this.playerNAME = playerNAME;		
=======
	public void setPlayerName(String playerName) {
		 this.playerNAME = playerName;		
>>>>>>> branch 'master' of https://github.com/rmit-s3622069-chinghou-lee/SADI_A1.git
	}

	@Override
	public int getPoints() {
		return playerPOINTS;
	}

	@Override
<<<<<<< HEAD
	public void setPoints(int playerPOINTS) {
		this.playerPOINTS = playerPOINTS;
=======
	public void setPoints(int points) {
		this.playerPOINTS = points;
>>>>>>> branch 'master' of https://github.com/rmit-s3622069-chinghou-lee/SADI_A1.git
		
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public boolean placeBet(int bet) {
		if(bet < 0 || bet > playerPOINTS) {
			// Not placing any bet
			return false;
		}else {
			// Player points = player's point minus bet
			playerPOINTS -= bet;
			// set new player bet
			this.playerBET = bet;
			return true;
		}
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
