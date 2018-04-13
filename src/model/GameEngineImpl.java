package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine {

	private Collection<GameEngineCallback> GEC;
	private Collection<Player> playerList;
	private HashMap<Player, Integer> playerResult;
	private HashMap<Player, Integer> finalResult;
	private GameEngineCallbackImpl GECI;
	private DicePairImpl dicePair;
	private int diceTotal;

	public GameEngineImpl() {
		GEC = new ArrayList<GameEngineCallback>();
		playerList = new ArrayList<Player>();
		playerResult = new HashMap<>();
		GECI = new GameEngineCallbackImpl();
		dicePair = new DicePairImpl();
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {

		if (initialDelay <= 0 || finalDelay <= 0 || delayIncrement <= 0) {
			System.out.println("No time present.\r\n");
			return;
		}

		for (int delay = initialDelay; initialDelay < finalDelay; initialDelay += delayIncrement) {
			dicePair = new DicePairImpl();
			diceTotal = dicePair.getDice1() + dicePair.getDice2();
			if (initialDelay < finalDelay) {
				GECI.intermediateResult(player, dicePair, this);
			} else {
				GECI.result(player, dicePair, this);
				playerResult.put(player, diceTotal);
				break;
			}
		}
		
		for(Player _player : playerList) {
			if(_player.getPlayerId().equals(player.getPlayerId())) {
				_player.setRollResult(dicePair);
			}
		}

	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {

		if (initialDelay <= 0 || finalDelay <= 0 || delayIncrement <= 0) {
			System.out.println("No time present.\r\n");
			return;
		}

		for (int delay = initialDelay; initialDelay < finalDelay; initialDelay += delayIncrement) {
			dicePair = new DicePairImpl();
			diceTotal = dicePair.getDice1() + dicePair.getDice2();
			String house = "House";
			if (initialDelay < finalDelay) {
				GECI.intermediateHouseResult(dicePair, this);
			} else {
				GECI.houseResult(dicePair, this);
				calculateResult(playerResult, diceTotal);
				break;
			}
		}

	}

	/*
	 * Reference Conversion Collection to Arraylist from stackoverflow
	 * https://stackoverflow.com/questions/1968068/java-how-to-convert-type-collection-into-arraylist
	 */
	private void calculateResult(HashMap<Player, Integer> playerResult, int diceTotal) {
		finalResult = new HashMap<>();
		ArrayList<Player> getPlayerList = new ArrayList<Player>(getAllPlayers());
		
		if(getPlayerList.isEmpty()) {
			System.out.println("No player present.\r\n");
		}
		
		while(finalResult.isEmpty()) {
			for (Player players: getPlayerList) {
				
			}
		}
		
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
		if (gameEngineCallback.equals(null)) {
			System.out.println("Game Engine Call Back is not present.\r\n");
		} else {
			GEC.add(gameEngineCallback);
		}

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (gameEngineCallback.equals(null) || !GEC.contains(gameEngineCallback)) {
			System.out.println("No Game Engine Call Back present.\r\n");
			return false;
		} else {
			GEC.remove(gameEngineCallback);
			return true;
		}

	}

	@Override
	public Collection<Player> getAllPlayers() {
		return playerList;
	}

}
