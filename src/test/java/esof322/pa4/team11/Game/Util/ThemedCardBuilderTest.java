package esof322.pa4.team11.Game.Util;

import esof322.pa4.team11.Game.Board.Card.Card;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ThemedCardBuilderTest {
    @Test
    public void testFullMonopolyBoard() throws Exception {
        ObservableList<Card> chanceCards = FXCollections.observableArrayList();
        ObservableList<Card> chestCards= FXCollections.observableArrayList();
        ThemedCardBuilder.buildChanceCard(chanceCards);
        ThemedCardBuilder.buildChestCard(chestCards);
        assertTrue(chanceCards.size() == 16);
        assertTrue(chestCards.size() == 16);
    }
}
