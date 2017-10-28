package im.admt.team11.PA3;

public class Money {
	int money;
	
	public Money() {
		this.money = 0;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void addMoney(int money) {
		money += money;
	}
	
	public void subtractMoney() {
		money -= money;
	}
}
