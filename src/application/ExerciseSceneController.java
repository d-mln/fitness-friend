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
			
			mainStage.setTitle("Fitness Friend: " + currentProfile.getName());
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
		currentProfile.setBiking(Integer.parseInt(exerciseBikingField.getText()));
		currentProfile.setRunning(Integer.parseInt(exerciseRunningField.getText()));
		currentProfile.setWalking(Integer.parseInt(exerciseWalkingField.getText()));
		currentProfile.setWorkout(Integer.parseInt(exerciseWorkingOutField.getText()));
		currentProfile.setSwimming(Integer.parseInt(exerciseSwimmingField.getText()));
    	currentProfile.setExercise(0);
		
    	
    	// determine a relative amount of exercise done
		// https://www.rusticaly.com/how-much-walking-to-lose-weight-chart/
		
		for (int walkingCounter = currentProfile.getWalking(); walkingCounter > 0 ; walkingCounter -= 200) {
			currentProfile.setExercise((currentProfile.getExercise() + 1));
			System.out.println(walkingCounter);
		}
		
		// https://www.webmd.com/fitness-exercise/running-to-lose-weight
		
		for (int runningCounter = currentProfile.getRunning(); runningCounter > 0; runningCounter -= 60) {
			currentProfile.setExercise(currentProfile.getExercise() + 1);
		}
		
		// https://www.healthline.com/health/how-many-calories-do-you-burn-biking#indoor-biking
		
		for (int bikingCounter = currentProfile.getBiking(); bikingCounter > 0; bikingCounter -= 100) {
			currentProfile.setExercise(currentProfile.getExercise() + 1);
		}
		
		// https://www.healthline.com/health/fitness-exercise/how-many-calories-do-you-burn-swimming
		
		for (int swimmingCounter = currentProfile.getSwimming(); swimmingCounter > 0; swimmingCounter -= 60) {
			currentProfile.setExercise(currentProfile.getExercise() + 1);
		}
		
		//  https://www.byrdie.com/how-many-calories-should-you-burn-in-a-workout-5093459
		
		for (int workoutCounter = currentProfile.getWorkout(); workoutCounter > 0; workoutCounter -= 100) {
			currentProfile.setExercise(currentProfile.getExercise() + 1);
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
			exerciseStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
		exerciseBikingField.setText(Integer.toString(currentProfile.getBiking()));
		exerciseRunningField.setText(Integer.toString(currentProfile.getRunning()));
		exerciseWalkingField.setText(Integer.toString(currentProfile.getWalking()));
		exerciseWorkingOutField.setText(Integer.toString(currentProfile.getWorkout()));
		exerciseSwimmingField.setText(Integer.toString(currentProfile.getSwimming()));
	}

}
