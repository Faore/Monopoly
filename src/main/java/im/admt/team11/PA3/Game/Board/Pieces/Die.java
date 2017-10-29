package im.admt.team11.PA3.Game.Board.Pieces;

import java.util.Random;

public class Die {

	private final Random random;

	public Die() {
		this.random = new Random();
	}

	public int roll() {
		return this.random.nextInt(6) + 1;
	}

}
