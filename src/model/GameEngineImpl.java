package model;
import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
public class GameEngineImpl implements GameEngine  {

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getPlayer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
	      
	      
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		Collection<Player> Player = new ArrayList<Player>();
		return Player;
	}

}
