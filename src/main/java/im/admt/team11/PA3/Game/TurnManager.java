package im.admt.team11.PA3.Game;

import java.util.ArrayList;
import java.util.Random;

public class TurnManager{

    public ArrayList<Player> players;
    public Player currentPlayer;
    private Random random;
    private int roll;
    private boolean endTurn;

    public TurnManager(){
        this.players = MonopolyGame.getInstance().gameSettings.players;
        this.currentPlayer = null;
        this.random = new Random();
        this.roll = 0;
        this.endTurn = false;
    }

    public Player getCurrentPlayer(){ return currentPlayer; }

    public int setTurnOrder(){
        int max = 0;
        int playerNum = 0;
        for (int i = 0; i < players.size(); i++) {
            roll = random.nextInt(11) + 2;
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
            int roleTotal = random.nextInt(11) + 2;
            //move player
        }

    }
}