package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.GameSettings;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.geometry.Point2D;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TimerTask;

public class GameWindowManager {

    public Label playerTurnLabel;
    public Button zoomOutButton;
    public Slider zoomSlider;
    public Button zoomInButton;
    public AnchorPane boardPane;
    public ImageView imageView;
    public ScrollPane scrollPane;

    public Group zoomGroup;
    public MenuButton debugMenu;
    public MenuItem debugMenuCoordinates;

    public int time = 0;
    public Label timerLabel;

    @FXML
    public void initialize() {
        MonopolyGame.getInstance().gameWindowManager = this;
        zoomSlider.setMin(Math.min(scrollPane.getHeight() / 3000.0, scrollPane.getWidth() / 3000.0));
        zoomSlider.setMax(1.0);
        zoomSlider.setValue(0);

        zoomSlider.valueProperty().addListener((o, oldValue, newValue) -> adjustZoom((double) newValue));
        scrollPane.heightProperty().addListener((o, oldValue, newValue) -> recalculateMinZoom());
        scrollPane.widthProperty().addListener((o, oldValue, newValue) -> recalculateMinZoom());

        Group contentGroup = new Group();
        zoomGroup = new Group();
        contentGroup.getChildren().add(zoomGroup);
        zoomGroup.getChildren().add(scrollPane.getContent());
        scrollPane.setContent(contentGroup);

        time = MonopolyGame.getInstance().gameSettings.timeLimit * 60;

        MonopolyGame.getInstance().timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(
                        () -> {
                            updateTimer();
                        }
                );

            }
        }, 1000, 1000);
    }

    public void updateTimer() {
        time--;
        int minutes = ((int) Math.floor(time / 60));
        int seconds = (time - ((int) Math.floor(time / 60)) * 60);
        timerLabel.setText( minutes + ":" + (seconds < 10 ? "0": "") + seconds);
    }

    public void recalculateMinZoom() {
        zoomSlider.setMin(Math.max(scrollPane.getHeight() / 3000.0, scrollPane.getWidth() / 3000.0));
    }

    public void adjustZoom(double zoom) {
        double scrollH = scrollPane.getHvalue();
        double scrollV = scrollPane.getVvalue();

        zoomGroup.setScaleX(zoom);
        zoomGroup.setScaleY(zoom);

        scrollPane.setHvalue(scrollH);
        scrollPane.setVvalue(scrollV);
    }

    public void zoomOut(ActionEvent actionEvent) {
        zoomSlider.setValue(zoomSlider.getValue() - .05);
    }

    public void zoomIn(ActionEvent actionEvent) {
        zoomSlider.setValue(zoomSlider.getValue() + .05);
    }

    public void debugMenuTools(ActionEvent actionEvent) throws IOException {
        MonopolyGame.getInstance().openDebugDialog();
    }

    public Tile tileAtEvent(MouseEvent event) {
        for (Tile t : MonopolyGame.getInstance().gameBoard.tiles) {
            if (event.getX() >= t.firstBound.getX() && event.getX() <= t.secondBound.getX() && event.getY() <= t.firstBound.getY() && event.getY() >= t.secondBound.getY()) {
                return t;
            }
        }

        return null;
    }

    public void setTokenLocation(Token token, Point2D location) {
        token.buttonElement.setLayoutX(location.getX());
        token.buttonElement.setLayoutY(location.getY());
    }

    public void attachTokenToBoard(Token token) {
        boardPane.getChildren().add(token.buttonElement);

        int slot = MonopolyGame.getInstance().gameBoard.tiles.get(0).firstFreeTokenSlot();

        MonopolyGame.getInstance().gameBoard.tiles.get(0).tokensInSlots[slot] = token;
        token.buttonElement.setLayoutX(MonopolyGame.getInstance().gameBoard.tiles.get(0).tokenSlots[slot].getX());
        token.buttonElement.setLayoutY(MonopolyGame.getInstance().gameBoard.tiles.get(0).tokenSlots[slot].getY());
        token.currentLocation = MonopolyGame.getInstance().gameBoard.tiles.get(0);
    }
}
