package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import main.Main;

public class FXMLGameScreenController implements Initializable{

	@FXML
	private Button button00, button01, button02, button10, button11, button12, button20, button21, button22, restartButton;
	private String[][] ticTacToeTable;
	private ArrayList<Button> buttonsList = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadGame();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button00) {
			move(button00);
		}
		if(e.getSource() == button01) {
			move(button01);
		}
		if(e.getSource() == button02) {
			move(button02);
		}
		if(e.getSource() == button10) {
			move(button10);
		}
		if(e.getSource() == button11) {
			move(button11);
		}
		if(e.getSource() == button12) {
			move(button12);
		}
		if(e.getSource() == button20) {
			move(button20);
		}
		if(e.getSource() == button21) {
			move(button21);
		}
		if(e.getSource() == button22) {
			move(button22);
		}
		if(e.getSource() == restartButton) {
			Main.changeScreen("FXMLGameScreen");
			loadGame();
		}
	}
	
	private void move(Button button) {
		if(button.getText() == "") {
			if(GameController.gameMode == "twoPlayers") {
				button.setText(GameController.playController(buttonsList, ticTacToeTable));
				updateGame();
			}else {
				button.setText("X");
				if(updateGame()) {
					GameController.playController(buttonsList, ticTacToeTable);
				}
			}
		}
	}
	
	private void loadGame() {
		ticTacToeTable = new String [3][3];
		loadButtonsList();
		loadButtons();
		loadTicTacToeTable();
		GameController.myTurn = true;
		disableButtons(false);
	}

	private void loadButtons() {
		for (int i = 0; i < buttonsList.size(); i++) {
			buttonsList.get(i).setText("");
			buttonsList.get(i).setStyle("-fx-font: 40 arial; -fx-base: #b6e7c9;");
		}
		restartButton.setVisible(false);
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
		case "draw":{
			reddeningButtons();
			break;
		}
		}
		disableButtons(true);
		showEndGameAlert(key);
	}

	private void showEndGameAlert(String key) {
		Alert endGame = new Alert(AlertType.INFORMATION);
		if(key != "draw") {
			endGame.setTitle("Victory");
			endGame.setContentText("Player \"" + GameController.winner + "\" won.");
		}else {
			endGame.setContentText("The game was a draw.");
			endGame.setTitle("Draw");
		}
		endGame.setHeaderText(null);
		endGame.show();

	}

	private void reddeningButtons() {
		for (int i = 0; i < buttonsList.size(); i++) {
			buttonsList.get(i).setStyle("-fx-base: #FF0000;");
		}
	}

	private void disableButtons(boolean disable) {
		for (int i = 0; i < buttonsList.size(); i++) {
			buttonsList.get(i).setDisable(disable);
		}
	}

	private void loadButtonsList() {
		buttonsList.add(button00);
		buttonsList.add(button01);
		buttonsList.add(button02);
		buttonsList.add(button10);
		buttonsList.add(button11);
		buttonsList.add(button12);
		buttonsList.add(button20);
		buttonsList.add(button21);
		buttonsList.add(button22);
	}

	private boolean updateGame() {
		loadTicTacToeTable();
		if (GameController.winningChecker(ticTacToeTable)){
			showVictory(GameController.key);
			return false;
		}else {
			return true;
		}
	}

	private void loadTicTacToeTable() {
		int temp = 0;
		for(int i = 0; i < ticTacToeTable.length; i++) {
			for (int j = 0; j < ticTacToeTable[0].length; j++) {
				ticTacToeTable[i][j] = buttonsList.get(temp++).getText();
			}
		}

	}
}
