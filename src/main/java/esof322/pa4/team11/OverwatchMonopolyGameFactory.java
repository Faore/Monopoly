package esof322.pa4.team11;

import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Util.BoardBuilder;
import esof322.pa4.team11.Game.Util.ThemedBoardBuilder;
import esof322.pa4.team11.Game.Util.ThemedCardBuilder;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class OverwatchMonopolyGameFactory extends AbstractGameFactory {
    @Override
    public MonopolyGame createMonopolyGame(GameSettings settings, Stage primaryStage) throws Exception {
        MonopolyGame game = new MonopolyGame(settings, primaryStage);
        return game;
    }

    @Override
    public Parent createGameWindow(MonopolyGame game) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent parent = fxmlLoader.load(getClass().getResource("/fxml/ThemedGameWindow.fxml").openStream());
        game.gameWindowController = fxmlLoader.getController();
        ThemedBoardBuilder.buildBoard(game.gameBoard.tiles, game.gameBoard.deeds, game.gameWindowController);
        ThemedCardBuilder.buildChanceCard(game.gameBoard.chanceCards);
        ThemedCardBuilder.buildChestCard(game.gameBoard.chestCards);
        FXCollections.shuffle(game.gameBoard.chanceCards);
		FXCollections.shuffle(game.gameBoard.chestCards);
        return parent;
    }
}
