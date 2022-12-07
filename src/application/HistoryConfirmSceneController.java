package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistoryConfirmSceneController {
    protected Stage confirmStage;
	private Profile currentProfile;
	protected int buttonPressed = 0;
	
	@FXML
    void confirmDelete(ActionEvent event) throws IOException {
    	if (buttonPressed == 1) {
        	
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "1.txt");
        	toDelete.delete();
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "2.txt"), new File("src/application/history/" + currentProfile.getName() + "1.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "3.txt"), new File("src/application/history/" + currentProfile.getName() + "2.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "4.txt"), new File("src/application/history/" + currentProfile.getName() + "3.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "5.txt"), new File("src/application/history/" + currentProfile.getName() + "4.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "6.txt"), new File("src/application/history/" + currentProfile.getName() + "5.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "7.txt"), new File("src/application/history/" + currentProfile.getName() + "6.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "8.txt"), new File("src/application/history/" + currentProfile.getName() + "7.txt"));
        	try {
        	if (!currentProfile.getHistoryOldest().equals(null) || !currentProfile.getHistoryOldest().equals(toDelete)) {
        		currentProfile.getHistoryOldest().delete();
        	}
        	} catch (Exception e) {
        	}
        	returnToHistory();
    		
    	} else if (buttonPressed == 2) {
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "2.txt");
        	toDelete.delete();
        	toDelete = new File("src/application/history/" + currentProfile.getName() + "1.txt");
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "3.txt"), new File("src/application/history/" + currentProfile.getName() + "2.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "4.txt"), new File("src/application/history/" + currentProfile.getName() + "3.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "5.txt"), new File("src/application/history/" + currentProfile.getName() + "4.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "6.txt"), new File("src/application/history/" + currentProfile.getName() + "5.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "7.txt"), new File("src/application/history/" + currentProfile.getName() + "6.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "8.txt"), new File("src/application/history/" + currentProfile.getName() + "7.txt"));
        	if (!currentProfile.getHistoryOldest().equals(toDelete)) {
        		currentProfile.getHistoryOldest().delete();
        	}
        	returnToHistory();
    		
    	} else if (buttonPressed == 3) {
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "3.txt");
        	toDelete.delete();
        	toDelete = new File("src/application/history/" + currentProfile.getName() + "2.txt");
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "4.txt"), new File("src/application/history/" + currentProfile.getName() + "3.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "5.txt"), new File("src/application/history/" + currentProfile.getName() + "4.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "6.txt"), new File("src/application/history/" + currentProfile.getName() + "5.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "7.txt"), new File("src/application/history/" + currentProfile.getName() + "6.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "8.txt"), new File("src/application/history/" + currentProfile.getName() + "7.txt"));
        	if (!currentProfile.getHistoryOldest().equals(toDelete)) {
        		currentProfile.getHistoryOldest().delete();
        	}
        	returnToHistory();
    		
    	} else if (buttonPressed == 4) {
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "4.txt");
        	toDelete.delete();
        	toDelete = new File("src/application/history/" + currentProfile.getName() + "3.txt");
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "5.txt"), new File("src/application/history/" + currentProfile.getName() + "4.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "6.txt"), new File("src/application/history/" + currentProfile.getName() + "5.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "7.txt"), new File("src/application/history/" + currentProfile.getName() + "6.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "8.txt"), new File("src/application/history/" + currentProfile.getName() + "7.txt"));
        	if (!currentProfile.getHistoryOldest().equals(toDelete)) {
        		currentProfile.getHistoryOldest().delete();
        	}
        	returnToHistory();
    		
    	} else if (buttonPressed == 5) {
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "5.txt");
        	toDelete.delete();
        	toDelete = new File("src/application/history/" + currentProfile.getName() + "4.txt");
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "6.txt"), new File("src/application/history/" + currentProfile.getName() + "5.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "7.txt"), new File("src/application/history/" + currentProfile.getName() + "6.txt"));
        	currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "8.txt"), new File("src/application/history/" + currentProfile.getName() + "7.txt"));
        	if (!currentProfile.getHistoryOldest().equals(toDelete)) {
        		currentProfile.getHistoryOldest().delete();
        	}
        	returnToHistory();
    		
    	} else if (buttonPressed == 6) {
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "6.txt");
        	toDelete.delete();
        	toDelete = new File("src/application/history/" + currentProfile.getName() + "5.txt");
    		currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "7.txt"), new File("src/application/history/" + currentProfile.getName() + "6.txt"));
    		currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "8.txt"), new File("src/application/history/" + currentProfile.getName() + "7.txt"));
        	if (!currentProfile.getHistoryOldest().equals(toDelete)) {
        		currentProfile.getHistoryOldest().delete();
        	}
        	returnToHistory();
    		
    	} else if (buttonPressed == 7) {
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "7.txt");
        	toDelete.delete();
        	toDelete = new File("src/application/history/" + currentProfile.getName() + "6.txt");
    		currentProfile.copyHistory(new File("src/application/history/" + currentProfile.getName() + "8.txt"), new File("src/application/history/" + currentProfile.getName() + "7.txt"));
        	if (!currentProfile.getHistoryOldest().equals(toDelete)) {
        		currentProfile.getHistoryOldest().delete();
        	}
        	returnToHistory();
    		
    	} else if (buttonPressed == 8) {
        	File toDelete = new File("src/application/history/" + currentProfile.getName() + "8.txt");
        	toDelete.delete();
        	returnToHistory();
    	}
    }

	public void setCurrentProfile(Profile i) {
		currentProfile = i;
	}
	
	public void returnToHistory() {
    	Stage historyStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/scenes/HistoryScene.fxml"));
    		HistorySceneController controller = (HistorySceneController)loader.getController();
    		controller.historyStage = historyStage;
    		controller.setCurrentProfile(currentProfile);
    		controller.setHistoryObjects();
    		Scene scene = new Scene(root,450,400);
    		
    		historyStage.setTitle("Fitness Friend: History: " + currentProfile.getName());
    		historyStage.setResizable(false);
    		historyStage.setScene(scene);
    		historyStage.show();
    		confirmStage.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
}
