package controller;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.control.Button;

public class GameController {
	public static boolean myTurn;
	public static String gameMode;
	public static String key;
	public static String winner;
	private static String[] buttonText;
	
	
	public static String playController(ArrayList<Button> buttonsList, String[][] ticTacToeTable) {
		switch (gameMode) {
		case "easyGame":{
			//bug
			easyGameLogic(buttonsList);
			return "X";
		}
		case "hardGame":{
			//bug
			hardGameLogic(buttonsList);
			return "X";
		}
		case "twoPlayers": {
			if(myTurn) {
				myTurn = !myTurn;
				return "X";	
			}else {
				myTurn = !myTurn;
				return "O";	
			}
		}
		default :{
			return null;
		}
		}
	}
	
	public static boolean winningChecker(String[][] ticTacToeTable) {
		buttonText = new String[3];
		//Checking line 0
		for(int i = 0; i < buttonText.length; i++) {
			buttonText[i] = ticTacToeTable[0][i];
			if(GameController.checkVictory(buttonText)) {
				key = "line 0";
				return true;
			}
		}
		buttonText = new String[3];
		//Checking line 1
		for(int i = 0; i < buttonText.length; i++) {
			buttonText[i] = ticTacToeTable[1][i];
			if(GameController.checkVictory(buttonText)) {
				key = "line 1";
				return true;
			}
		}
		buttonText = new String[3];
		//Checking line 2
		for(int i = 0; i < buttonText.length; i++) {
			buttonText[i] = ticTacToeTable[2][i];
			if(GameController.checkVictory(buttonText)) {
				key = "line 2";
				return true;
			}
		}
		buttonText = new String[3];
		//Checking column 0
		for(int i = 0; i < buttonText.length; i++) {
			buttonText[i] = ticTacToeTable[i][0];
			if(GameController.checkVictory(buttonText)) {
				key = "column 0";
				return true;
			}
		}
		buttonText = new String[3];
		//Checking column 1
		for(int i = 0; i < buttonText.length; i++) {
			buttonText[i] = ticTacToeTable[i][1];
			if(GameController.checkVictory(buttonText)) {
				key = "column 1";
				return true;
			}
		}
		buttonText = new String[3];
		//Checking column 2
		for(int i = 0; i < buttonText.length; i++) {
			buttonText[i] = ticTacToeTable[i][2];
			if(GameController.checkVictory(buttonText)) {
				key = "column 2";
				return true;
			}
		}
		buttonText = new String[3];
		//main diagonal
		for (int i = 0; i < buttonText.length; i++) {
			buttonText[i] = ticTacToeTable[i][i];
			if(GameController.checkVictory(buttonText)) {
				key = "main diagonal";
				return true;
			}
		}
		buttonText = new String[3];
		//secondary diagonal
		for (int i = 0; i < buttonText.length; i++) {
			int j = buttonText.length - 1 - i;
			buttonText[i] = ticTacToeTable[i][j];
			if(checkVictory(buttonText)) {
				key = "secundary diagonal";
				return true;
			}
		}
		//draw
		if(checkDraw(ticTacToeTable)) {
			key = "draw";
			return true;
		}
		return false;
	}
	
	public static boolean checkVictory(String[] vector) {
		if(vector[0] == "X" && vector[1] == "X" && vector[2] == "X") {
			winner = "X";
			return true;
			
		} else if(vector[0] == "O" && vector[1] == "O" && vector[2] == "O") {
			winner = "O";
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDraw(String[][] ticTacToeTable) {
		for (int i = 0; i < ticTacToeTable.length; i++) {
			for (int j = 0; j < ticTacToeTable[0].length; j++) {
				if(ticTacToeTable[i][j] == "") {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void easyGameLogic(ArrayList<Button> buttonsList) {
		Random randomMove = new Random();
		int temp;
		while(checkFreeButton(buttonsList)) {
			temp = randomMove.nextInt(9);
			if(buttonsList.get(temp).getText() == "") {
				buttonsList.get(temp).setText("O");
				break;
			}
		}
	}
	
	private static void hardGameLogic(ArrayList<Button> buttonsList) {
		Random randomMove = new Random();
		int temp;
		while(checkFreeButton(buttonsList)) {
			temp = randomMove.nextInt(9);
			if(buttonsList.get(temp).getText() == "") {
				buttonsList.get(temp).setText("O");
				break;
			}
		}
	}

	private static boolean checkFreeButton(ArrayList<Button> buttonsList) {
		for (int i = 0; i < buttonsList.size(); i++) {
			if(buttonsList.get(i).getText() == "") {
				return true;
			}
		}
		return false;
	}
}
