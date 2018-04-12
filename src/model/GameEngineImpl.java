package model;

import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine {

	private Collection<GameEngineCallback> GEC = new ArrayList<GameEngineCallback>();
	private Collection<Player> playerList = new ArrayList<Player>();
	private DicePair dicePair = null;

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {

	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		dicePair = new DicePairImpl();
		GameEngineCallback _gEC = (GameEngineCallback) GEC;

		if (initialDelay <= 0 || finalDelay <= 0 || delayIncrement <= 0) {
			System.out.println("No time present.\r\n");
			return;
		}
		
		for(int delay = initialDelay; initialDelay < finalDelay ; initialDelay += delayIncrement){
			_gEC.intermediateHouseResult(dicePair, this);
		}
		
		_gEC.houseResult(dicePair, this);

	}



	@Override
	public void addPlayer(Player player) {
		if (player.equals(null)) {
			System.out.println("No player present.\r\n");
		} else {
			playerList.add(player);
		}
	}

	@Override
	public Player getPlayer(String id) {
		if (id.equals(null)) {
			System.out.println("No id present.\r\n");
			return null;
		} else {
			Player player = null;
			player.getPlayerId().equals(id);
			return player;
		}

	}

	@Override
	public boolean removePlayer(Player player) {
		if (player.equals(null) || !playerList.contains(player)) {
			System.out.println("No player present.\r\n");
			return false;
		} else {
			playerList.remove(player);
			return true;
		}

	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (!gameEngineCallback.equals(null)) {
			System.out.println("Game Engine Call Back present.\r\n");
		}else {
			GEC.add(gameEngineCallback);
		}

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (gameEngineCallback.equals(null) || !GEC.contains(gameEngineCallback)) {
			System.out.println("No Game Engine Call Back present.\r\n");
			return false;
		}else {
			GEC.remove(gameEngineCallback);
			return true;
		}

	}

	@Override
	public Collection<Player> getAllPlayers() {
		return playerList;
	}

}
