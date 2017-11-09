package im.admt.team11.PA3.Game.Board.Card;

import im.admt.team11.PA3.Game.Player;

public class Deed{
    String name;
    int location;
    int buyPrice;
    boolean sellable;
    Player owner;

    public Deed(String name, int location, int buyPrice) {
        this.name = name;
        this.location = location;
        this.buyPrice = buyPrice;
        sellable = true;
    }

    public boolean isSellable(){ return sellable; }

    public Player getOwner() { return owner; }

    public void setOwner(Player player){ owner = player; }

    public int getBuyPrice(){ return buyPrice; }

    public void mortgage(){ buyPrice /= 2; }



    //I don't know what this is supposed to do. Other than return itself?
    /*
    public Deed getInfo(){
        return Deed;
    }
    */
}