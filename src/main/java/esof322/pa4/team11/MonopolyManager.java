package esof322.pa4.team11;

import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Menu.Menu;
import javafx.application.Application;
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

    public void transitionToGame(GameSettings gameSettings, Theme theme) throws Exception {
        //Use the abstract factory to create the game.
        AbstractGameFactory gameFactory = AbstractGameFactory.getFactory(theme);
        MonopolyGame game = gameFactory.createMonopolyGame(gameSettings, primaryStage);
        game.root = gameFactory.createGameWindow(game);
        game.start();
    }
}