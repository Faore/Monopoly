package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.event.ActionEvent;

import java.awt.*;

public class ChanceController {
    public Button okay;

    public void initialize(){ MonopolyGame.getInstance().gameWindowManager.chanceController = this;}

    public void continueTurn(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.continueTurn();
    }
}
