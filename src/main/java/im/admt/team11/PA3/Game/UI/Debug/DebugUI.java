package im.admt.team11.PA3.Game.UI.Debug;

import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DebugUI {

    public Label clickCoordinates;

    @FXML
    public void initialize() {
        MonopolyGame.getInstance().debugUI = this;
    }
}
