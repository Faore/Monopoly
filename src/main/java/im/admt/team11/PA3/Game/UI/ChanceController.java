package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.Board.Card.Card;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.event.ActionEvent;

import java.awt.*;

public class ChanceController {
    public Button okay;
    public Label chanceCard;

    public void initialize(){ MonopolyGame.getInstance().gameWindowManager.chanceController = this;}

    public void setChanceCard(Card card){
        chanceCard.setText(card.getDescription());
    }

    public void continueTurn(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.endShowCard();
    }
}
