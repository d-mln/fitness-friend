package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExerciseSceneController {
	protected Stage exerciseStage;
	private Profile currentProfile;

    @FXML
    private Label bikingUnitField;

    @FXML
    private TextField exerciseBikingField;

    @FXML
    private Button exerciseReturnWOSaving;
    
    @FXML
    private TextField exerciseSwimmingField;

    @FXML
    private TextField exerciseRunningField;

    @FXML
    private Button exerciseSaveAndReturn;

    @FXML
    private TextField exerciseWalkingField;

    @FXML
    private TextField exerciseWorkingOutField;

    @FXML
    private Label runningUnitField;

    @FXML
    private Label swimmingUnitField;

    @FXML
    private Label walkingUnitField;

    @FXML
    void returnWOSavingPressed(ActionEvent event) {
		Stage mainStage = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/MainScene.fxml"));
			MainSceneController controller = (MainSceneController)loader.getController();
			controller.mainStage = mainStage;
			controller.setCurrentProfile(currentProfile);
			controller.setLabels(currentProfile.getUnit());
			Scene scene = new Scene(root,600,180);
			
			mainStage.setTitle("Fitness Friend");
			mainStage.setResizable(false);
			mainStage.setScene(scene);
			mainStage.show();
			exerciseStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void saveAndReturnPressed(ActionEvent event) {
		currentProfile.setBiking(Double.parseDouble(exerciseBikingField.getText()));
		currentProfile.setRunning(Double.parseDouble(exerciseRunningField.getText()));
		currentProfile.setWalking(Double.parseDouble(exerciseWalkingField.getText()));
		currentProfile.setWorkout(Integer.parseInt(exerciseWorkingOutField.getText()));
		currentProfile.setSwimming(Integer.parseInt(exerciseSwimmingField.getText()));
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
			
			mainStage.setTitle("Fitness Friend");
			mainStage.setResizable(false);
			mainStage.setScene(scene);
			mainStage.show();
			exerciseStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}

	public void setUnit(String unit) {
		if (currentProfile.getUnit() == "Metric") {
			bikingUnitField.setText("kilometers");
			runningUnitField.setText("kilometers");
			walkingUnitField.setText("kilometers");
			swimmingUnitField.setText("laps");
		} else {
			bikingUnitField.setText("miles");
			runningUnitField.setText("miles");
			walkingUnitField.setText("miles");
			swimmingUnitField.setText("laps");
		}		
	}

}
