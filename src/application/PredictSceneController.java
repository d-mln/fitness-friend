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

public class PredictSceneController {
	protected Stage predictStage;
	private Profile currentProfile;
    
    @FXML
    private Label caloriesBurned;

    @FXML
    private Label fullGainCalories;

    @FXML
    private Label fullLossCalories;
    
    @FXML
    private Label halfGainCalories;

    @FXML
    private Label halfLossCalories;
    
    @FXML
    private Label fullLossUnitLabel;
    
    @FXML
    private Label fullGainUnitLabel;
    
    @FXML
    private Label halfLossUnitLabel;
    
    @FXML
    private Label halfGainUnitLabel;
    
    @FXML
    private Button predictReturnButton;



    @FXML
    void calculatePressed(ActionEvent event) {

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
			
			mainStage.setTitle("Fitness Friend: " + currentProfile.getName());
			mainStage.setResizable(false);
			mainStage.setScene(scene);
			mainStage.show();
			predictStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public void predict() {
    	caloriesBurned.setText(Integer.toString(currentProfile.getTDEE()));
    	fullLossCalories.setText(Integer.toString(currentProfile.getTDEE() - 1000));
    	halfLossCalories.setText(Integer.toString(currentProfile.getTDEE() - 500));
    	fullGainCalories.setText(Integer.toString(currentProfile.getTDEE() + 1000));
    	halfGainCalories.setText(Integer.toString(currentProfile.getTDEE() + 500));
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}

	public void setUnit(String unit) {
		if (currentProfile.getUnit().equals("Metric")) {
			fullLossUnitLabel.setText("kilogram");
			fullGainUnitLabel.setText("kilogram");
			halfLossUnitLabel.setText("kilograms");
			halfGainUnitLabel.setText("kilograms");
		} else {
			fullLossUnitLabel.setText("pound");
			fullGainUnitLabel.setText("pound");
			halfLossUnitLabel.setText("pounds");
			halfGainUnitLabel.setText("pounds");
		}
	}

}
