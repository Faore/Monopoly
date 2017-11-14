package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.Board.Tiles.Property;
import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Game.Player;
import im.admt.team11.PA3.Game.TurnPhase;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    public Button rollToMoveButton;
    public Label moneyLabel;

    public Stage deedStage;
    public Stage auctionStage;
    public Stage upgradePropertiesStage;
    public Stage jailStage;
    public Stage mortgageStage;
    public AskBuyController askBuyController;
    public AuctionController auctionController;
    public UpgradePropertiesController upgradePropertiesController;
    public Label lastActionLabel;
    public Button upgradePropertiesButton;
    public Button endTurnButton;
    public JailController jailController;
    public MortgagePropertiesController mortgagePropertiesController;
    public Button manageMortgagesButton;

    @FXML
    public void initialize() throws IOException {
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

        Parent deedWindow = FXMLLoader.load(getClass().getResource("/fxml/AskBuy.fxml"));
        deedStage = new Stage();
        deedStage.initStyle(StageStyle.UNDECORATED);
        deedStage.setTitle("Deed");
        deedStage.setScene(new Scene(deedWindow));
        deedStage.setAlwaysOnTop(true);
        deedStage.setResizable(false);
        deedStage.initModality(Modality.WINDOW_MODAL);
        deedStage.initOwner(MonopolyGame.getInstance().primaryStage);

        Parent auctionWindow = FXMLLoader.load(getClass().getResource("/fxml/Auction.fxml"));
        auctionStage = new Stage();
        auctionStage.initStyle(StageStyle.UNDECORATED);
        auctionStage.setTitle("Auction");
        auctionStage.setScene(new Scene(auctionWindow));
        auctionStage.setAlwaysOnTop(true);
        auctionStage.setResizable(false);
        auctionStage.initModality(Modality.WINDOW_MODAL);
        auctionStage.initOwner(MonopolyGame.getInstance().primaryStage);

        Parent upgradePropertiesWindow = FXMLLoader.load(getClass().getResource("/fxml/UpgradeProperties.fxml"));
        upgradePropertiesStage = new Stage();
        upgradePropertiesStage.initStyle(StageStyle.UNDECORATED);
        upgradePropertiesStage.setTitle("Upgrade Properties");
        upgradePropertiesStage.setScene(new Scene(upgradePropertiesWindow));
        upgradePropertiesStage.setAlwaysOnTop(true);
        upgradePropertiesStage.setResizable(false);
        upgradePropertiesStage.initModality(Modality.WINDOW_MODAL);
        upgradePropertiesStage.initOwner(MonopolyGame.getInstance().primaryStage);

        Parent jailWindow = FXMLLoader.load(getClass().getResource("/fxml/Jail.fxml"));
        jailStage = new Stage();
        jailStage.initStyle(StageStyle.UNDECORATED);
        jailStage.setTitle("You Are In Jail");
        jailStage.setScene(new Scene(jailWindow));
        jailStage.setAlwaysOnTop(true);
        jailStage.setResizable(false);
        jailStage.initModality(Modality.WINDOW_MODAL);
        jailStage.initOwner(MonopolyGame.getInstance().primaryStage);

        Parent mortgageWindow = FXMLLoader.load(getClass().getResource("/fxml/MortgageProperties.fxml"));
        mortgageStage = new Stage();
        mortgageStage.initStyle(StageStyle.UNDECORATED);
        mortgageStage.setTitle("Manage Mortgages");
        mortgageStage.setScene(new Scene(mortgageWindow));
        mortgageStage.setAlwaysOnTop(true);
        mortgageStage.setResizable(false);
        mortgageStage.initModality(Modality.WINDOW_MODAL);
        mortgageStage.initOwner(MonopolyGame.getInstance().primaryStage);

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

    public void setLastActionLabel(String text) {
        lastActionLabel.setText(text);
    }

    public void updateMoney(int money) {
        moneyLabel.setText("$" + money);
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

    public void setTurnPhase(Player player, TurnPhase phase) {
        playerTurnLabel.setText("Player " + player.playerNumber + "'s Turn");
        if(phase == TurnPhase.Movement) {
            rollToMoveButton.setDisable(false);
            endTurnButton.setDisable(true);
            upgradePropertiesButton.setDisable(true);
        } else if(phase == TurnPhase.Management){
            rollToMoveButton.setDisable(true);
            endTurnButton.setDisable(false);
            upgradePropertiesButton.setDisable(false);
        } else if(phase == TurnPhase.InJail) {
            rollToMoveButton.setDisable(true);
            endTurnButton.setDisable(true);
            upgradePropertiesButton.setDisable(true);
            jailStage.show();
        }
        updateMoney(player.getMoney());
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
                token.buttonElement.setLayoutX(location.tokenSlots[i].getX());
                token.buttonElement.setLayoutY(location.tokenSlots[i].getY());
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

    public void rollToMove(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().turnManager.movePlayer();
    }

    public void startAskBuyMode(Property property, Player player) throws IOException {
        askBuyController.setProperty(property, player);
        deedStage.show();
    }

    public void endAskBuyMode(boolean buy) throws Exception {
        deedStage.hide();
        if(buy) {
            MonopolyGame.getInstance().turnManager.buyProperty();
        } else {
            //Start an auction
            auctionController.setup((Property) MonopolyGame.getInstance().turnManager.getCurrentPlayer().token.currentLocation);
            auctionStage.show();
        }
    }

    public void endAuction(Player winner, int amount, Property property) throws Exception {
        auctionStage.hide();
        MonopolyGame.getInstance().turnManager.completeAuction(winner, amount, property);
    }

    public void startUpgrade(ActionEvent actionEvent) {
        upgradePropertiesController.setup(MonopolyGame.getInstance().turnManager.getCurrentPlayer());
        upgradePropertiesStage.show();
    }

    public void endTurn(ActionEvent actionEvent) {
        MonopolyGame.getInstance().turnManager.nextTurn();
    }

    public void endUpgrade() {
        upgradePropertiesStage.hide();
    }

    public void rollToLeaveJail() throws Exception {
        jailStage.hide();
        MonopolyGame.getInstance().turnManager.rollToLeaveJail();
    }

    public void payToLeaveJail() throws Exception {
        jailStage.hide();
        MonopolyGame.getInstance().turnManager.payToLeaveJail();
    }

    public void closeMortgageWindow() {
        mortgageStage.hide();
    }

    public void manageMortgages(ActionEvent actionEvent) {
        mortgagePropertiesController.setup(MonopolyGame.getInstance().turnManager.getCurrentPlayer());
        mortgageStage.show();
    }
}
