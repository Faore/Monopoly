package im.admt.team11.PA3.Game;

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

    public MonopolyGame(GameSettings gameSettings, Stage primaryStage) {
        if(MonopolyGame.singleton == null) {
            MonopolyGame.singleton = this;
        } else {
            throw new ExceptionInInitializerError("Attempt to create more than one instance of the MonopolyGame singleton.");
        }
        this.primaryStage = primaryStage;
    }

    public void start() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameWindow.fxml"));
        primaryStage.setTitle("Monopoly (PA3 for Group 11)");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setFullScreen(true);
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
}
