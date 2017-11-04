package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Die;
import im.admt.team11.PA3.Game.Board.Pieces.Token;

import java.util.ArrayList;

public class TurnManager{

    public int numPlayers;
    public ArrayList<Player> players;
    public int time;

    public TurnManager(int numPlayers, int time){
        this.numPlayers = numPlayers;
        players = new ArrayList<Player>();
        this.time = time;
    }
}