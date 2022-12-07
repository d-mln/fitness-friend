package application;

import java.io.File;
import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteConfirmSceneController {
	private Profile currentProfile;
    protected Stage confirmStage;

    // delete everything
	@FXML
    void confirmDelete(ActionEvent event) {
		// delete profile file
		File toDelete = new File("src/application/profiles/" + currentProfile.getName() + ".txt");
		toDelete.delete();
		
		// delete history files
		for (int count = 1; count <= 8; count++) {
			toDelete = new File("src/application/profiles/" + currentProfile.getName() + count + ".txt");
			toDelete.delete();
		}
		
		// return to welcome menu
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
			confirmStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	// return without doing anything
    @FXML
    void returnToSettings(ActionEvent event) {
    	Stage settingsStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/scenes/SettingsScene.fxml"));
    		SettingsSceneController controller = (SettingsSceneController)loader.getController();
    		controller.settingsStage = settingsStage;
    		controller.setCurrentProfile(currentProfile);
    		controller.setDropdowns();
    		Scene scene = new Scene(root,400,220);
    		
    		settingsStage.setTitle("Settings: " + currentProfile.getName());
    		settingsStage.setResizable(false);
    		settingsStage.setScene(scene);
    		settingsStage.show();
    		confirmStage.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}

}
