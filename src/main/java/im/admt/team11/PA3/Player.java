package im.admt.team11.PA3;

public class Player {
	int id;
	String token;
	Money money = new Money();
	
	public Player(int id, String token) {
		this.id = id;
		this.token = token;
	}
	
	public int rollDie(Die die) {
		int roll = die.roll();
		//print
		return roll;
	}
	
	public int getId() {
		return id;
	}
	
	public String getToken() {
		return token;
	}
	
	public Money getMoney() {
		return money;
	}
}
