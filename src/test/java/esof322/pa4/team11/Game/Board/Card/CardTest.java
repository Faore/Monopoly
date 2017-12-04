package esof322.pa4.team11.Game.Board.Card;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card testCard;

    public CardTest() throws Exception{
        testCard = new Card(1, "Bank pays you dividend of $50");
    }

    @Test
    public void testGetCardNumber() throws Exception{
        assertEquals(1, testCard.getCardNum());
    }
}
