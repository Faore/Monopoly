package esof322.pa4.team11;

import esof322.pa4.team11.Game.MonopolyGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class AbstractGameFactory {
    private static final StandardMonopolyGame STANDARD_MONOPOLY_GAME = new StandardMonopolyGame();
    private static final OverwatchMonopolyGame OVERWATCH_MONOPOLY_GAME = new OverwatchMonopolyGame();

    public static AbstractGameFactory getFactory(Theme theme) {
        AbstractGameFactory factory = null;

        switch (theme) {
            case Standard:
                factory = STANDARD_MONOPOLY_GAME;
                break;
            case Overwatch:
                factory = OVERWATCH_MONOPOLY_GAME;
                break;
        }
        return factory;
    }

    public abstract MonopolyGame createMonopolyGame(GameSettings settings, Stage primaryStage) throws Exception;

    public abstract Parent createGameWindow(MonopolyGame game) throws IOException;
}
