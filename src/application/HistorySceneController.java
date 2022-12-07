package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    private Label currentWeightLabel;
    
    @FXML
    private Label unitLabel;
	
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
	
    /*
     * 
     * Events for each button
     * 
     */
    
    @FXML
    void deleteHistory1(ActionEvent event) throws IOException {
    	// only do anything if there actually is an entry
    	if (!entryDate1.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 1;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }

    @FXML
    void deleteHistory2(ActionEvent event) throws IOException {
    	// only do anything if there actually is an entry
    	if (!entryDate2.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 2;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }

    @FXML
    void deleteHistory3(ActionEvent event) throws IOException {
    	// only do anything if there actually is an entry
    	if (!entryDate3.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 3;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }

    @FXML
    void deleteHistory4(ActionEvent event) throws IOException {
    	// only do anything if there actually is an entry
    	if (!entryDate4.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 4;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }

    @FXML
    void deleteHistory5(ActionEvent event) throws IOException {
    	// only do anything if there actually is an entry
    	if (!entryDate5.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 5;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }

    @FXML
    void deleteHistory6(ActionEvent event) throws IOException{
    	// only do anything if there actually is an entry
    	if (!entryDate6.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 6;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }

    @FXML
    void deleteHistory7(ActionEvent event) throws IOException {
    	// only do anything if there actually is an entry
    	if (!entryDate7.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 7;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }

    @FXML
    void deleteHistory8(ActionEvent event) {
    	// only do anything if there actually is an entry
    	if (!entryDate8.getText().equals("No history")) {
	    	Stage confirmStage = new Stage();
	    	
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryConfirmScene.fxml"));
	    		HistoryConfirmSceneController controller = (HistoryConfirmSceneController)loader.getController();
	    		controller.confirmStage = confirmStage;
	    		controller.setCurrentProfile(currentProfile);
	    		controller.buttonPressed = 8;
	    		Scene scene = new Scene(root,195,105);
	    		
	    		confirmStage.setTitle("Fitness Friend: Confirm? ");
	    		confirmStage.setResizable(false);
	    		confirmStage.setScene(scene);
	    		confirmStage.show();
	    		historyStage.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	} else {
    		return;
    	}
    }
    
    // do nothing, just return to main scene
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
			historyStage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    // maintain current profile between scenes
	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}
	
	// Sets all labels and buttons to their correct values when loading the scene
	@SuppressWarnings("deprecation")
	public void setHistoryObjects() throws IOException {
		// set current weight + unit
		currentWeightLabel.setText(Double.toString(currentProfile.getWeight()));
		if (currentProfile.getUnit().equals("Metric")) {
			unitLabel.setText("kilograms");
		} else {
			unitLabel.setText("pounds");
		}
		
		
		// entry 1
		if (!currentProfile.getHistoryDate(1).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(1)));
			entryDate1.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight1.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(1))) + " kilograms");
			} else {
				entryWeight1.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(1))) + " pounds");
			}
		} else {
			return;
		}
		
		// entry 2
		if (!currentProfile.getHistoryDate(2).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(2)));
			entryDate2.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight2.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(2))) + " kilograms");
			} else {
				entryWeight2.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(2))) + " pounds");
			}
		} else {
			return;
		}
		
		// entry 3
		if (!currentProfile.getHistoryDate(3).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(3)));
			entryDate3.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight3.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(3))) + " kilograms");
			} else {
				entryWeight3.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(3))) + " pounds");
			}
		} else {
			return;
		}
		
		// entry 4
		if (!currentProfile.getHistoryDate(4).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(4)));
			entryDate4.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight4.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(4))) + " kilograms");
			} else {
				entryWeight4.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(4))) + " pounds");
			}
		} else {
			return;
		}
		
		// entry 5
		if (!currentProfile.getHistoryDate(5).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(5)));
			entryDate5.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight5.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(5))) + " kilograms");
			} else {
				entryWeight5.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(5))) + " pounds");
			}
		} else {
			return;
		}
		
		// entry 6
		if (!currentProfile.getHistoryDate(6).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(6)));
			entryDate6.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight6.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(6))) + " kilograms");
			} else {
				entryWeight6.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(6))) + " pounds");
			}
		} else {
			return;
		}
		
		// entry 7
		if (!currentProfile.getHistoryDate(7).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(7)));
			entryDate7.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight7.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(7))) + " kilograms");
			} else {
				entryWeight7.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(7))) + " pounds");
			}
		} else {
			return;
		}
		
		// entry 8
		if (!currentProfile.getHistoryDate(8).equals("NONE")) {
			Date historyDate = new Date(Long.parseLong(currentProfile.getHistoryDate(8)));
			entryDate8.setText("On "+ (historyDate.getYear() + 1900) + "-" + (historyDate.getMonth() + 1) + "-" + historyDate.getDate() + " I weighed");
			if (currentProfile.getUnit().equals("Metric")) {
				entryWeight8.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(8))) + " kilograms");
			} else {
				entryWeight8.setText(String.format("%.2f", Double.parseDouble(currentProfile.getHistoryWeight(8))) + " pounds");
			}
		} else {
			return;
		}
	}

}
