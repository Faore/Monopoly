package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.event.ActionEvent;

public class JailController {

    public void initialize() {
        MonopolyGame.getInstance().gameWindowManager.jailController = this;
    }

    public void rollToLeave(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.rollToLeaveJail();
    }

    public void payToLeave(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.payToLeaveJail();
    }
}
