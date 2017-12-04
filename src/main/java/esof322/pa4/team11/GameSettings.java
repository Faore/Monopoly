package esof322.pa4.team11;

import esof322.pa4.team11.Game.Player;

import java.util.ArrayList;

public class GameSettings {
    public final ArrayList<Player> players;
    public int timeLimit;

    public GameSettings() {
        this.players = new ArrayList<Player>();
    }
}
