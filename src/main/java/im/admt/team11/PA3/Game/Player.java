package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    public final int playerNumber;
    public final Token token;
    private int money;
    public ObservableList<Deed> deeds;

    private Random random;

    public Player(int playerNumber, TokenTypes tokenType) {
        this.playerNumber = playerNumber;
        this.token = new Token(tokenType, this);
        this.money = 1500;
        deeds = FXCollections.observableArrayList();
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(10) + 2;
    }

    public int getPlayerValue() {
        int value = this.money;
        for(Deed deed: this.deeds) {
            value += deed.printedPrice;
        }
        return value;
    }

    public Token getToken() {
        return token;
    }

    public int getMoney() {
        return money;
    }

    public void takeMoney(int money) {
        this.money -= money;
    }

    public void giveMoney(int money) {
        this.money += money;
    }

    public void collectMoneyFromPlayer(Player player, int money) {
        player.takeMoney(money);
        giveMoney(money);
    }

    public void buyDeed(Deed deed, int auctionAmount) throws Exception {
        if (deed.currentOwner == null) {
            deed.setOwner(this);
            this.takeMoney(auctionAmount);
        } else {
            throw new Exception("Tried to buy deed that's already owned.");
        }
    }

    public void buyDeed(Deed deed) throws Exception {
        if (deed.currentOwner == null) {
            deed.setOwner(this);
            this.takeMoney(deed.printedPrice);
        } else {
            throw new Exception("Tried to buy deed that's already owned.");
        }
    }

    public void removeDeed(Deed deed) {
        int position = deeds.indexOf(deed);
        if (position >= 0) {
            deeds.remove(deed);
        }
    }
}
