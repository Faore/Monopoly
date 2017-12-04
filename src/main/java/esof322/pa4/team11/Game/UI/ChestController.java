package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.Board.Card.Card;
import esof322.pa4.team11.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class ChestController {
    public Label chestCard;
    private GameWindowController gameWindowController;

    public void setup(GameWindowController gameWindowController) {
        this.gameWindowController = gameWindowController;
    }

    public void setChestCard(Card card){
        chestCard.setText(card.description);
    }

    public void continueTurn(ActionEvent actionEvent) throws Exception {
        gameWindowController.endChestCard();
    }
}
