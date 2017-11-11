package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Die;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Card.Deed;

import java.util.ArrayList;

public class Player {
	public final int playerNumber;
	public final Token token;
	public int ownMoney;
	public int position;
	public ArrayList<Deed> deeds;
	
	public Player(int playerNumber, Token token) {
		this.playerNumber = playerNumber;
		this.token = token;
		this.ownMoney = 0;
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
		return ownMoney;
	}

	public void withdrawlMoney(int money){ ownMoney -= money; }

	public void giveMoney(int money){
		this.ownMoney += money;
	}

	public void transferMoney(int money, Player player){
		player.withdrawlMoney(money);
		if (player != null){
			player.giveMoney(money);
		}
	}

	public boolean isBankrupt(){
		if (ownMoney <= 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void setBankrupt(){
		ownMoney = 0;
		//need more
	}

	public int getPosition(){
		return position;
	}

	public void updatePosition(int pos){ position = pos; }

	public void addDeed(Deed deed){ deeds.add(deed); }

	public void buyDeed(Deed deed){
		if (deed.isSellable()){
			addDeed(deed);
			deed.setOwner(this);
		}
	}

	public ArrayList<Deed> getDeeds() { return deeds; }

	public void removeDeed(Deed deed){
		int position = deeds.indexOf(deed);
		if (position >= 0){
			deeds.remove(deed);
		}
	}
}
