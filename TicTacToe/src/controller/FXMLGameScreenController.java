package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.Main;

public class FXMLGameScreenController implements Initializable{

	@FXML
	private Button button00;

	@FXML
	private Button button01;

	@FXML
	private Button button02;

	@FXML
	private Button button10;

	@FXML
	private Button button11;

	@FXML
	private Button button12;

	@FXML
	private Button button20;

	@FXML
	private Button button21;

	@FXML
	private Button button22;

	@FXML
	private Button restartButton;

	private boolean myTurn;
	private String[][] ticTacToeTable;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadGame();

	}

	@FXML
	void button00Event(ActionEvent event) {
		if(button00.getText() == "") {
			button00.setText(playController());		
			ticTacToeTable[0][0] = button00.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button01Event(ActionEvent event) {
		if(button01.getText() == "") {
			button01.setText(playController());
			ticTacToeTable[0][1] = button01.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button02Event(ActionEvent event) {
		if(button02.getText() == "") {
			button02.setText(playController());
			ticTacToeTable[0][2] = button02.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button10Event(ActionEvent event) {
		if(button10.getText() == "") {
			button10.setText(playController());
			ticTacToeTable[1][0] = button10.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button11Event(ActionEvent event) {
		if(button11.getText() == "") {
			button11.setText(playController());
			ticTacToeTable[1][1] = button11.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button12Event(ActionEvent event) {
		if(button12.getText() == "") {
			button12.setText(playController());
			ticTacToeTable[1][2] = button12.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button20Event(ActionEvent event) {
		if(button20.getText() == "") {
			button20.setText(playController());
			ticTacToeTable[2][0] = button20.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button21Event(ActionEvent event) {
		if(button21.getText() == "") {
			button21.setText(playController());
			ticTacToeTable[2][1] = button21.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void button22Event(ActionEvent event) {
		if(button22.getText() == "") {
			button22.setText(playController());
			ticTacToeTable[2][2] = button22.getText();
			if (GameController.winningChecker(ticTacToeTable)){
				showVictory(GameController.key);
			}
		}
	}

	@FXML
	void restartButtonEvent(ActionEvent event) {
		Main.changeScreen("FXMLGameScreen");
		loadGame();

	}

	private String playController() {
		if(myTurn) {
			myTurn = !myTurn;
			return "X";	
		}else {
			myTurn = !myTurn;
			return "O";	
		}
	}
	
	private void loadButtons() {

		button00.setText("");
		button01.setText("");
		button02.setText("");
		button10.setText("");
		button11.setText("");
		button12.setText("");
		button20.setText("");
		button21.setText("");
		button22.setText("");
		button00.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button01.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button02.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button10.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button11.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button12.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button20.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button21.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		button22.setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		restartButton.setVisible(false);
	}
	
	private void loadGame() {
		loadButtons();
		myTurn = true;
		ticTacToeTable = new String [3][3];
		disableButtons(false);
	}
	public void showVictory(String key) {
		reddeningButtons();
		restartButton.setVisible(true);
		switch (key) {
		case "line 0": {
			button00.setStyle("-fx-base: #00FF00;");
			button01.setStyle("-fx-base: #00FF00;");
			button02.setStyle("-fx-base: #00FF00;");
			break;
		}
		case "line 1": {
			button10.setStyle("-fx-base: #00FF00;");
			button11.setStyle("-fx-base: #00FF00;");
			button12.setStyle("-fx-base: #00FF00;");
			break;
		}
		case "line 2": {
			button20.setStyle("-fx-base: #00FF00;");
			button21.setStyle("-fx-base: #00FF00;");
			button22.setStyle("-fx-base: #00FF00;");
			break;
		}
		case "column 0": {
			button00.setStyle("-fx-base: #00FF00;");
			button10.setStyle("-fx-base: #00FF00;");
			button20.setStyle("-fx-base: #00FF00;");
			break;
		}
		case "column 1": {
			button01.setStyle("-fx-base: #00FF00;");
			button11.setStyle("-fx-base: #00FF00;");
			button21.setStyle("-fx-base: #00FF00;");
			break;
		}
		case "column 2": {
			button02.setStyle("-fx-base: #00FF00;");
			button12.setStyle("-fx-base: #00FF00;");
			button22.setStyle("-fx-base: #00FF00;");
			break;
		}
		case "main diagonal": {
			button00.setStyle("-fx-base: #00FF00;");
			button11.setStyle("-fx-base: #00FF00;");
			button22.setStyle("-fx-base: #00FF00;");
			break;
		}
		case "secundary diagonal": {
			button02.setStyle("-fx-base: #00FF00;");
			button11.setStyle("-fx-base: #00FF00;");
			button20.setStyle("-fx-base: #00FF00;");
			break;
		}	
		}
		disableButtons(true);
	}
	
	private void reddeningButtons() {

		button00.setStyle("-fx-base: #FF0000;");
		button01.setStyle("-fx-base: #FF0000;");
		button02.setStyle("-fx-base: #FF0000;");
		button10.setStyle("-fx-base: #FF0000;");
		button11.setStyle("-fx-base: #FF0000;");
		button12.setStyle("-fx-base: #FF0000;");
		button20.setStyle("-fx-base: #FF0000;");
		button21.setStyle("-fx-base: #FF0000;");
		button22.setStyle("-fx-base: #FF0000;");
	}
	
	private void disableButtons(boolean disable) {
		button00.setDisable(disable);
		button01.setDisable(disable);
		button02.setDisable(disable);
		button10.setDisable(disable);
		button11.setDisable(disable);
		button12.setDisable(disable);
		button20.setDisable(disable);
		button21.setDisable(disable);
		button22.setDisable(disable);
	}
}
