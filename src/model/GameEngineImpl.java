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
	private ArrayList<Player> playerList;
	private ArrayList<Integer> result;
	private GameEngineCallbackImpl GECI;
	private DicePairImpl dicePair;
	private int diceTotal;

	public GameEngineImpl() {
		GEC = new ArrayList<GameEngineCallback>();
		playerList = new ArrayList<Player>();
		GECI = new GameEngineCallbackImpl();
		dicePair = new DicePairImpl();
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}

	/*
	 * (non-Javadoc)
	 * @see model.interfaces.GameEngine#rollPlayer(model.interfaces.Player, int, int, int)
	 * 
	 * Delay reference from stackoverflow.com
	 * https://stackoverflow.com/questions/24104313/how-to-delay-in-java
	 */
	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {

		if (initialDelay <= 0 || finalDelay <= 0 || delayIncrement <= 0 || player.equals(null)) {
			System.out.println("Player unable to roll.\r\n");
			return;
		}

		for (int delay = initialDelay; initialDelay < finalDelay; initialDelay += delayIncrement) {
			dicePair = new DicePairImpl();
			diceTotal = dicePair.getDice1() + dicePair.getDice2();
			GECI.intermediateResult(player, dicePair, this);
			
			try        
			{
			    Thread.sleep(delay);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}

		}
		for (Player _player : playerList) {
			if (_player.getPlayerId().equals(player.getPlayerId())) {
				dicePair = new DicePairImpl();
				_player.setRollResult(dicePair);
				GECI.result(player, dicePair, this);
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

			GECI.intermediateHouseResult(dicePair, this);

		}
		dicePair = new DicePairImpl();
		diceTotal = dicePair.getDice1() + dicePair.getDice2();
		GECI.houseResult(dicePair, this);
		displayResult(diceTotal, this);
	}

	private void displayResult(int houseDicePair, GameEngineImpl gameEngineImpl) {
		if (playerList.contains(null)) {
			System.out.println("Unable to calculate result.\r\n");
			return;
		}

		for (Player _player : playerList) {
			int _playerResult = _player.getRollResult().getDice1() + _player.getRollResult().getDice2();

			if (_playerResult == 0 || _player.getRollResult().equals(null)) {
				System.out.println("Unable to display result.\r\n");
			}

			if (_playerResult == houseDicePair) {
				_player.setPoints(_player.getPoints() + _player.getBet());
			} else if (_playerResult > houseDicePair) {
				_player.setPoints((_player.getPoints() + _player.getBet()) * 2);
			} else {
				_player.setPoints(_player.getPoints());
			}
			GECI.playerResult(_player, this);
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
