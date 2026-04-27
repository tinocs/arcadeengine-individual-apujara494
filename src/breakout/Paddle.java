package breakout;
import engine.Actor;
import javafx.scene.image.Image;
public class Paddle extends Actor {
	public Paddle(String fileName) {
		String path = getClass().getClassLoader().getResource("resources/paddle.png").toString();
		Image img = new Image(path);
		setImage(img);
	}
	@Override
	public void act(long now) {
		
		
	}

}
