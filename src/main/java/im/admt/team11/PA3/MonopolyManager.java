package im.admt.team11.PA3;

import im.admt.team11.PA3.Game.GameSettings;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MonopolyManager extends Application {

    public static void main(String[] args) {
        //Everything starts here.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        MonopolyGame game = new MonopolyGame(new GameSettings(), primaryStage);
        game.start();

    }
}