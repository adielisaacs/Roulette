package com.playsafe.part2.roulette;

public class Player {
	protected Integer playerid;
	protected String name;
	protected Integer numberBet;
	protected boolean isOddEven;
	protected Integer amount;
	protected String outcome;
	protected Double winning;
	protected String evenOdd;
	
	public Player() {
		super();
	}
	public Player(String name, Integer numberBet, boolean isOddEven) {
		super();
		this.name = name;
		this.numberBet = numberBet;
		this.isOddEven = isOddEven;
	}
	
	protected String getEvenOdd() {
		return evenOdd;
	}
	protected void setEvenOdd(String evenOdd) {
		this.evenOdd = evenOdd;
	}
	protected String getOutcome() {
		return outcome;
	}
	protected void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	protected Double getWinning() {
		return winning;
	}
	protected void setWinning(Double winning) {
		this.winning = winning;
	}
	protected Integer getAmount() {
		return amount;
	}
	protected void setAmount(Integer amount) {
		this.amount = amount;
	}
	protected Integer getPlayerid() {
		return playerid;
	}
	protected void setPlayerid(Integer playerid) {
		this.playerid = playerid;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected Integer getNumberBet() {
		return numberBet;
	}
	protected void setNumberBet(Integer numberBet) {
		this.numberBet = numberBet;
	}
	protected boolean isOddEven() {
		return isOddEven;
	}
	protected void setIsOddEven(boolean isOddEven) {
		this.isOddEven = isOddEven;
	}
}
