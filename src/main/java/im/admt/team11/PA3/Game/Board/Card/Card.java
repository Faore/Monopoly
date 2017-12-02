package im.admt.team11.PA3.Game.Board.Card;

public class Card {
    private String type;
    private int cardNum;
    public String description;

    public Card(String type, int cardNum, String description){
        this.type = type;
        this.cardNum = cardNum;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public int getCardNum() {
        return cardNum;
    }
}
