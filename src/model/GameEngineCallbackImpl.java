package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging
 * behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
	private Logger logger = Logger.getLogger("assignment1");

	public GameEngineCallbackImpl() {
		logger.setLevel(Level.FINE);
	}
	
	// TO DO: complete the GameEngineCallback interface implementation

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.interfaces.GameEngineCallback#intermediateResult(model.interfaces.
	 * Player, model.interfaces.DicePair, model.interfaces.GameEngine) Reference to
	 * Week 4 Tute lab Solution Get as OutputTrace.txt sample FINE: The Roller:
	 * ROLLING Dice 1: 5, Dice 2: 2 .. Total: 7
	 */
	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, String.format("%s: ROLLING Dice 1: %d,  Dice 2: %d .. Total: %d", player.getPlayerName(),
				dicePair.getDice1(), dicePair.getDice2(), dicePair.getDice1() + dicePair.getDice2()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.interfaces.GameEngineCallback#result(model.interfaces.Player,
	 * model.interfaces.DicePair, model.interfaces.GameEngine) Get as
	 * OutputTrace.txt sample INFO: The Roller: *RESULT* Dice 1: 5, Dice 2: 1 ..
	 * Total: 6
	 */
	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, String.format("%s: ROLLING Dice 1: %d,  Dice 2: %d .. Total: %d", player.getPlayerName(),
				result.getDice1(), result.getDice2(), result.getDice1() + result.getDice2()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * model.interfaces.GameEngineCallback#intermediateHouseResult(model.interfaces.
	 * DicePair, model.interfaces.GameEngine) Get as OutputTrace.txt sample INFO:
	 * FINE: House: ROLLING Dice 1: 5, Dice 2: 3 .. Total: 8
	 */
	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		// intermediate house results logged at Level.FINE
		logger.log(Level.FINE, String.format("House: ROLLING Dice 1: %d,  Dice 2: %d .. Total: %d", dicePair.getDice1(),
				dicePair.getDice2(), dicePair.getDice1() + dicePair.getDice2()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * model.interfaces.GameEngineCallback#houseResult(model.interfaces.DicePair,
	 * model.interfaces.GameEngine) 
	 * Get as OutputTrace.txt sample 
	 * INFO: House: *RESULT* Dice 1: 2, Dice 2: 6 .. Total: 8
	 * 
	 */
	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, String.format("House: *RESULT* Dice 1: %d,  Dice 2: %d .. Total: %d", result.getDice1(),
				result.getDice2(), result.getDice1() + result.getDice2()));

	}

	/*
	 * Get as OutputTrace.txt sample
	 * INFO: Player: id=1, name=The Roller, points=900
	 */
	public void playerResult(Player player, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, String.format("Player: id=%d,  name=%d, points= %d", player.getPlayerId(),
				player.getPlayerName(), player.getPoints()));
	}

}
