package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Die;
import im.admt.team11.PA3.Game.Board.Pieces.Token;

import java.util.ArrayList;

public class TurnManager{

    public int numPlayers;
    public ArrayList<Player> players;
    public int time;
    public Player currentPlayer;
    private Die die;
    private int roll;
    private boolean endTurn;

    public TurnManager(int numPlayers, int time){
        this.numPlayers = numPlayers;
        players = new ArrayList<Player>();
        this.time = time;
        this.currentPlayer = null;
        this.die = new Die();
        this.roll = 0;
        this.endTurn = false;
    }

    public Player getCurrentPlayer(){ return currentPlayer; }

    public int setTurnOrder(){
        int max = 0;
        int playerNum = 0;
        for (int i = 0; i < players.size(); i++) {
            roll = die.roll();
            if (roll > max) {
                max = roll;
                playerNum = i;
            }
        }
        return playerNum;
    }

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

    public void turns(){
        while(!isEndTurn()){
            int role1 = die.roll();
            int role2 = die.roll();
            int roleTotal = role1 + role2;
            //move player
        }

    }
}