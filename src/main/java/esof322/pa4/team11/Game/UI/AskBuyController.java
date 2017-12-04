package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Player;
import esof322.pa4.team11.Game.Board.Tiles.Property;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AskBuyController {
    public Label deedTitleLabel;
    public Label oneHouseLabel;
    public Label twoHouseLabel;
    public Label threeHouseLabel;
    public Label fourHouseLabel;
    public Label hotelLabel;
    public Label buildingCost;
    public Label rentLabel;
    public Button buyButton;

    private GameWindowController gameWindowController;

    public void setup(GameWindowController gameWindowController) {
        this.gameWindowController = gameWindowController;
    }

    public void setProperty(Property property, Player player) {
        deedTitleLabel.setText(property.name + " - $" + property.deed.printedPrice);
        if(property.deed.rent < 0) {
            rentLabel.setText("4x Dice Roll");
        }
        if(property.deed.canHaveBuildings) {
            oneHouseLabel.setText("$" + property.deed.buildingRents[0]);
            twoHouseLabel.setText("$" + property.deed.buildingRents[1]);
            threeHouseLabel.setText("$" + property.deed.buildingRents[2]);
            fourHouseLabel.setText("$" + property.deed.buildingRents[3]);
            hotelLabel.setText("S" + property.deed.buildingRents[4]);
            buildingCost.setText("$" + property.deed.buildingCost);
        } else {
            oneHouseLabel.setText("-");
            twoHouseLabel.setText("-");
            threeHouseLabel.setText("-");
            fourHouseLabel.setText("-");
            hotelLabel.setText("-");
            buildingCost.setText("-");
        }
        if(player.getMoney() >= property.deed.printedPrice) {
            buyButton.setDisable(false);
        } else {
            buyButton.setDisable(true);
        }
    }

    public void buyProperty(ActionEvent actionEvent) throws Exception {
        gameWindowController.endAskBuyMode(true);
    }

    public void auctionProperty(ActionEvent actionEvent) throws Exception {
        gameWindowController.endAskBuyMode(false);
    }
}
