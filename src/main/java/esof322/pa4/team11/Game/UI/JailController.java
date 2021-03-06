package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Player;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class JailController {
    public Button card;
    private GameWindowController gameWindowController;

    public void setup(GameWindowController gameWindowController) {
        this.gameWindowController = gameWindowController;
    }

    public void setup(Player player) {
        if(player.chanceJailCard || player.chestJailCard) {
            card.setDisable(false);
        } else {
            card.setDisable(true);
        }
    }

    public void rollToLeave(ActionEvent actionEvent) throws Exception {
        gameWindowController.rollToLeaveJail();
    }

    public void payToLeave(ActionEvent actionEvent) throws Exception {
        gameWindowController.payToLeaveJail();
    }

    public void card(ActionEvent actionEvent) throws Exception {
        gameWindowController.cardToLeaveJail();
    }
}
