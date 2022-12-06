package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainSceneController {
	
	protected Stage mainStage;
	private Profile currentProfile;
	
    @FXML
    private Label ageTextField;

    @FXML
    private Button exerciseSceneButton;

    @FXML
    private Button historySceneButton;

    @FXML
    private Button predictSceneButton;

    @FXML
    private Label weightLabel;
    
    @FXML
    private Button settingsButton;

    @FXML
    private Label timeSinceLoginField;

    @FXML
    private Label unitLabel;

    @FXML
    private Button weightSceneButton;

    @FXML
    void exerciseButtonPressed(ActionEvent event) {
    	Stage exerciseStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/scenes/ExerciseScene.fxml"));
    		ExerciseSceneController controller = (ExerciseSceneController)loader.getController();
    		controller.exerciseStage = exerciseStage;
    		controller.setCurrentProfile(currentProfile);
    		controller.setUnit(currentProfile.getUnit());
    		Scene scene = new Scene(root,400,400);
    		
    		exerciseStage.setTitle("Fitness Friend: Exercises: " + currentProfile.getName());
    		exerciseStage.setScene(scene);
    		exerciseStage.setResizable(false);
    		exerciseStage.show();
    		mainStage.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void historyButtonPressed(ActionEvent event) {
    	Stage historyStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryScene.fxml"));
    		HistorySceneController controller = (HistorySceneController)loader.getController();
    		controller.historyStage = historyStage;
    		controller.setCurrentProfile(currentProfile);
    		Scene scene = new Scene(root,400,400);
    		
    		historyStage.setTitle("Fitness Friend: History: " + currentProfile.getName());
    		historyStage.setResizable(false);
    		historyStage.setScene(scene);
    		historyStage.show();
    		mainStage.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void predictButtonPressed(ActionEvent event) {
    	Stage predictStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/scenes/PredictScene.fxml"));
    		PredictSceneController controller = (PredictSceneController)loader.getController();
    		controller.predictStage = predictStage;
    		controller.setCurrentProfile(currentProfile);
    		Scene scene = new Scene(root,400,400);
    		
    		predictStage.setTitle("Fitness Friend: Prediction: " + currentProfile.getName());
    		predictStage.setResizable(false);
    		predictStage.setScene(scene);
    		predictStage.show();
    		mainStage.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void settingsPressed(ActionEvent event) {
    	Stage settingsStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/scenes/SettingsScene.fxml"));
    		SettingsSceneController controller = (SettingsSceneController)loader.getController();
    		controller.settingsStage = settingsStage;
    		controller.setCurrentProfile(currentProfile);
    		controller.setDropdowns();
    		Scene scene = new Scene(root,400,400);
    		
    		settingsStage.setTitle("Fitness Friend: Settings: " + currentProfile.getName());
    		settingsStage.setResizable(false);
    		settingsStage.setScene(scene);
    		settingsStage.show();
    		mainStage.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void weightButtonPressed(ActionEvent event) {
    	Stage weightStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/scenes/WeightScene.fxml"));
    		WeightSceneController controller = (WeightSceneController)loader.getController();
    		controller.weightStage = weightStage;
    		controller.setCurrentProfile(currentProfile);
    		controller.setUnit(currentProfile.getUnit());
    		Scene scene = new Scene(root,400,400);
    		
    		weightStage.setTitle("Fitness Friend: My Weight: " + currentProfile.getName());
    		weightStage.setResizable(false);
    		weightStage.setScene(scene);
    		weightStage.show();
    		mainStage.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}

	public void setLabels(String i) {
		ageTextField.setText(Integer.toString(currentProfile.getAge()));
		weightLabel.setText(String.format("%.2f", currentProfile.getWeight()));
		if (currentProfile.getUnit() == "Metric") {
			unitLabel.setText("kilograms");
		} else {
			unitLabel.setText("pounds");
		}
	}
}
