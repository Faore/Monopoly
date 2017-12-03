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
    public int timeInJail;
    public boolean chanceJailCard;
    public boolean chestJailCard;

    public Player(int playerNumber, TokenTypes tokenType) {
        this.playerNumber = playerNumber;
        this.token = new Token(tokenType, this);
        this.money = 1500;
        this.timeInJail = 0;
        deeds = FXCollections.observableArrayList();
        this.chanceJailCard = false;
        this.chestJailCard = false;
    }

    public boolean inJail() {
        return timeInJail > 0;
    }

    public void setInJail(boolean inJail) {
        if(inJail) {
            timeInJail = 3;
        } else {
            timeInJail = 0;
        }
    }

    public void setChanceJailCard(boolean jailCard){
        this.chanceJailCard = chanceJailCard;
    }

    public void setChestJailCard(boolean jailCard){
        this.chestJailCard = chestJailCard;
    }

    public void decrementTimeInJail() {
        if(timeInJail > 0) {
            timeInJail--;
        }
    }

    public int getPlayerValue() {
        int value = this.money;
        for(Deed deed: this.deeds) {
            if(deed.isMortgaged) {
                value += deed.mortgageValue;
            } else {
                value += deed.printedPrice;
            }
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

    public int getChanceRepairs(){
        int repairs = 0;
        if (deeds.size() == 0){
            return repairs;
        }else{
            for (int i = 0; i < deeds.size(); i++){
                Deed currDeed = deeds.get(i);
                if (currDeed.getCurrentBuildingLevel() == 5) {
                    repairs += 100;
                }else {
                    for (int j = 0; j < currDeed.getCurrentBuildingLevel(); j++) {
                        repairs += 25;
                    }
                }
            }
        }
        return repairs;
    }

    public int getChestRepairs(){
        int repairs = 0;
        if (deeds.size() == 0){
            return repairs;
        }else{
            for (int i = 0; i < deeds.size(); i++){
                Deed currDeed = deeds.get(i);
                if (currDeed.getCurrentBuildingLevel() == 5) {
                    repairs += 115;
                }else {
                    for (int j = 0; j < currDeed.getCurrentBuildingLevel(); j++) {
                        repairs += 45;
                    }
                }
            }
        }
        return repairs;
    }
}
