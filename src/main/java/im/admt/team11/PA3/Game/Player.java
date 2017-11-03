package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Die;
import im.admt.team11.PA3.Game.Board.Pieces.Token;

public class Player {
	final int id;
	final Token token;
	int money;
	
	public Player(int id, Token token) {
		this.id = id;
		this.token = token;
	}
	
	public int rollDie(Die die) {
		int roll = die.roll();
		//print
		return roll;
	}
}
