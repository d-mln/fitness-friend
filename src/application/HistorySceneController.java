package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistorySceneController {
	protected Stage historyStage;
	private Profile currentProfile;
    @FXML
    private Button delHistory1;

    @FXML
    private Button delHistory2;

    @FXML
    private Button delHistory3;

    @FXML
    private Button delHistory4;

    @FXML
    private Button delHistory5;

    @FXML
    private Button delHistory6;

    @FXML
    private Button delHistory7;

    @FXML
    private Button delHistory8;

    @FXML
    private Label entryDate1;

    @FXML
    private Label entryDate2;

    @FXML
    private Label entryDate3;

    @FXML
    private Label entryDate4;

    @FXML
    private Label entryDate5;

    @FXML
    private Label entryDate6;

    @FXML
    private Label entryDate7;

    @FXML
    private Label entryDate8;

    @FXML
    private Label entryWeight1;

    @FXML
    private Label entryWeight2;

    @FXML
    private Label entryWeight3;

    @FXML
    private Label entryWeight4;

    @FXML
    private Label entryWeight5;

    @FXML
    private Label entryWeight6;

    @FXML
    private Label entryWeight7;

    @FXML
    private Label entryWeight8;

    @FXML
    private Button historyReturnButton;
	
    @FXML
    void deleteHistory1(ActionEvent event) {

    }

    @FXML
    void deleteHistory2(ActionEvent event) {

    }

    @FXML
    void deleteHistory3(ActionEvent event) {

    }

    @FXML
    void deleteHistory4(ActionEvent event) {

    }

    @FXML
    void deleteHistory5(ActionEvent event) {

    }

    @FXML
    void deleteHistory6(ActionEvent event) {

    }

    @FXML
    void deleteHistory7(ActionEvent event) {
    	File toDelete = new File("src/application/history/" + currentProfile.getName() + "2.txt");
    	toDelete.delete();
    	File checkIfExists = new File("src/application/history/" + currentProfile.getName() + "1.txt");
    	if (checkIfExists.exists()) {
    		checkIfExists.renameTo(toDelete);
    	}
    	try {
			checkIfExists.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void deleteHistory8(ActionEvent event) {
    	File toDelete = new File("src/application/history/" + currentProfile.getName() + "1.txt");
    	toDelete.delete();
    }
    
    @FXML
    void returnPressed(ActionEvent event) {
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
			historyStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }


	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}
	
	public void setHistoryObjects() {
		
	}

}
