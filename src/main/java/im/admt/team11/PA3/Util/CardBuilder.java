package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Card.Card;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CardBuilder {

    public static void buildChanceCard(ObservableList<Card> chanceCards){
        chanceCards.add(new Card("chance", 1,  "Advance to Go (Collect $200)"));
        chanceCards.add(new Card("chance",  2, "Bank pays you dividend of $50"));
        chanceCards.add(new Card("chance",  3, "Go back 3 spaces"));
        chanceCards.add(new Card("chance",  4, "Advance token to nearest utility. If unowned, you may buy it from \n" +
                "the bank. If owned, roll dice and pay owned 10 times the amount"));
        chanceCards.add(new Card("chance",  5, "Advance token to nearest railroad and pay the owner twice the rent\n"  +
                " they are otherwise entitled. If railroad unowned, you may buy it\n" + "from the bank"));
        chanceCards.add(new Card("chance",  5, "Advance token to nearest railroad and pay the owner twice the rent\n"  +
                " they are otherwise entitled. If railroad unowned, you may buy it\n" + "from the bank"));
        chanceCards.add(new Card("chance",  7, "Go directly to jail. Do not pass go, do not collect $200"));
        chanceCards.add(new Card("chance",  8, "Pay poor tax of $15"));
        chanceCards.add(new Card("chance",  9, "Make general repairs on all your property. For each house pay $25, \n" +
                "for each hotel $100"));
        chanceCards.add(new Card("chance",  10, "Take a ride on the reading railroad, if you pass go collect $200"));
        chanceCards.add(new Card("chance",  11, "Advance to Illinois Avenue"));
        chanceCards.add(new Card("chance",  12, "Advance to St. Charles Place, if you pass go collect $200"));
        chanceCards.add(new Card("chance",  13, "Take a walk on the board walk, advance token to board walk"));
        chanceCards.add(new Card("chance",  14, "You have been elected chairman of the board, pay each player $50"));
        chanceCards.add(new Card("chance",  15, "Your building and loan matures. Collect $150"));
        chanceCards.add(new Card("chance",  16, "Get out of jail free. This card may be kept until needed or sold"));
    }

    public static void buildChestCard(ObservableList<Card> chestCard){
        chestCard.add(new Card("chest", 1, "Grand Opera Opening, Collect $50 from every player"));
    }
}
