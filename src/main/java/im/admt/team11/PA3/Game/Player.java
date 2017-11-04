package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Die;
import im.admt.team11.PA3.Game.Board.Pieces.Token;

public class Player {
	final int playerNumber;
	final Token token;
	int money;
	int position;
	ArrayList<Deeds> deeds;
	
	public Player(int playerNumber, Token token) {
		this.playerNumber = playerNumber;
		this.token = token;
		this.money = 0;
		this.position = 0;
		deeds = new ArrayList<Deeds>();
	}
	
	public int rollDie(Die die) {
		int roll = die.roll();
		//print
		return roll;
	}

	public int getNumber(){
		return playerNumber;
	}

	public Token getToken(){
		return token;
	}

	public void setToken(Token token){
		this.token = token;
	}

	public int getMoney(){
		return money;
	}

	public void giveMoney(int money){
		this.money += money;
	}

	public int getPosition(){
		return position;
	}

}
