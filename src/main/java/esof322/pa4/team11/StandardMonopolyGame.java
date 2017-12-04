package esof322.pa4.team11;

import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Util.BoardBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class StandardMonopolyGame extends AbstractGameFactory {
    @Override
    public MonopolyGame createMonopolyGame(GameSettings settings, Stage primaryStage) throws Exception {
        MonopolyGame game = new MonopolyGame(settings, primaryStage);
        BoardBuilder.buildBoard(game.gameBoard.tiles, game.gameBoard.deeds);

        return game;
    }

    @Override
    public Parent createGameWindow() throws IOException {
        return FXMLLoader.load(getClass().getResource("/fxml/GameWindow.fxml"));
    }
}
