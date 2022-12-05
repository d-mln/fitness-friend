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
    private Button guestProfileButton;

    @FXML
    void createProfile(ActionEvent event) {
		Stage newUserStage = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/NewUserScene.fxml"));
			NewUserSceneController controller = (NewUserSceneController)loader.getController();
			controller.newUserStage = newUserStage;
			Scene scene = new Scene(root,500,300);
			
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
			Scene scene = new Scene(root,600,180);
			
			existingUserStage.setTitle("Fitness Friend");
			existingUserStage.setResizable(false);
			existingUserStage.setScene(scene);
			existingUserStage.show();
			welcomeStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void bypassLogin(ActionEvent event) {
		Stage mainStage = new Stage();
    	try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/scenes/MainScene.fxml"));
			MainSceneController controller = (MainSceneController)loader.getController();
			controller.mainStage = mainStage;
			Scene scene = new Scene(root,600,180);
			
			mainStage.setTitle("Fitness Friend");
			mainStage.setResizable(false);
			mainStage.setScene(scene);
			mainStage.show();
			welcomeStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
