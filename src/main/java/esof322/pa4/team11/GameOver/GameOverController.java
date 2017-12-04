package esof322.pa4.team11.GameOver;

import esof322.pa4.team11.Game.Player;
import esof322.pa4.team11.Game.Util.TokenMap;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameOverController {
    public Label gameOverLabel;
    public ImageView playerIcon;

    public void setup(Player winner) {
        gameOverLabel.setText("Player " + winner.playerNumber + " Wins!");
        playerIcon.setImage(new Image(TokenMap.getTokenMap().get(winner.token.tokenType)));
    }
}
