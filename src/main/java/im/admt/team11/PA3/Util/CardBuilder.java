package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Card.Card;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CardBuilder {

    public static void buildChanceCard(ObservableList<Card> chanceCards){
        chanceCards.add(new Card("chance", 0, 1, "Advance to Go (Collect $200)"));
        chanceCards.add(new Card("chance", 0, 2, "Bank pays you dividend of $50"));
        chanceCards.add(new Card("chance", 0, 3, "Go back 3 spaces"));
        chanceCards.add(new Card("chance", 0, 4, "Advance token to nearest utility. " +
                "If unowned, you may buy it from the bank. If owned, roll dice and pay owned 10 times the amount"));
        chanceCards.add(new Card("chance", 0, 5, "Advance token to nearest railroad and " +
                "pay the owner twice the rent they are otherwise entitled. If railroad unowned, you may buy it from the bank"));
    }

    public static void buildChestCard(ObservableList<Card> chestCard){
        chestCard.add(new Card("chest", 0, 1,
                "Grand Opera Opening, Collect $50 from every player"));
    }
}
