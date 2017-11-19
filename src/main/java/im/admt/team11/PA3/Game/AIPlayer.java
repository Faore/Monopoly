package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import im.admt.team11.PA3.Game.Board.Card.Deed;

public class AIPlayer extends Player {

    private double propertyBuyChance;

    public AIPlayer(int playerNumber, TokenTypes tokenType){
        super(playerNumber, tokenType);
        this.propertyBuyChance = (3/4);

    }

    public boolean aiBuyDeed(Deed deed){
        double buy = deed.printedPrice/getMoney();
        if (buy < propertyBuyChance){
            return true;
        }
        return false;
    }

    public void aiMove(){
        
    }

    @Override
    public boolean isAI(){ return true; }

}
