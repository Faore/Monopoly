package im.admt.team11.PA3.GameOver;

import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Util.TokenMap;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameOverController {
    public Label gameOverLabel;
    public ImageView playerIcon;

    public void initialize() {
        gameOverLabel.setText("Player " + MonopolyGame.getInstance().winner.playerNumber + " Wins!");
        playerIcon.setImage(new Image(TokenMap.getTokenMap().get(MonopolyGame.getInstance().winner.token.tokenType)));
    }
}
