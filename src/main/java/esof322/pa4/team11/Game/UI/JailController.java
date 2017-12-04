package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

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
