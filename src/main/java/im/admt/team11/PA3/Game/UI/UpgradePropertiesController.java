package im.admt.team11.PA3.Game.UI;

import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Game.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class UpgradePropertiesController {
    public ListView propertyList;
    public Player player;
    public Button upgradeButton;

    public void initialize() {
        MonopolyGame.getInstance().gameWindowManager.upgradePropertiesController = this;
    }

    public void setup(Player player) {
        this.player = player;
        propertyList.setItems(player.deeds);
        if (propertyList.getItems().size() > 0) {
            propertyList.getSelectionModel().selectFirst();
            upgradeButton.setText("Upgrade for $" + player.deeds.get(0).buildingCost);
            if (player.deeds.get(0).buildingCost > player.getMoney()) {
                upgradeButton.setDisable(true);
            } else {
                upgradeButton.setDisable(false);
            }
        } else {
            upgradeButton.setText("No Property");
            upgradeButton.setDisable(true);
        }
        propertyList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (propertyList.getItems().size() > 0) {

                    if (player.deeds.get(newValue.intValue()).canHaveBuildings) {
                        upgradeButton.setText("Upgrade for $" + player.deeds.get(newValue.intValue()).buildingCost);
                    } else {
                        upgradeButton.setText("Not Upgradable");
                    }

                    if (player.deeds.get(newValue.intValue()).buildingCost > player.getMoney() || player.deeds.get(newValue.intValue()).getCurrentBuildingLevel() >= 5 || !player.deeds.get(newValue.intValue()).canHaveBuildings) {
                        upgradeButton.setDisable(true);
                    } else {
                        upgradeButton.setDisable(false);
                    }
                }
            }
        });
    }

    public void upgradeProperty(ActionEvent actionEvent) throws Exception {
        player.deeds.get(propertyList.getSelectionModel().getSelectedIndex()).addBuildingLevel();
    }

    public void done(ActionEvent actionEvent) {
        MonopolyGame.getInstance().gameWindowManager.endUpgrade();
    }
}
