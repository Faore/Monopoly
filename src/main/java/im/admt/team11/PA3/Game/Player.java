package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Die;
import im.admt.team11.PA3.Game.Board.Pieces.Token;

import java.util.ArrayList;

public class Player {
	public final int playerNumber;
	public final Token token;
	public int money;
	public int position;
	public ArrayList<Deed> deeds;
	
	public Player(int playerNumber, Token token) {
		this.playerNumber = playerNumber;
		this.token = token;
		this.money = 0;
		this.position = 0;
		deeds = new ArrayList<Deed>();
	}
	
	public int rollDie(Die die) {
		return die.roll();
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
