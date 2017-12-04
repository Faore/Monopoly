package esof322.pa4.team11.Game;

import esof322.pa4.team11.Game.UI.Debug.DebugController;
import esof322.pa4.team11.Game.UI.GameWindowController;
import esof322.pa4.team11.GameOver.GameOverController;
import esof322.pa4.team11.GameSettings;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public ObservableList<Player> players;

    public Stage primaryStage;
    private Stage debugStage;
    public Parent root;

    public GameWindowController gameWindowController;
    public DebugController debugController;

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
        this.players = FXCollections.observableArrayList(gameSettings.players);
        this.primaryStage = primaryStage;
        this.gameBoard = new GameBoard(gameSettings);
    }

    public void start() throws Exception {
        gameWindowController.setup(this);
        primaryStage.setTitle("Monopoly (PA3 for Group 11)");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setFullScreen(true);

        primaryStage.setOnCloseRequest(event -> {
            timer.cancel();
            Platform.exit();
        });

        for (Player player : gameSettings.players) {
            gameWindowController.attachTokenToBoard(player.token);
        }

        turnManager = new TurnManager(gameWindowController, gameBoard, players);

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
        FXMLLoader loader = new FXMLLoader();
        Parent debugDialog = loader.load(getClass().getResource("/fxml/debug/DebugUI.fxml").openStream());
        DebugController debugController = loader.getController();
        debugController.setup(gameWindowController, gameBoard.playerTokens);
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

        FXMLLoader loader = new FXMLLoader();
        Parent gameOverDialog = loader.load(getClass().getResource("/fxml/GameOver.fxml").openStream());
        GameOverController controller = loader.getController();
        controller.setup(winner);
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);
        primaryStage.setTitle("Game Over!");
        primaryStage.setFullScreen(false);
        primaryStage.setScene(new Scene(gameOverDialog));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
