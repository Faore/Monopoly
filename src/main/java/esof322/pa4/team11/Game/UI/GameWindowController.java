package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.TurnPhase;
import esof322.pa4.team11.Game.Board.Card.Card;
import esof322.pa4.team11.Game.Board.Pieces.Token;
import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.Game.Board.Tile;
import esof322.pa4.team11.Game.Board.Tiles.Properties.StandardProperty;
import esof322.pa4.team11.Game.Board.Tiles.Property;
import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Player;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
import java.util.Timer;
import java.util.TimerTask;

public class GameWindowController {

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
    public ChanceController chanceController;
    public Stage chanceStage;
    public ChestController chestController;
    public Stage chestStage;

    public Button sellJailCardButton;

    MonopolyGame game;

    @FXML
    public void initialize() throws IOException {
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
    }

    public void setup(MonopolyGame game) throws IOException {
        this.game = game;

        FXMLLoader loader = new FXMLLoader();
        Parent deedWindow = loader.load(getClass().getResource("/fxml/AskBuy.fxml").openStream());
        this.askBuyController = loader.getController();
        this.askBuyController.setup(this);
        deedStage = new Stage();
        deedStage.initStyle(StageStyle.UNDECORATED);
        deedStage.setTitle("Deed");
        deedStage.setScene(new Scene(deedWindow));
        deedStage.setAlwaysOnTop(false);
        deedStage.setResizable(false);
        deedStage.initModality(Modality.WINDOW_MODAL);
        deedStage.initOwner(game.primaryStage);

        loader = new FXMLLoader();
        Parent upgradePropertiesWindow = loader.load(getClass().getResource("/fxml/UpgradeProperties.fxml").openStream());
        upgradePropertiesController = loader.getController();
        this.upgradePropertiesController.setup(this);
        upgradePropertiesStage = new Stage();
        upgradePropertiesStage.initStyle(StageStyle.UNDECORATED);
        upgradePropertiesStage.setTitle("Upgrade Properties");
        upgradePropertiesStage.setScene(new Scene(upgradePropertiesWindow));
        upgradePropertiesStage.setAlwaysOnTop(true);
        upgradePropertiesStage.setResizable(false);
        upgradePropertiesStage.initModality(Modality.WINDOW_MODAL);
        upgradePropertiesStage.initOwner(game.primaryStage);

        loader = new FXMLLoader();
        Parent jailWindow = loader.load(getClass().getResource("/fxml/Jail.fxml").openStream());
        jailController = loader.getController();
        this.jailController.setup(this);
        jailStage = new Stage();
        jailStage.initStyle(StageStyle.UNDECORATED);
        jailStage.setTitle("You Are In Jail");
        jailStage.setScene(new Scene(jailWindow));
        jailStage.setAlwaysOnTop(false);
        jailStage.setResizable(false);
        jailStage.initModality(Modality.WINDOW_MODAL);
        jailStage.initOwner(game.primaryStage);

        loader = new FXMLLoader();
        Parent mortgageWindow = loader.load(getClass().getResource("/fxml/MortgageProperties.fxml").openStream());
        mortgagePropertiesController = loader.getController();
        this.mortgagePropertiesController.setup(this);
        mortgageStage = new Stage();
        mortgageStage.initStyle(StageStyle.UNDECORATED);
        mortgageStage.setTitle("Manage Mortgages");
        mortgageStage.setScene(new Scene(mortgageWindow));
        mortgageStage.setAlwaysOnTop(true);
        mortgageStage.setResizable(false);
        mortgageStage.initModality(Modality.WINDOW_MODAL);
        mortgageStage.initOwner(game.primaryStage);

        loader = new FXMLLoader();
        Parent chanceWindow = loader.load(getClass().getResource("/fxml/ChanceWindow.fxml").openStream());
        this.chanceController = loader.getController();
        this.chanceController.setup(this);
        chanceStage = new Stage();
        chanceStage.initStyle(StageStyle.UNDECORATED);
        chanceStage.setTitle("Chance Card");
        chanceStage.setScene(new Scene(chanceWindow));
        chanceStage.setAlwaysOnTop(true);
        chanceStage.setResizable(false);
        chanceStage.initModality(Modality.WINDOW_MODAL);
        chanceStage.initOwner(game.primaryStage);

        loader = new FXMLLoader();
        Parent chestWindow = loader.load(getClass().getResource("/fxml/CommunityChest.fxml").openStream());
        chestController = loader.getController();
        this.chestController.setup(this);
        chestStage = new Stage();
        chestStage.initStyle(StageStyle.UNDECORATED);
        chestStage.setTitle("Community Chest Card");
        chestStage.setScene(new Scene(chestWindow));
        chestStage.setAlwaysOnTop(true);
        chestStage.setResizable(false);
        chestStage.initModality(Modality.WINDOW_MODAL);
        chestStage.initOwner(game.primaryStage);

        loader = new FXMLLoader();
        Parent auctionWindow = loader.load(getClass().getResource("/fxml/Auction.fxml").openStream());
        this.auctionController = loader.getController();
        this.auctionController.setup(this, game.players);
        auctionStage = new Stage();
        auctionStage.initStyle(StageStyle.UNDECORATED);
        auctionStage.setTitle("Auction");
        auctionStage.setScene(new Scene(auctionWindow));
        auctionStage.setAlwaysOnTop(true);
        auctionStage.setResizable(false);
        auctionStage.initModality(Modality.WINDOW_MODAL);
        auctionStage.initOwner(game.primaryStage);

        time = game.gameSettings.timeLimit * 60;

        game.timer.scheduleAtFixedRate(new TimerTask() {
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
        game.openDebugDialog();
    }

    public Tile tileAtEvent(MouseEvent event) {
        for (Tile t : game.gameBoard.tiles) {
            if (event.getX() >= t.firstBound.getX() && event.getX() <= t.secondBound.getX() && event.getY() <= t.firstBound.getY() && event.getY() >= t.secondBound.getY()) {
                return t;
            }
        }

        return null;
    }

    public void setTurnPhase(Player player, TurnPhase phase) {
        playerTurnLabel.setText("Player " + player.playerNumber + "'s Turn");
        if(player.chanceJailCard || player.chestJailCard) {
            sellJailCardButton.setDisable(false);
        } else {
            sellJailCardButton.setDisable(true);
        }
        if(phase == TurnPhase.Movement) {
            rollToMoveButton.setDisable(false);
            endTurnButton.setDisable(true);
            upgradePropertiesButton.setDisable(true);
        } else if(phase == TurnPhase.Management){
            if (player.chanceJailCard || player.chestJailCard){
                sellJailCardButton.setDisable(false);
            }else{
                sellJailCardButton.setDisable(true);
            }
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

        int slot = game.gameBoard.tiles.get(0).firstFreeTokenSlot();

        game.gameBoard.tiles.get(0).tokensInSlots[slot] = token;
        token.buttonElement.setLayoutX(game.gameBoard.tiles.get(0).tokenSlots[slot].getX());
        token.buttonElement.setLayoutY(game.gameBoard.tiles.get(0).tokenSlots[slot].getY());
        token.currentLocation = game.gameBoard.tiles.get(0);
    }

    public void rollToMove(ActionEvent actionEvent) throws Exception {
        game.turnManager.movePlayer();
    }

    public void startAskBuyMode(Property property, Player player) throws IOException {
        askBuyController.setProperty(property, player);
        deedStage.show();
    }

    public void endAskBuyMode(boolean buy) throws Exception {
        deedStage.hide();
        if(buy) {
            game.turnManager.buyProperty();
        } else {
            //Start an auction
            auctionController.setup((Property) game.turnManager.getCurrentPlayer().token.currentLocation);
            auctionStage.show();
        }
    }

    public void endAuction(Player winner, int amount, Property property) throws Exception {
        auctionStage.hide();
        game.turnManager.completeAuction(winner, amount, property);
    }

    public void startUpgrade(ActionEvent actionEvent) {
        upgradePropertiesController.setup(game.turnManager.getCurrentPlayer());
        upgradePropertiesStage.show();
    }

    public void endTurn(ActionEvent actionEvent) {
        game.turnManager.nextTurn();
    }

    public void sellJailCard(){
        if (game.turnManager.getCurrentPlayer().chanceJailCard){
            game.turnManager.getCurrentPlayer().chanceJailCard = false;
            game.turnManager.getCurrentPlayer().giveMoney(50);
            if(game.turnManager.getCurrentPlayer().chestJailCard) {
                sellJailCardButton.setDisable(false);
            } else {
                sellJailCardButton.setDisable(true);
            }
        } else if(game.turnManager.getCurrentPlayer().chestJailCard){
            game.turnManager.getCurrentPlayer().chestJailCard = false;
            game.turnManager.getCurrentPlayer().giveMoney(50);
            sellJailCardButton.setDisable(true);
        }
    }

    public void endUpgrade() {
        upgradePropertiesStage.hide();
    }

    public void rollToLeaveJail() throws Exception {
        jailStage.hide();
        game.turnManager.rollToLeaveJail();
    }

    public void payToLeaveJail() throws Exception {
        jailStage.hide();
        game.turnManager.payToLeaveJail();
    }

    public void cardToLeaveJail() throws Exception{
        jailStage.hide();
        game.turnManager.cardToLeaveJail();
    }

    public void closeMortgageWindow() {
        mortgageStage.hide();
    }

    public void manageMortgages(ActionEvent actionEvent) {
        mortgagePropertiesController.setup(game.turnManager.getCurrentPlayer());
        mortgageStage.show();
    }

    public void drawChanceCard(Card card)throws IOException{
        chanceController.setChanceCard(card);
        chanceStage.show();
    }

    public void drawChestCard(Card card)throws IOException{
        chestController.setChestCard(card);
        chestStage.show();
    }

    public void endChanceCard(){
        chanceStage.hide();
    }

    public void endChestCard(){
        chestStage.hide();
    }
}