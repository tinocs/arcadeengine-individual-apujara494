package breakout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class breakoutDriver extends Application{
	
	public static Stage stage;
	
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Breakout");
		showIntroStage();
		
	}
	
	public static void showIntroStage () {
		BorderPane root = new BorderPane();
	    Text title = new Text("Breakout");
	    
	    Button playButton = new Button("Play");
	    
	    playButton.setOnAction(e -> {
	    	// when play btn is clicked start the game and make a new scene with the world
	    	showGameStage();   
	    });
	    
	    
	    VBox layout = new VBox(20, title, playButton);
	    layout.setAlignment(Pos.CENTER);
	    root.setCenter(layout);
	    Scene scene = new Scene(root, 800, 800);
	    stage.setScene(scene);
	    stage.show();
	}

public static void showGameStage() {
	stage.setTitle("Ball World"); 
	BorderPane root = new BorderPane(); 
	BallWorld bw = new BallWorld(800,800); 
	bw.start();
	root.setCenter(bw);	
	Scene sc = new Scene(root);	
	stage.setScene(sc);
	stage.show();
				
}

}
