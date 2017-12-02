package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.Board.Card.Card;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class ChestController {
    public Label chestCard;

    public void initialize(){ MonopolyGame.getInstance().gameWindowManager.chestController = this;}

    public void setChestCard(Card card){
        chestCard.setText(card.description);
    }

    public void continueTurn(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.endChestCard();
    }
}
