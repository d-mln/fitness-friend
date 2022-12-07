package application;

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

public class SettingsSceneController {
	protected Stage settingsStage;
	private Profile currentProfile;
    @FXML
    private TextField settingsAgeInput;

    @FXML
    private ChoiceBox<String> settingsGenderInput;

    @FXML
    private TextField settingsHeightInput;

    @FXML
    private Button settingsReturnWOSaving;

    @FXML
    private Button settingsSaveAge;

    @FXML
    private Button settingsSaveGender;

    @FXML
    private Button settingsSaveHeight;

    @FXML
    private Button settingsSaveUnit;

    @FXML
    private ChoiceBox<String> settingsUnitInput;

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
			settingsStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void saveAge(ActionEvent event) {
    	currentProfile.setAge(Integer.parseInt(settingsAgeInput.getText()));
    	try {
			currentProfile.saveProfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void saveGender(ActionEvent event) {
    	currentProfile.setGender(settingsGenderInput.getValue());
    	try {
			currentProfile.saveProfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void saveHeight(ActionEvent event) {
    	currentProfile.setHeight(Double.parseDouble(settingsHeightInput.getText()));
    	try {
			currentProfile.saveProfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void saveUnit(ActionEvent event) {
    	// make sure it doesn't perform conversion if the unit is the same as selected
    	if (currentProfile.getUnit().equals(settingsUnitInput.getValue())) {
    		return;
    	} else {
	    	currentProfile.setUnit(settingsUnitInput.getValue());
	    	if (currentProfile.getUnit().equals("Metric")) {
		    	currentProfile.setHeight(currentProfile.getHeight() * 2.54);
		    	currentProfile.setWeight(currentProfile.getWeight() * 0.45359);
	    	} else {
	    		currentProfile.setHeight(currentProfile.getHeight() * 0.394);
	    		currentProfile.setWeight(currentProfile.getWeight() * 2.2046);
	    	}
	    	try {
				currentProfile.saveProfile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}
	
	public void setDropdowns() {
		settingsUnitInput.setValue(currentProfile.getUnit());
		settingsGenderInput.setValue(currentProfile.getGender());
	}
}
