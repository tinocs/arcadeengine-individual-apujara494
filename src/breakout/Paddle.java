package breakout;
import engine.Actor;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
public class Paddle extends Actor {
	int dx=2;
	int dy=2;
	public Paddle(String fileName) {
		String path = getClass().getClassLoader().getResource("resources/paddle.png").toString();
		Image img = new Image(path);
		setImage(img);
	}
	@Override
	public void act(long now) {
		if(getWorld().isKeyPressed(KeyCode.LEFT)) {
			 setX(getX() - dx);
		}
		if(getWorld().isKeyPressed(KeyCode.RIGHT)) {
			 setX(getX() + dx);
		}
	}

}
