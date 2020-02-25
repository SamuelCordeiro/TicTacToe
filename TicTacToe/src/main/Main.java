package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage stage;
	private static Scene FXMLMainScreen;
	private static Scene FXMLGameScreen;
	private static Scene FXMLDifficultyMenu;

	@Override
	public void start(Stage currentStage) throws Exception {
		stage = currentStage;
		Parent fxmlMainScreen = FXMLLoader.load(getClass().getResource("/view/FXMLMainScreen.fxml"));
		FXMLMainScreen = new Scene(fxmlMainScreen);
		
		Parent fxmlGameScreen = FXMLLoader.load(getClass().getResource("/view/FXMLGameScreen.fxml"));
		FXMLGameScreen = new Scene(fxmlGameScreen);
		
		Parent fxmlDifficultyMenu = FXMLLoader.load(getClass().getResource("/view/FXMLDifficultyMenu.fxml"));
		FXMLDifficultyMenu = new Scene(fxmlDifficultyMenu);
		
		currentStage.setTitle("Tic Tac Toe");
		currentStage.setScene(FXMLMainScreen);
		currentStage.show();
	}
	
	public static void changeScreen(String Screen) {
		switch (Screen) {
		case "FXMLMainScreen": {
			stage.setScene(FXMLMainScreen);
			break;
		}
		case "FXMLGameScreen":{
			stage.setScene(FXMLGameScreen);
			break;
		}
		case "FXMLDifficultyMenu":{
			stage.setScene(FXMLDifficultyMenu);
			break;
		}
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
