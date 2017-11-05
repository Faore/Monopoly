package im.admt.team11.PA3;

import im.admt.team11.PA3.Game.GameSettings;
import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Menu.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MonopolyManager extends Application {

    public Stage primaryStage;
    private static MonopolyManager singleton;



    public static void main(String[] args) {
        //Everything starts here.
        launch(args);
    }

    public MonopolyManager() throws Exception {
        super();
        if(singleton == null) {
            singleton = this;
        } else {
            throw new Exception("Tried to make an extra instance of a singleton.");
        }
    }

    public static MonopolyManager getInstance() {
        return singleton;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        Menu menu = new Menu(primaryStage);
        menu.start();

    }

    public void transitionToGame(GameSettings gameSettings) throws Exception {
        MonopolyGame game = new MonopolyGame(gameSettings, primaryStage);
        game.start();
    }
}