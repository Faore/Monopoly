package esof322.pa4.team11.Menu;

import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.GameSettings;
import esof322.pa4.team11.Game.Player;
import esof322.pa4.team11.MonopolyManager;
import esof322.pa4.team11.Theme;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    private static Menu singleton;

    private Stage primaryStage;
    public MenuController controller;
    public final GameSettings gameSettings;

    public Menu(Stage primaryStage) {
        if(Menu.singleton == null) {
            Menu.singleton = this;
        } else {
            throw new ExceptionInInitializerError("Attempt to create more than one instance of the MonopolyGame singleton.");
        }
        this.primaryStage = primaryStage;
        this.gameSettings = new GameSettings();
    }

    public static Menu getInstance() {
        return singleton;
    }

    public void start() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        primaryStage.setTitle("Monopoly Setup (PA3 for Group 11)");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void startGame(int numberOfPlayers, int timeLimit, int themeOption) throws Exception {
        //Get rid of the menu UI and let garbage collection do its thing.
        primaryStage.hide();
        primaryStage.setScene(null);
        primaryStage.setResizable(true);
        this.controller = null;
        if(numberOfPlayers >= 2) {
            gameSettings.players.add(new Player(1, TokenTypes.Blue));
            gameSettings.players.add(new Player(2, TokenTypes.Green));
        }
        if(numberOfPlayers >= 3) {
            gameSettings.players.add(new Player(3, TokenTypes.Red));
        }
        if(numberOfPlayers >= 4) {
            gameSettings.players.add(new Player(4, TokenTypes.Yellow));
        }
        this.gameSettings.timeLimit = timeLimit;
        if(themeOption == 0){
            MonopolyManager.getInstance().transitionToGame(this.gameSettings, Theme.Standard);
        }
        if(themeOption == 1){
            MonopolyManager.getInstance().transitionToGame(this.gameSettings, Theme.Overwatch);
        }


    }
}