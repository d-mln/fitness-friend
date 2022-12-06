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

public class WeightSceneController {
	protected Stage weightStage;
	private Profile currentProfile;
	
    @FXML
    private Label unitLabel;

    @FXML
    private Label weightHistoryOne;

    @FXML
    private Label weightHistoryThree;

    @FXML
    private TextField weightInput;
    
    @FXML
    private Label weightHistoryTwo;

    @FXML
    private Button weightReturnWOSaving;

    @FXML
    private Button weightSaveAndReturn;

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
			weightStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void saveAndReturnPressed(ActionEvent event) {
		currentProfile.setWeight(Double.parseDouble(weightInput.getText()));
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
			weightStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}

	public void setUnit(String unit) {
		if (currentProfile.getUnit() == "Metric") {
			unitLabel.setText("kilograms");
		} else {
			unitLabel.setText("pounds");
		}
	}

}
