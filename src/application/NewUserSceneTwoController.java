package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewUserSceneTwoController {
	protected Stage newUserStage2;

    @FXML
    private Button newUserFinishButton;

    @FXML
    private ChoiceBox<?> newUserGenderChoiceBox;

    @FXML
    private TextField newUserHeightInput;

    @FXML
    private Label newUserHeightUnitLabel;

    @FXML
    private Button newUserReturnButton;

    @FXML
    private TextField newUserWeightInput;

    @FXML
    private Label newUserWeightUnitLabel;


    @FXML
    void newUserFinishButtonPressed(ActionEvent event) {

    }

    @FXML
    void newUserReturnButtonPressed(ActionEvent event) {

    }

}
