package im.admt.team11.PA3;

import java.util.Random;

public class Die {

	public int roll() {
		Random r = new Random();
		int roll = r.nextInt(6) + 1;
		return roll;
	}

}
