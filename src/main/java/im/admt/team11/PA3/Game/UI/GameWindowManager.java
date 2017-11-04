package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

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

    @FXML
    public void initialize() {
        MonopolyGame.getInstance().gameWindowManager = this;
        zoomSlider.setMin(Math.min(scrollPane.getHeight()/3000.0, scrollPane.getWidth()/3000.0));
        zoomSlider.setMax(1.0);
        zoomSlider.setValue(1.0);

        zoomSlider.valueProperty().addListener((o, oldValue, newValue) -> adjustZoom((double) newValue));
        scrollPane.heightProperty().addListener((o, oldValue, newValue) -> recalculateMinZoom());
        scrollPane.widthProperty().addListener((o, oldValue, newValue) -> recalculateMinZoom());

        Group contentGroup = new Group();
        zoomGroup = new Group();
        contentGroup.getChildren().add(zoomGroup);
        zoomGroup.getChildren().add(scrollPane.getContent());
        scrollPane.setContent(contentGroup);
    }

    public void recalculateMinZoom() {
        zoomSlider.setMin(Math.max(scrollPane.getHeight()/3000.0, scrollPane.getWidth()/3000.0));
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
            if(event.getX() >= t.firstBound.getX() && event.getX() <= t.secondBound.getX() && event.getY() <= t.firstBound.getY() && event.getY() >= t.secondBound.getY()) {
                return t;
            }
        }

        return null;
    }
}
