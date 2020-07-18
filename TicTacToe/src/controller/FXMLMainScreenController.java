package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.Main;

public class FXMLMainScreenController implements Initializable{
	
	@FXML
    private Button onePlayerButton;

    @FXML
    private Button twoPlayerButton;

    @FXML
    private Button exitButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML
	void onePlayerButtonEvent(ActionEvent event) {
		GameController.gameMode = "easyGame";
    	Main.changeScreen("FXMLGameScreen");
	}
	@FXML
	void twoPlayerButtonEvent(ActionEvent event) {
		GameController.gameMode = "twoPlayers";
		Main.changeScreen("FXMLGameScreen");
	}
	@FXML
	void exitButtonEvent(ActionEvent event) {
		System.exit(0);
	}

}
