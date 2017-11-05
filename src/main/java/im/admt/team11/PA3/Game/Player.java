package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Die;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Card.Deed;

import java.util.ArrayList;

import java.util.ArrayList;

public class Player {
	final int playerNumber;

	//Removed final modifier from token (setToken wasn't valid)
	Token token;
	int money;
	int position;
	ArrayList<Deed> deeds;
	
	public Player(int playerNumber, Token token) {
		this.playerNumber = playerNumber;
		this.token = token;
		this.money = 0;
		this.position = 0;
		deeds = new ArrayList<Deed>();
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

	//I removed this because you can't change a final variable.
	/*public void setToken(Token token){
		this.token = token;
	}*/

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
