package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.Board.Card.Deed;
import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MortgagePropertiesController {

    public Button mortgageButton;
    public ListView<Deed> propertyList;
    public Player player;
    private GameWindowController gameWindowController;

    public void initialize() {
        propertyList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                rerender(newValue.intValue());
            }
        });
    }

    public void setup(GameWindowController gameWindowController) {
        this.gameWindowController = gameWindowController;
    }

    public void setup(Player player) {
        this.player = player;
        propertyList.setItems(this.player.deeds);
        propertyList.getSelectionModel().clearSelection();
        rerender(0);
    }

    public void rerender(int newValue) {
        if (propertyList.getItems().size() == 0) {
            mortgageButton.setText("No Properties Owned");
            mortgageButton.setDisable(true);
            return;
        }

        if(newValue < 0) {
            mortgageButton.setText("Select a Property");
            mortgageButton.setDisable(true);
            return;
        }

        if(player.deeds.get(newValue).getCurrentBuildingLevel() < 1 && !player.deeds.get(newValue).isMortgaged) {
            mortgageButton.setText("Mortgage (+$" + player.deeds.get(newValue).mortgageValue + ")");
            mortgageButton.setDisable(false);
        }

        if(player.deeds.get(newValue).isMortgaged) {
            if(player.deeds.get(newValue).mortgageValue > player.getMoney()) {
                //Can't Afford.
                mortgageButton.setText("Unmortgage (-$" + player.deeds.get(newValue).mortgageValue + ")");
                mortgageButton.setDisable(true);
            } else {
                mortgageButton.setText("Unmortgage (-$" + player.deeds.get(newValue).mortgageValue + ")");
                mortgageButton.setDisable(false);
            }
        }
    }

    public void updateMortgage(ActionEvent actionEvent) throws Exception {
        Deed deed = player.deeds.get(propertyList.getSelectionModel().getSelectedIndex());
        if(deed.isMortgaged) {
            player.takeMoney(deed.mortgageValue);
            deed.setMortgaged(false);
        } else {
            player.giveMoney(deed.mortgageValue);
            deed.setMortgaged(true);
        }
        gameWindowController.updateMoney(player.getMoney());
        rerender(propertyList.getSelectionModel().getSelectedIndex());
    }

    public void done(ActionEvent actionEvent) {
        gameWindowController.closeMortgageWindow();
    }
}
