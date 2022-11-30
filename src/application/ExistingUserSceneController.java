package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExistingUserSceneController {
	protected Stage existingUserStage;
	
    @FXML
    private ChoiceBox<?> accountChoiceBox;

    @FXML
    private Button existingUserContinueButton;

    @FXML
    private Button existingUserReturnButton;

    @FXML
    void existingUserContinuePressed(ActionEvent event) {
		
    	
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
			existingUserStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void existingUserReturnPressed(ActionEvent event) {
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
			existingUserStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
