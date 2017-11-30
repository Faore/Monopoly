package im.admt.team11.PA3.Game.Board.Card;

public class Card {
    private String type;
    private int value;
    private int cardNum;
    private String description;

    public Card(String type, int value, int cardNum, String description){
        this.type = type;
        this.value = value;
        this.cardNum = cardNum;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public int getCardNum() {
        return cardNum;
    }

    public int getValue() {
        return value;
    }

    public String getDescription(){
        return description;
    }
}
