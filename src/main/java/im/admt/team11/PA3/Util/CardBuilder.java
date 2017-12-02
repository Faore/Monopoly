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

    public static void buildChestCard(ObservableList<Card> chestCards){
        chestCards.add(new Card("chest", 1, "Advance to Go (Collect $200)"));
        chestCards.add(new Card("chest", 2, "Bank error in your favor. Collect $200"));
        chestCards.add(new Card("chest", 3, "Doctor's fee. Pay $50"));
        chestCards.add(new Card("chest", 4, "From sale of stock, you get $45"));
        chestCards.add(new Card("chest", 5, "Go directly to jail. Do not pass go, do not collect $200"));
        chestCards.add(new Card("chest", 6, "Grand Opera Opening, Collect $50 from every player"));
        chestCards.add(new Card("chest", 7, "XMas fund matures. Collect $100"));
        chestCards.add(new Card("chest", 8, "Income tax refund. Collect $20"));
        chestCards.add(new Card("chest", 9, "Life insurance matures. Collect $100"));
        chestCards.add(new Card("chest", 10, "Pay hospital $100"));
        chestCards.add(new Card("chest", 11, "Pay school tax of $150"));
        chestCards.add(new Card("chest", 12, "Receive for services $25"));
        chestCards.add(new Card("chest", 13, "You are assessed for street repairs. $45 per house. $115 per hotel"));
        chestCards.add(new Card("chest", 14, "You have won second prize in a  beauty contest. Collect $10"));
        chestCards.add(new Card("chest", 15, "You inherit $100"));
        chestCards.add(new Card("chest", 16, "Get out of jail free. This card may be kept until needed or sold"));
    }
}
