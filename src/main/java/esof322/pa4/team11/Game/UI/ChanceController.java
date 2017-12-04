package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.Board.Card.Card;
import esof322.pa4.team11.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class ChanceController {
    public Label chanceCard;

    public void setChanceCard(Card card){
        chanceCard.setText(card.description);
    }

    public void continueTurn(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowController.endChanceCard();
    }
}
