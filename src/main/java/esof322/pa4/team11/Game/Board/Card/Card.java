package esof322.pa4.team11.Game.Board.Card;

public class Card {
    private int cardNum;
    public String description;

    public Card(int cardNum, String description){
        this.cardNum = cardNum;
        this.description = description;
    }

    public int getCardNum() {
        return cardNum;
    }
}
