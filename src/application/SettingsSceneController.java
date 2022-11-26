package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class SettingsSceneController {

    @FXML
    private TextField settingsAgeInput;

    @FXML
    private ChoiceBox<?> settingsGenderInput;

    @FXML
    private TextField settingsHeightInput;

    @FXML
    private Button settingsReturnWOSaving;

    @FXML
    private Button settingsSaveButton;

    @FXML
    private ChoiceBox<?> settingsUnitInput;

    @FXML
    void returnWOSavingPressed(ActionEvent event) {

    }

    @FXML
    void savePressed(ActionEvent event) {

    }

}
