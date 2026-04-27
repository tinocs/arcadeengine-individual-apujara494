package breakout;
import java.io.File;

import engine.Actor;
import javafx.scene.image.Image;	
public class Ball extends Actor{
	int dx;
	int dy;
	public  Ball() {
		dx = 4;
		dy = 7;
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		setImage(img);
		
	}
	@Override
	public void act(long now) {
	move(dx,dy);
	// bounce of four walls
	if(getX()<0) {
		dx = -dx;
	}
	 if(getY()<0) {
		dy=-dy;
	}
	 if(getX()>getWorld().getWidth()- getImage().getWidth()) {
		 dx = -dx;
	 }
	 if(getY()>getWorld().getHeight()- getImage().getHeight()) {
		 dy = -dy;
	 }
	// After moving and bouncing off of walls during the act() step in the Ball class, add code so that a Ball will reverse its y-direction whenever it intersects a Paddle.

	Paddle p = getOneIntersectingObject(Paddle.class);
		if(p!=null) {
			dy = -dy;
		}
	}
	

}
