
package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;

import java.util.ArrayList;

public class TurnManager{

    public int numPlayers;
    public ArrayList<Player> players;
    public int time;
    public Player currentPlayer;
    public ArrayList<Deed> deeds;
    public Deed currentDeed;
    private int roll;
    private boolean endTurn;


    public TurnManager(int numPlayers, int time){
        this.numPlayers = numPlayers;
        players = new ArrayList<Player>();
        this.time = time;
        this.currentPlayer = players.get(0);
        this.roll = 0;
        this.endTurn = false;
        this.deeds = new ArrayList<Deed>();
        this.currentDeed = null;
    }

    public Player getCurrentPlayer(){ return currentPlayer; }

    public Player getNextPlayer(Player player){
        int curPlayer = players.indexOf(player);
        if (curPlayer == players.size() - 1){
            curPlayer = 0;
        }else{
            curPlayer = curPlayer + 1;
        }
        return players.get(curPlayer);
    }

    public void nextTurn(){
        getNextPlayer(currentPlayer);

    }

    public boolean isEndTurn(){ return endTurn; }

    public void movePlayer(int roll){
        int currentPosition = currentPlayer.getPosition();
        int nextPosition = (currentPosition + roll) % 40;
        if(nextPosition < currentPosition){
            currentPlayer.giveMoney(200);
        }
        currentPlayer.updatePosition(nextPosition);
        Player owner = deeds.get(currentPosition).getOwner();
        if (owner != currentPlayer){
            //pay rent
        }
    }

    public void buyDeed(Deed deed){
        if (currentPlayer.getMoney() > deed.printedPrice){
            try{
                currentPlayer.buyDeed(deed);
            }catch(Exception e){
            }
        }
    }

    public void startAuction(){

    }
}