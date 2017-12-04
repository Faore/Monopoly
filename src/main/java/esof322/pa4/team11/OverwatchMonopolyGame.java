package esof322.pa4.team11;

import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Util.BoardBuilder;
import esof322.pa4.team11.Game.Util.ThemedBoardBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class OverwatchMonopolyGame extends AbstractGameFactory {
    @Override
    public MonopolyGame createMonopolyGame(GameSettings settings, Stage primaryStage) throws Exception {
        MonopolyGame game = new MonopolyGame(settings, primaryStage);
        ThemedBoardBuilder.buildBoard(game.gameBoard.tiles, game.gameBoard.deeds);
        return game;
    }

    @Override
    public Parent createGameWindow(MonopolyGame game) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent parent = fxmlLoader.load(getClass().getResource("/fxml/ThemedGameWindow.fxml").openStream());
        game.gameWindowController = fxmlLoader.getController();
        return parent;
    }
}
