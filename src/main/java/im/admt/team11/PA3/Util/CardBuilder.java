package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Card.Card;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CardBuilder {

    public static void buildChanceCard(ObservableList<Card> chanceCard){
        chanceCard.add(new Card("chance", 0, 1));
    }

    public static void buildChestCard(ObservableList<Card> chestCard){
        chestCard.add(new Card("chest", 0, 1));
    }
}
