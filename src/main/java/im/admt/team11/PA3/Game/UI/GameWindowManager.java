package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.GameSettings;
import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Game.Player;
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

    public void setTokenLocation(Token token, Tile location) throws Exception {
        for(int i = 0; i < token.currentLocation.tokensInSlots.length; i++) {
            if (token.currentLocation.tokensInSlots[i] == token) {
                token.currentLocation.tokensInSlots[i] = null;
                break;
            }
        }
        for(int i = 0; i < location.tokensInSlots.length; i++) {
            if(location.tokensInSlots[i] == null) {
                location.tokensInSlots[i] = token;
                token.currentLocation = location;
                return;
            }
        }
        throw new Exception("Couldn't find a slot to put a token in.");
    }

    public void setBuildingLevelAtProperty(TokenTypes tokenType, StandardProperty property, int level) throws Exception {
        if(level > 5 || level < 0) {
            throw new Exception("Bad Building Level");
        }
        for(int i = 0; i < property.buildingsInSlots.length; i++) {
            if(property.buildingsInSlots[i] != null) {
                boardPane.getChildren().remove(property.buildingsInSlots[i]);
            }
        }
        property.buildingsInSlots = new Button[4];
        Button button;
        if(level == 5) {
            button = StandardProperty.generateHotel(tokenType);
            boardPane.getChildren().add(button);
            button.setLayoutX(property.buildingSlots[0].getX());
            button.setLayoutY(property.buildingSlots[0].getY());
            property.buildingsInSlots[0] = button;
            return;
        }
        for(int i = 0; i < level; i++) {
            button = StandardProperty.generateHouse(tokenType);
            boardPane.getChildren().add(button);
            button.setLayoutX(property.buildingSlots[i].getX());
            button.setLayoutY(property.buildingSlots[i].getY());
            property.buildingsInSlots[i] = button;
        }
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
