package breakout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class breakoutDriver extends Application{
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Stage s = new Stage();
		s.setTitle("Ball World");
		BorderPane root = new BorderPane();
		BallWorld bw = new BallWorld(800,800);
		
		bw.start();
		root.setCenter(bw);
		Scene sc = new Scene(root);
		s.setScene(sc);
		s.show();
		
	}

}
