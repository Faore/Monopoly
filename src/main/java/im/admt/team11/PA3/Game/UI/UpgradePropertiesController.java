package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Game.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class UpgradePropertiesController {
    public ListView<Deed> propertyList;
    public Player player;
    public Button upgradeButton;

    public void initialize() {
        MonopolyGame.getInstance().gameWindowManager.upgradePropertiesController = this;
        propertyList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                rerender(newValue.intValue());
            }
        });
    }

    public void setup(Player player) {
        this.player = player;
        propertyList.setItems(player.deeds);
        rerender(0);
    }

    public void rerender(int newValue) {
        if (propertyList.getItems().size() == 0) {
            upgradeButton.setText("No Properties Owned");
            upgradeButton.setDisable(true);
            return;
        }

        if (player.deeds.get(newValue).canHaveBuildings) {
            upgradeButton.setText("Upgrade for $" + player.deeds.get(newValue).buildingCost);
        } else {
            upgradeButton.setText("Not Upgradable");
            upgradeButton.setDisable(true);
            return;
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
        for (Deed deed : player.deeds.get(newValue).associatedDeeds) {
            if (deed.getCurrentBuildingLevel() < lowestLevel) {
                lowestLevel = deed.getCurrentBuildingLevel();
            }
        }
        int currentLevel = player.deeds.get(newValue).getCurrentBuildingLevel();
        if (lowestLevel < currentLevel) {
            upgradeButton.setText("Upgrade Nearby Properties First");
            upgradeButton.setDisable(true);
            return;
        }
    }

    public void upgradeProperty(ActionEvent actionEvent) throws Exception {
        player.deeds.get(propertyList.getSelectionModel().getSelectedIndex()).addBuildingLevel();
        rerender(propertyList.getSelectionModel().getSelectedIndex());
    }

    public void done(ActionEvent actionEvent) {
        MonopolyGame.getInstance().gameWindowManager.endUpgrade();
    }
}
