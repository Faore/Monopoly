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
        return game;
    }

    @Override
    public Parent createGameWindow(MonopolyGame game) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent parent = fxmlLoader.load(getClass().getResource("/fxml/GameWindow.fxml").openStream());
        game.gameWindowController = fxmlLoader.getController();
        BoardBuilder.buildBoard(game.gameBoard.tiles, game.gameBoard.deeds, game.gameWindowController);
        return parent;
    }
}
