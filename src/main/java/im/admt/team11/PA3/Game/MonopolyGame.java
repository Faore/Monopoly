package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.UI.Debug.DebugUI;
import im.admt.team11.PA3.Game.UI.GameWindowManager;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;

public class MonopolyGame {

    private static MonopolyGame singleton;

    public static MonopolyGame getInstance() {
        return MonopolyGame.singleton;
    }

    public Player winner;

    public Stage primaryStage;
    private Stage debugStage;

    public GameWindowManager gameWindowManager;
    public DebugUI debugUI;

    public GameBoard gameBoard;
    public GameSettings gameSettings;
    public TurnManager turnManager;

    public Timer timer;

    public MonopolyGame(GameSettings gameSettings, Stage primaryStage) throws Exception {
        if (MonopolyGame.singleton == null) {
            MonopolyGame.singleton = this;
        } else {
            throw new ExceptionInInitializerError("Attempt to create more than one instance of the MonopolyGame singleton.");
        }
        timer = new Timer("gameTimer");
        this.gameSettings = gameSettings;
        this.primaryStage = primaryStage;
        this.gameBoard = new GameBoard(gameSettings);
    }

    public void start() throws Exception {
        Parent root;
        if (gameSettings.themeOption == 0) {
            root = FXMLLoader.load(getClass().getResource("/fxml/GameWindow.fxml"));
        }else{
            root = FXMLLoader.load(getClass().getResource("/fxml/ThemedGameWindow.fxml"));
        }
        primaryStage.setTitle("Monopoly (PA3 for Group 11)");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setFullScreen(true);

        primaryStage.setOnCloseRequest(event -> {
            timer.cancel();
            Platform.exit();
        });

        for (Player player : gameSettings.players) {
            gameWindowManager.attachTokenToBoard(player.token);
        }

        turnManager = new TurnManager();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(
                        () -> {
                            try {
                                stopGame();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }
        }, 1000 * 60 * gameSettings.timeLimit);

        primaryStage.show();

    }

    public void openDebugDialog() throws IOException {
        Parent debugDialog = FXMLLoader.load(getClass().getResource("/fxml/debug/DebugUI.fxml"));
        debugStage = new Stage();
        debugStage.initStyle(StageStyle.UTILITY);
        debugStage.setTitle("PA3 Debug Tools");
        debugStage.setScene(new Scene(debugDialog));
        debugStage.setAlwaysOnTop(true);
        debugStage.setResizable(false);
        debugStage.show();
    }

    public void stopGame() throws IOException {
        primaryStage.hide();

        this.winner = null;

        for (Player player : gameSettings.players) {
            if (winner == null || winner.getPlayerValue() < player.getPlayerValue()) {
                winner = player;
            }
        }

        Parent gameOverDialog = FXMLLoader.load(getClass().getResource("/fxml/GameOver.fxml"));
        primaryStage.setTitle("Game Over!");
        primaryStage.setFullScreen(false);
        primaryStage.setScene(new Scene(gameOverDialog));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
