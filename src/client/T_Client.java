package client;

import java.util.Scanner;

public class T_Client {
	
	   public static void main(String[] args) {
		   
		   Scanner scanner = new Scanner(System.in);
		   
		   // Ask how many players
		   int playerNUMBER = 0;
		   
		   System.out.println("How many lucky players are joining the game?");
		   System.out.print("Enter here: ");
		   
		   // **insert try catch later**
		   playerNUMBER = scanner.nextInt();

		   // make game a little more interesting
		   if (playerNUMBER == 1) {
			   System.out.println("Let the game begin!\n");
		   }else {
			   System.out.println("Best of luck guys!\n");
		   }
		   
		// save player detail into array
		   for (int playerID=0; i < playerNUMBER; i++) {
			   // print player's ID
			   System.out.println("Players' ID: " + playerID);
			   System.out.print("Enter your name: ");
			   String playerNAME = scanner.nextLine();
			   
			   //initialize player's initial bet
			   int playerBET = 1000;
			   
			   
		   }

		   
		   // create player array
		   
		   //show player's details
		   
		   // place bet
		   
		   // run game
		   
		   // display result
	   }

}
