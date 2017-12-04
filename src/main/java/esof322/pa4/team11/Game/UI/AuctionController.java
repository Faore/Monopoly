package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.Board.Tiles.Property;
import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Player;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class AuctionController {

    public Button p1p1;
    public Button p2p1;
    public Button p3p1;
    public Button p4p1;

    public Button p1p10;
    public Button p2p10;
    public Button p3p10;
    public Button p4p10;

    public Button p1p100;
    public Button p2p100;
    public Button p3p100;
    public Button p4p100;

    public Player currentBidder;
    public int currentBid;
    public Button endAuctionButton;
    public Label auctionLabel;
    public Label currentBidLabel;
    public AnchorPane p1;
    public AnchorPane p2;
    public AnchorPane p3;
    public AnchorPane p4;
    public HBox container;
    public Property property;

    public void initialize() {
        int players = MonopolyGame.getInstance().gameBoard.playerTokens.size();
        if(players < 3) {
            container.getChildren().remove(p3);
        }
        if(players < 4) {
            container.getChildren().remove(p4);
        }
    }

    public void setup(Property property) {
        this.property = property;
        currentBid = 0;
        currentBidder = null;
        updateBidder();
        auctionLabel.setText("Auction for " + property.name);
    }

    public void endAuction(ActionEvent actionEvent) throws Exception {
        MonopolyGame.getInstance().gameWindowController.endAuction(currentBidder, currentBid, property);
    }

    public void updateBidder() {
        if(currentBidder == null || currentBid == 0) {
            currentBidLabel.setText("Current Bid: $0 (Nobody)");
        } else {
            currentBidLabel.setText("Current Bid: $" + currentBid + " (Player " + currentBidder.playerNumber + ")");
        }
        int current = 0;
        for ( Player player : MonopolyGame.getInstance().gameSettings.players) {
            current++;
            switch (current) {
                case 1:
                    if(player.canBid(currentBid + 1)) {
                        p1p1.setDisable(false);
                    } else {
                        p1p1.setDisable(true);
                    }
                    if(player.canBid(currentBid + 10)) {
                        p1p10.setDisable(false);
                    } else {
                        p1p10.setDisable(true);
                    }
                    if(player.canBid(currentBid + 100)) {
                        p1p100.setDisable(false);
                    } else {
                        p1p100.setDisable(true);
                    }
                    break;
                case 2:
                    if(player.canBid(currentBid + 1)) {
                        p2p1.setDisable(false);
                    } else {
                        p2p1.setDisable(true);
                    }
                    if(player.canBid(currentBid + 10)) {
                        p2p10.setDisable(false);
                    } else {
                        p2p10.setDisable(true);
                    }
                    if(player.canBid(currentBid + 100)) {
                        p2p100.setDisable(false);
                    } else {
                        p2p100.setDisable(true);
                    }
                    break;
                case 3:
                    if(player.canBid(currentBid + 1)) {
                        p3p1.setDisable(false);
                    } else {
                        p3p1.setDisable(true);
                    }
                    if(player.canBid(currentBid + 10)) {
                        p3p10.setDisable(false);
                    } else {
                        p3p10.setDisable(true);
                    }
                    if(player.canBid(currentBid + 100)) {
                        p3p100.setDisable(false);
                    } else {
                        p3p100.setDisable(true);
                    }
                    break;
                case 4:
                    if(player.canBid(currentBid + 1)) {
                        p4p1.setDisable(false);
                    } else {
                        p4p1.setDisable(true);
                    }
                    if(player.canBid(currentBid + 10)) {
                        p4p10.setDisable(false);
                    } else {
                        p4p10.setDisable(true);
                    }
                    if(player.canBid(currentBid + 100)) {
                        p4p100.setDisable(false);
                    } else {
                        p4p100.setDisable(true);
                    }
                    break;
            }
        }
    }

    public void addOne(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Player player = null;
        if(button == p1p1) {
            player = MonopolyGame.getInstance().gameSettings.players.get(0);
        } else if(button == p2p1) {
            player = MonopolyGame.getInstance().gameSettings.players.get(1);
        } else if(button == p3p1) {
            player = MonopolyGame.getInstance().gameSettings.players.get(2);
        } else if(button == p4p1) {
            player = MonopolyGame.getInstance().gameSettings.players.get(3);
        }
        currentBidder = player;
        currentBid += 1;
        updateBidder();
    }

    public void addTen(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Player player = null;
        if(button == p1p10) {
            player = MonopolyGame.getInstance().gameSettings.players.get(0);
        } else if(button == p2p10) {
            player = MonopolyGame.getInstance().gameSettings.players.get(1);
        } else if(button == p3p10) {
            player = MonopolyGame.getInstance().gameSettings.players.get(2);
        } else if(button == p4p10) {
            player = MonopolyGame.getInstance().gameSettings.players.get(3);
        }
        currentBidder = player;
        currentBid += 10;
        updateBidder();
    }

    public void addHundred(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Player player = null;
        if(button == p1p100) {
            player = MonopolyGame.getInstance().gameSettings.players.get(0);
        } else if(button == p2p100) {
            player = MonopolyGame.getInstance().gameSettings.players.get(1);
        } else if(button == p3p100) {
            player = MonopolyGame.getInstance().gameSettings.players.get(2);
        } else if(button == p4p100) {
            player = MonopolyGame.getInstance().gameSettings.players.get(3);
        }
        currentBidder = player;
        currentBid += 100;
        updateBidder();
    }
}
