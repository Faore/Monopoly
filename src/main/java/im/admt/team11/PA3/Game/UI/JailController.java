package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.awt.*;

public class JailController {
    public Button card;

    public void initialize() {
//        if (!MonopolyGame.getInstance().turnManager.getCurrentPlayer().chanceJailCard && !MonopolyGame.getInstance().turnManager.getCurrentPlayer().chestJailCard){
//            card.setDisable(true);
//        }
        MonopolyGame.getInstance().gameWindowManager.jailController = this;
    }

    public void rollToLeave(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.rollToLeaveJail();
    }

    public void payToLeave(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.payToLeaveJail();
    }

    public void card(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.cardToLeaveJail();
    }
}
