package ap.RockPaperScissors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent p = FXMLLoader.load(getClass().getResource("RPS.fxml"));
		Scene s = new Scene(p);
		stage.setScene(s);
		stage.setTitle("Rock, Paper, Scissors");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
