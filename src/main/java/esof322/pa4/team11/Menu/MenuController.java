package esof322.pa4.team11.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class MenuController {

    public ImageView menuBlue;
    public ImageView menuGreen;
    public ImageView menuRed;
    public ImageView menuYellow;
    public Slider playerSlider;
    public Button startGameButton;
    public Slider timeLimitSlider;
    public Label timeLimitLabel;
    public Slider themeSelectSlider;
    public Label themeLabel;

    @FXML
    public void initialize() {
        Menu.getInstance().controller = this;

        menuBlue.setVisible(true);
        menuGreen.setVisible(true);
        menuRed.setVisible(true);
        menuYellow.setVisible(false);

        playerSlider.valueProperty().addListener((obs, oldval, newVal) ->
                playerSliderUpdate(newVal));

        timeLimitSlider.valueProperty().addListener((obs, oldval, newval) ->
                timeLimitSliderUpdate(newval));

        themeSelectSlider.valueProperty().addListener((obs, oldval, newval) ->
                themeSelectSliderUpdate(newval));


    }

    public void timeLimitSliderUpdate(Number newVal) {
        timeLimitSlider.setValue(newVal.intValue());
        timeLimitLabel.setText("Time Limit (" + newVal.intValue() + " minutes):");
    }

    public void playerSliderUpdate(Number newVal) {
        playerSlider.setValue(newVal.intValue());
        if(newVal.intValue() == 4) {
            menuBlue.setVisible(true);
            menuGreen.setVisible(true);
            menuRed.setVisible(true);
            menuYellow.setVisible(true);
        }
        else if(newVal.intValue() == 3) {
            menuBlue.setVisible(true);
            menuGreen.setVisible(true);
            menuRed.setVisible(true);
            menuYellow.setVisible(false);
        }
        else if(newVal.intValue() == 2) {
            menuBlue.setVisible(true);
            menuGreen.setVisible(true);
            menuRed.setVisible(false);
            menuYellow.setVisible(false);
        }
    }

    public void themeSelectSliderUpdate(Number newVal){
        themeSelectSlider.setValue(newVal.intValue());
        if(newVal.intValue() == 0) {
            themeLabel.setText("Theme: Original Monopoly Theme");
        }
        else if(newVal.intValue() == 1){
            themeLabel.setText("Theme: Custom Overwatch Theme");
        }
    }

    public void clickStartGame(ActionEvent event) throws Exception {
        Menu.getInstance().startGame((int) Math.round(playerSlider.getValue()), (int) Math.round(timeLimitSlider.getValue()), (int) Math.round(themeSelectSlider.getValue()));
    }
}
