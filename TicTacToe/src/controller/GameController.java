package controller;

public class GameController {
	public static String key;
	private static String[] buttonText;
	
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
			if(GameController.checkVictory(buttonText)) {
				key = "secundary diagonal";
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkVictory(String[] vector) {
		if(vector[0] == "X" && vector[1] == "X" && vector[2] == "X") {
			return true;
			
		} else if(vector[0] == "O" && vector[1] == "O" && vector[2] == "O") {
			return true;
		}else {
			return false;
		}
	}
}
