package client;

import java.util.Scanner;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;


public class T_Client {
	
	   public static void main(String[] args) {
		   
		   SimplePlayer player;
		   
		   GameEngine gameEngine = new GameEngineImpl();
		   
		   Scanner scanner = new Scanner(System.in);
		   
		   // Ask how many players, but in String? hmmm
		   String playerNUMBER_X; //***
		   int playerNUMBER = 0; // detect from Arraylist?
		   
		   System.out.println("How many lucky players are joining the game?");
		   System.out.print("Enter here: ");
		   
		   // **insert try catch later**
		   playerNUMBER_X = scanner.nextLine();

		   /** though of making the game a little more interesting, hmmm
		   if (playerNUMBER == 1) {
			   System.out.println("Let the game begin!\n");
		   }else {
			   System.out.println("Best of luck guys!\n");
		   }
		   **/
		   
		// save player detail into array
		   for (int i=0; i < playerNUMBER; i++) {
			   // print player's ID
			   System.out.println("Players' ID: " + i);
			   System.out.print("Enter your name: ");
			   String playerNAME = scanner.nextLine();
			   
			   //initialize player's initial bet
			   int playerBET = 1000;
			   
			   player = new SimplePlayer(playerNAME, playerNAME, playerBET);
			   
			   
		   }
		   //show player's details
		   
		   // use for each to show player
		   
		   // place bet
		   
		   // run game
		   
		   // display result
	   }

}
