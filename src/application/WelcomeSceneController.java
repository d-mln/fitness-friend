package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeSceneController {
	Stage welcomeStage;
	
	
    @FXML
    private Button newProfileButton;

    @FXML
    private Button oldProfileButton;

    @FXML
    void createProfile(ActionEvent event) {
		Stage newUserStage = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/NewUserScene.fxml"));
			NewUserSceneController controller = (NewUserSceneController)loader.getController();
			controller.newUserStage = newUserStage;
			Scene scene = new Scene(root,450,150);
			
			newUserStage.setTitle("Fitness Friend");
			newUserStage.setResizable(false);
			newUserStage.setScene(scene);
			newUserStage.show();
			welcomeStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void loadProfile(ActionEvent event) {
		Stage existingUserStage = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/ExistingUserScene.fxml"));
			ExistingUserSceneController controller = (ExistingUserSceneController)loader.getController();
			controller.existingUserStage = existingUserStage;
			controller.addExistingProfiles();
			Scene scene = new Scene(root,350,80);
			
			existingUserStage.setTitle("Fitness Friend");
			existingUserStage.setResizable(false);
			existingUserStage.setScene(scene);
			existingUserStage.show();
			welcomeStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
