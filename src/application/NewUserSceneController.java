package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewUserSceneController {
	
	protected Stage newUserStage;
	private Profile currentProfile;
	
    @FXML
    private ChoiceBox<String> measurementSystemChoiceBox;

    @FXML
    private Button newUserCreateButton;

    @FXML
    private TextField newUserProfileNameInput;

    @FXML
    private Button newUserReturnButton;

    @FXML
    void newUserCreateButtonPressed(ActionEvent event) {
    	// create profiles directory if it doesn't already exist    	
    	new File("src/application/profiles").mkdirs();
    	
    	currentProfile = new Profile(newUserProfileNameInput.getText());
    	currentProfile.setName(newUserProfileNameInput.getText());
    	currentProfile.setUnit(measurementSystemChoiceBox.getValue());
    	
    	try {
			currentProfile.saveProfile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
    	Stage newUserStage2 = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/NewUserSceneTwo.fxml"));
			NewUserSceneTwoController controller = (NewUserSceneTwoController)loader.getController();
			controller.newUserStage2 = newUserStage2;
			controller.setCurrentProfile(currentProfile);
			controller.setLabels(currentProfile.getUnit());
			Scene scene = new Scene(root,600,180);
			
			newUserStage2.setTitle("Fitness Friend: " + currentProfile.getName());
			newUserStage2.setResizable(false);
			newUserStage2.setScene(scene);
			newUserStage2.show();
			newUserStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void newUserReturnButtonPressed(ActionEvent event) {
    	Stage welcomeStage = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/WelcomeScene.fxml"));
			WelcomeSceneController controller = (WelcomeSceneController)loader.getController();
			controller.welcomeStage = welcomeStage;
			Scene scene = new Scene(root,400,200);
			
			welcomeStage.setTitle("Fitness Friend");
			welcomeStage.setResizable(false);
			welcomeStage.setScene(scene);
			welcomeStage.show();
			newUserStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
