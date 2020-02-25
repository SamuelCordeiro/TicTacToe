package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.Main;

public class FXMLDifficultyMenuController implements Initializable{
	
    @FXML
    private Button easyGameButton;

    @FXML
    private Button hardGameButton;

    @FXML
    void easyGameButtonEvent(ActionEvent event) {
    	GameController.gameMode = "easyGame";
    	Main.changeScreen("FXMLGameScreen");
    }

    @FXML
    void hardGameButtonEvent(ActionEvent event) {
    	GameController.gameMode = "hardGame";
    	Main.changeScreen("FXMLGameScreen");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}
