package client;

import java.util.Scanner;
import java.util.UUID;

import model.GameEngineCallbackImpl;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class Console_Client {

	public static void main(String[] args) {

		while (true) {
			GameEngineImpl GEI = new GameEngineImpl();
			SimplePlayer _SP = null;
			GEI.addGameEngineCallback(new GameEngineCallbackImpl());
			RunPlayer(GEI, _SP);
			RunBet(GEI, _SP);
			RunResult(GEI, _SP);
		}

	}

	private static void RunPlayer(GameEngineImpl GEI, SimplePlayer _SP) {

		// Initialize all variable
		UUID UUID = java.util.UUID.randomUUID();
		String _playerId, _playerName;
		int _playerNo = 0;
		int _playerPoints = 1000;


		// Start
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("How many lucky players are joining the game?\nEnter here: ");

			if (scanner.hasNextInt()) {
				_playerNo = scanner.nextInt();

				for (int i = 0; i < _playerNo; i++) {
					_playerId = UUID.toString();
					System.out.print("What is your name? : ");
					_playerName = scanner.next();

					_SP = new SimplePlayer(_playerId, _playerName, _playerPoints);

					GEI.addPlayer(_SP);
				}

			} else {
				System.out.println("Invalid Input!\n");
				continue;
			}

			scanner.close();
			break;
		}

	}
	
	private static void RunBet(GameEngineImpl GEI, Player _SP) {
		if(GEI.getAllPlayers().isEmpty() || _SP.equals(null)) {
			System.out.println("No player present!");
			return;
		}
		
		while(!GEI.getAllPlayers().isEmpty()) {
			Scanner scanner = new Scanner(System.in);
			
			// Use enhanced for loop with example from stackoverflow
			// https://stackoverflow.com/questions/26759954/enhanced-for-loop-and-null-check-of-objects
			for(Player _P : GEI.getAllPlayers()) {
				System.out.print("Enter your bet: ");
				
				if (scanner.hasNextInt()) {
					int _playerBet = scanner.nextInt();
					System.out.println("");
					
					_P.placeBet(_playerBet);
					GEI.rollPlayer(_P, 100, 200, 100);
				}else {
					System.out.println("Invalid Input!\n");
					continue;
				}
				scanner.close();
				break;
			}
		}
	}
	
	private static void RunResult(GameEngineImpl GEI, Player _SP) {
		// to calculate result...
	}

}
