package im.admt.team11.PA3.Util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import im.admt.team11.PA3.Game.Board.Card.Card;
import static org.junit.Assert.assertTrue;

public class CardBuilderTest {
    @Test
    public void testFullMonopolyBoard() throws Exception {
        ObservableList<Card> chanceCards = FXCollections.observableArrayList();
        ObservableList<Card> chestCards= FXCollections.observableArrayList();
        CardBuilder.buildChanceCard(chanceCards);
        CardBuilder.buildChestCard(chestCards);
        assertTrue(chanceCards.size() == 16);
        assertTrue(chestCards.size() == 16);
    }
}
