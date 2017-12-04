package esof322.pa4.team11.Game.UI;

import esof322.pa4.team11.Game.Board.Card.Deed;
import esof322.pa4.team11.Game.MonopolyGame;
import esof322.pa4.team11.Game.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class UpgradePropertiesController {
    public ListView propertyList;
    public Player player;
    public Button upgradeButton;
    public Button downgradeButton;
    public GameWindowController gameWindowController;

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
        propertyList.setItems(player.deeds);
        propertyList.getSelectionModel().clearSelection();
        rerender(0);
    }

    public void rerender(int newValue) {
        if (propertyList.getItems().size() == 0) {
            upgradeButton.setText("No Properties Owned");
            downgradeButton.setText("No Properties Owned");
            upgradeButton.setDisable(true);
            downgradeButton.setDisable(true);
            return;
        }

        if(newValue < 0) {
            upgradeButton.setText("Select a Property");
            upgradeButton.setDisable(true);
            return;
        }

        if (player.deeds.get(newValue).canHaveBuildings) {
            upgradeButton.setText("Upgrade for $" + player.deeds.get(newValue).buildingCost);
        } else {
            upgradeButton.setText("Not Upgradable");
            upgradeButton.setDisable(true);

            downgradeButton.setText("Not Downgradable");
            downgradeButton.setDisable(true);
            return;
        }

        if(player.deeds.get(newValue).isMortgaged) {
            upgradeButton.setText("Mortgaged");
            upgradeButton.setDisable(true);

            downgradeButton.setText("Mortgaged");
            downgradeButton.setDisable(true);
            return;
        }

        if(player.deeds.get(newValue).getCurrentBuildingLevel() == 0) {
            downgradeButton.setText("Already Min Level");
            downgradeButton.setDisable(true);
        } else {
            downgradeButton.setText("Downgrade (+$" + (player.deeds.get(newValue).buildingCost/2) + ")");
            downgradeButton.setDisable(false);
        }

        if (player.deeds.get(newValue).buildingCost > player.getMoney()) {
            upgradeButton.setText("Too Expensive ($" + player.deeds.get(newValue).buildingCost + ")");
            upgradeButton.setDisable(true);
            return;
        } else if (player.deeds.get(newValue).getCurrentBuildingLevel() >= 5) {
            upgradeButton.setText("Already Max");
            upgradeButton.setDisable(true);
            return;
        } else {
            upgradeButton.setDisable(false);
        }

        for (Deed deed : player.deeds.get(newValue).associatedDeeds) {
            if (deed.getOwner() != player) {
                upgradeButton.setText("Not All Properties Owned");
                upgradeButton.setDisable(true);
                return;
            }
        }
        int lowestLevel = Integer.MAX_VALUE;
        int highestLevel = Integer.MIN_VALUE;
        for (Deed deed : player.deeds.get(newValue).associatedDeeds) {
            if (deed.getCurrentBuildingLevel() < lowestLevel) {
                lowestLevel = deed.getCurrentBuildingLevel();
            }
            if(deed.getCurrentBuildingLevel() > highestLevel) {
                highestLevel = deed.getCurrentBuildingLevel();
            }
        }
        int currentLevel = player.deeds.get(newValue).getCurrentBuildingLevel();
        if (lowestLevel < currentLevel) {
            upgradeButton.setText("Upgrade Nearby Properties First");
            upgradeButton.setDisable(true);
        }
        if (currentLevel < highestLevel) {
            downgradeButton.setText("Downgrade Nearby Properties First");
            downgradeButton.setDisable(true);
        }
    }

    public void upgradeProperty(ActionEvent actionEvent) throws Exception {
        player.deeds.get(propertyList.getSelectionModel().getSelectedIndex()).addBuildingLevel();
        player.takeMoney(player.deeds.get(propertyList.getSelectionModel().getSelectedIndex()).buildingCost);
        gameWindowController.updateMoney(player.getMoney());
        rerender(propertyList.getSelectionModel().getSelectedIndex());
    }

    public void done(ActionEvent actionEvent) {
        gameWindowController.endUpgrade();
    }

    public void downgradeProperty(ActionEvent actionEvent) throws Exception {
        player.deeds.get(propertyList.getSelectionModel().getSelectedIndex()).removeBuildingLevel();
        player.giveMoney(player.deeds.get(propertyList.getSelectionModel().getSelectedIndex()).buildingCost/2);
        gameWindowController.updateMoney(player.getMoney());
        rerender(propertyList.getSelectionModel().getSelectedIndex());
    }
}
