package esof322.pa4.team11;

import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.Game.GameBoard;
import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Player;
import esof322.pa4.team11.Game.Util.CardBuilder;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StandardMonopolyGameFactoryTest extends ApplicationTest {
    @Test
    public void testCreateMonopolyGame() throws Exception {
        GameSettings settings = new GameSettings();
        settings.players.add(new Player(1, TokenTypes.Blue));
        MonopolyGame game = AbstractGameFactory.getFactory(Theme.Standard).createMonopolyGame(settings, null);
        assertTrue(game instanceof MonopolyGame);
        assertEquals(settings, game.gameSettings);
        assertEquals(null, game.primaryStage);
        MonopolyGame.destroyInstance();
    }

    @Test
    public void testCreateGameWindow() throws Exception {
        GameSettings settings = new GameSettings();
        settings.players.add(new Player(1, TokenTypes.Blue));
        MonopolyGame game = AbstractGameFactory.getFactory(Theme.Standard).createMonopolyGame(settings, null);
        Parent parent = AbstractGameFactory.getFactory(Theme.Standard).createGameWindow(game);
        assertTrue(parent instanceof Parent);
        assertTrue(game.gameBoard.chanceCards.size() > 0);
        assertTrue(game.gameBoard.chestCards.size() > 0);
        assertTrue(game.gameBoard.tiles.size() > 0);
        assertTrue(game.gameBoard.deeds.size() > 0);
        MonopolyGame.destroyInstance();
    }
}