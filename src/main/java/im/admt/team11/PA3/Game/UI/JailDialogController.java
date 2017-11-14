package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.event.ActionEvent;

public class JailDialogController {
    public void rollOut(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.rollGetOutOfJail();
    }

    public void buyOut(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.payGetOutOfJail();
    }
}
