package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class JailController {
    public Button card;

    public void rollToLeave(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowController.rollToLeaveJail();
    }

    public void payToLeave(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowController.payToLeaveJail();
    }

    public void card(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowController.cardToLeaveJail();
    }
}
