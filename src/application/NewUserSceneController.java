package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewUserSceneController {
	protected Stage newUserStage;

    @FXML
    private Button newUserCreateButton;

    @FXML
    private TextField newUserProfileNameInput;

    @FXML
    private Button newUserReturnButton;


    @FXML
    void newUserCreateButtonPressed(ActionEvent event) {
    	
    	
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
