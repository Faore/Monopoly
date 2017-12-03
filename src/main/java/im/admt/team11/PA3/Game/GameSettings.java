package im.admt.team11.PA3.Game;

import java.util.ArrayList;

public class GameSettings {
    public final ArrayList<Player> players;
    public int timeLimit;
    public int themeOption;

    public GameSettings() {
        this.players = new ArrayList<Player>();
    }
}
