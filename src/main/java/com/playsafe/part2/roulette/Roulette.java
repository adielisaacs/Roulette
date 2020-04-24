package com.playsafe.part2.roulette;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Roulette {
	
	public static void main(String[] agrs) {
		System.out.println("Welcome to Roulette");
		System.out.println("---------------------");
		System.out.println("");
		System.out.println("Loading Players for the game ");
		Game game = new Game();

		try {
			game.loadPlayersFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Game Players not loaded");
		}
		
		List<Player> loadedPlayers = game.getPlayersBets();
		for(Player player : loadedPlayers) {
			System.out.println("Place your bet for Player :"+player.getName());
			
			System.out.println("Are you betting with Number Y/N?"); 
			Scanner in = new Scanner(System.in);
			String number = in. nextLine();
			if((number.equals("Y"))||(number.equals("y"))) {
				System.out.println("Place Your bet with a selected number and amount betting on please.");
				String bet = in. nextLine();
				String[] values = bet.split(" ");
				player.setNumberBet(new Integer(values[0]));
				player.setAmount(new Integer(values[1]));
			}else {
				System.out.println("Place Your bet with a select (ODD or Even) and amount betting on please.");
				String bet = in. nextLine();
				String[] values = bet.split(" ");
				player.setIsOddEven(true);
				player.setEvenOdd(values[0]);
				player.setAmount(new Integer(values[1]));

				
			}
			
		}
		System.out. println("Results....");
		System.out. println("Processing....");
		game.toStringResults();
		
	}
}
