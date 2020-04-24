package com.playsafe.part2.roulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	List<Player> players = new ArrayList<Player>();
	
	public List<String> getUsersFromFile() throws IOException{
		String pathToCsv = "src/main/java/users.csv";
		File csvFile = new File(pathToCsv);
		
		List<String> listuser = new ArrayList<String>();
		String csvLine;
		try {	
			if (csvFile.isFile()) {
				BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
				while ((csvLine = csvReader.readLine()) != null) {
					System.out.println("fromfile : "+csvLine);

				    listuser.add(csvLine);
				}
				csvReader.close();
				
				    // create BufferedReader and read data from csv
			}
		}catch(IOException io) {
			System.out.print("Game Failed to load Users");
		}
		return listuser;
	}
	
	public void loadPlayersFromFile() throws IOException {
		
		List<String> playersFromFile = getUsersFromFile();
		int idcount =0;
		for (String player : playersFromFile) {
			Player user = new Player();
			
			user.setPlayerid(idcount);
			user.setName(player);
			players.add(user);
			idcount++;

		}
		
	}
	
	public Integer getBallNumber() {
		int max = 36; 
        int min = 1; 
        int range = max - min + 1; 
  
        // generate random numbers within 1 to 10 
            int ballnumber = (int)(Math.random() * range) + min; 
  
            return ballnumber;
        } 
	public String getOddEven(int number) {
			
			if((number % 2) == 0) {
				return "EVEN";	
			}else {
				return "ODD";
			}
            
        } 
	public String placeBet(Integer playerid ,Integer selectNumber ,Integer amount) {
		players.get(playerid).setNumberBet(selectNumber);
		players.get(playerid).setAmount(amount);
		
		return "Bets Placed on Number";
	}
	
	public String placeBet(Integer playerid ,boolean isEvenOdd,String evenodd ,Integer amount) {
		players.get(playerid).setEvenOdd(evenodd);
		players.get(playerid).setIsOddEven(isEvenOdd);
		return "Bets Placed on Odd or Even";
	}
	
	public List<Player> getPlayersBets(){
		return players;
	}
	
	public void toStringResults() {
		Integer rouletteNo = getBallNumber();
		String rouletteNumberisOddEven = getOddEven(rouletteNo);
		
		for(Player player :players) {
			
			if(player.isOddEven()) {
				if(player.getEvenOdd().equals(rouletteNumberisOddEven))
					player.setWinning(new Double((player.getAmount()*2)));
				else
					player.setWinning(new Double(0.00));
			}else if (player.numberBet == rouletteNo) {
				player.setWinning(new Double((player.getAmount()*36)));
			}else {
				player.setWinning(new Double(0.00));
			}
			
		}
		
		System.out.println("Number:"+rouletteNo);
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("Player              |      BET        |            Outcome    |          Winnings  |");
		System.out.println("-------------------------------------------");
		for(Player playerz :players) {
			System.out.println("");
			System.out.print(playerz.getName());
			System.out.print("                     "+playerz.getNumberBet());
			if(playerz.getWinning() == 0.00) {
				System.out.print("                            Lost");
			}else {
				System.out.print("                           Win");
			}
			System.out.print("                                        "+playerz.getWinning());
		}


	}
}
