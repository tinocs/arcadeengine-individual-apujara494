package breakout;
import java.io.File;

import engine.Actor;
import javafx.scene.image.Image;	
public class Ball extends Actor{
	int dx;
	int dy;
	public  Ball() {
		dx = 2;
		dy = 3;
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
			BallWorld bw = (BallWorld)(getWorld());
			Score s = bw.getScore();
			s.updateDisplay();
			
		}
		if(getY()>getWorld().getHeight()- getImage().getHeight()) {
			dy = -dy;
		}
		// After moving and bouncing off of walls during the act() step in the Ball class, add code so that a Ball will reverse its y-direction whenever it intersects a Paddle.

		Paddle p = getOneIntersectingObject(Paddle.class);
		if(p!=null) {
			dy = -dy;
		}
		
		Brick b = getOneIntersectingObject(Brick.class);
		if(b!=null) {
			if(getX()>b.getX() && getX()<b.getX()+b.getWidth()) {
				dy = -dy;
			}
			//else if Ball y-coord is between the Brick's top and bottom edges
			//reverse x-direction

			else if(getY()>b.getY() && getY()<b.getY()+b.getHeight()){
				dx=-dx;
			}
			else {
				dy=-dy;
				dx=-dx;
			}
		}
	}


}
