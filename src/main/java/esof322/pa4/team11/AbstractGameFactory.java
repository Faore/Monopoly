package esof322.pa4.team11;

import esof322.pa4.team11.Game.MonopolyGame;
import javafx.scene.Parent;
import javafx.stage.Stage;

public abstract class AbstractGameFactory {
    private static final StandardMonopolyGameFactory STANDARD_MONOPOLY_GAME = new StandardMonopolyGameFactory();
    private static final OverwatchMonopolyGameFactory OVERWATCH_MONOPOLY_GAME = new OverwatchMonopolyGameFactory();

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

    public abstract Parent createGameWindow(MonopolyGame game) throws Exception;

}
