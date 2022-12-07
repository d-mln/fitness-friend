package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewUserSceneTwoController {
	protected Stage newUserStage2;
	private Profile currentProfile;
	
    @FXML
    private TextField newUserAgeInput;
	
    @FXML
    private Button newUserFinishButton;

    @FXML
    private ChoiceBox<String> newUserGenderChoiceBox;

    @FXML
    private TextField newUserHeightInput;

    @FXML
    private Label newUserHeightUnitLabel;

    @FXML
    private TextField newUserWeightInput;

    @FXML
    private Label newUserWeightUnitLabel;


    @FXML
    void newUserFinishButtonPressed(ActionEvent event) {
		// write user inputs to save file and switch to main scene
    	try {
			currentProfile.setAge(Integer.parseInt(newUserAgeInput.getText()));
			currentProfile.setHeight(Double.parseDouble(newUserHeightInput.getText()));
			currentProfile.setGender(newUserGenderChoiceBox.getValue().toString());
			currentProfile.setWeight(Double.parseDouble(newUserWeightInput.getText()));
		} catch (Exception e2) {
			newUserFinishButton.setText("Input positive, real numbers");
			return;
		}
    	
    	try {
			currentProfile.saveProfile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
    	Stage mainStage = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/MainScene.fxml"));
			MainSceneController controller = (MainSceneController)loader.getController();
			controller.mainStage = mainStage;
			controller.setCurrentProfile(currentProfile);
			controller.setLabels(currentProfile.getUnit());
			Scene scene = new Scene(root,600,180);
			
			mainStage.setTitle("Fitness Friend: " + currentProfile.getName());
			mainStage.setResizable(false);
			mainStage.setScene(scene);
			mainStage.show();
			newUserStage2.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
		
	}

	public void setLabels(String unit) {
		if (currentProfile.getUnit().equals("Metric")) {
			newUserHeightUnitLabel.setText("cm");
			newUserWeightUnitLabel.setText("kg");
		} else {
			newUserHeightUnitLabel.setText("inches");
			newUserWeightUnitLabel.setText("lb");
		}
	}

}
