package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.Board.Card.Card;
import esof322.pa4.team11.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class ChanceController {
    public Label chanceCard;
    private GameWindowController gameWindowController;

    public void setup(GameWindowController gameWindowController) {
        this.gameWindowController = gameWindowController;
    }

    public void setChanceCard(Card card){
        chanceCard.setText(card.description);
    }

    public void continueTurn(ActionEvent actionEvent) throws Exception {
        gameWindowController.endChanceCard();
    }
}
