package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import im.admt.team11.PA3.Game.UI.Debug.DebugUI;
import im.admt.team11.PA3.Game.UI.GameWindowManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MonopolyGame {

    private static MonopolyGame singleton;

    public static MonopolyGame getInstance() {
        return MonopolyGame.singleton;
    }

    private Stage primaryStage;
    private Stage debugStage;

    public GameWindowManager gameWindowManager;
    public DebugUI debugUI;

    public GameBoard gameBoard;
    public GameSettings gameSettings;
    public TurnManager turnManager;

    public MonopolyGame(GameSettings gameSettings, Stage primaryStage) {
        if(MonopolyGame.singleton == null) {
            MonopolyGame.singleton = this;
        } else {
            throw new ExceptionInInitializerError("Attempt to create more than one instance of the MonopolyGame singleton.");
        }
        this.gameSettings = gameSettings;
        this.primaryStage = primaryStage;
        this.gameBoard = new GameBoard();

    }

    public void start() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameWindow.fxml"));
        primaryStage.setTitle("Monopoly (PA3 for Group 11)");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setFullScreen(true);

        for (Player player: gameSettings.players) {
            gameWindowManager.attachTokenToBoard(player.token);
        }

        primaryStage.show();
    }

    public void openDebugDialog() throws IOException {
        Parent debugDialog = FXMLLoader.load(getClass().getResource("/fxml/debug/DebugUI.fxml"));
        debugStage = new Stage();
        debugStage.setTitle("PA3 Debug Tools");
        debugStage.setScene(new Scene(debugDialog));
        debugStage.setAlwaysOnTop(true);
        debugStage.setResizable(false);
        debugStage.show();
    }

    public void startGame(){
        //int time = need to ask for time from ui
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < 50){//change 50 to proper time
            turnManager.turns();
        }

    }
}
