package breakout;

import java.io.File;
import java.util.List;

import engine.Actor;
import javafx.scene.image.Image;

public class Ball extends Actor {
	int dx;
	int dy;

	public Ball() {
		dx = 2;
		dy = 3;
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		setImage(img);

	}

	@Override
	public void act(long now) {

//		In the act() method of every actor you want to pause, including the world, add the following logic:
//			if (((BallWorld)getWorld()).isPaused()) // If the world is paused
//				Do whatever you want when the game is paused.  Doing nothing is fine.
//			      In my demo, I move the ball wherever the paddle is.
//			else
//				Move/act as usual

		if (((BallWorld) getWorld()).isPaused()) {
			  BallWorld ballworld = (BallWorld) getWorld();
		        List<Paddle> p = ballworld.getObjects(Paddle.class);
			  if(p.size()>0) {
				  Paddle p1 = p.get(0);
				  setX(p1.getX() + p1.getWidth()/2 - getImage().getWidth()/2);
				  setY(p1.getY() - getImage().getHeight() - 2); 
			  }

		} else {

			move(dx, dy);
			// bounce of four walls
			if (getX() < 0) {
				dx = -dx;
			}
			if (getY() < 0) {
				dy = -dy;
			}
			if (getX() > getWorld().getWidth() - getImage().getWidth()) {
				dx = -dx;
			}
			if (getY() > getWorld().getHeight() - getImage().getHeight()) {
				dy = -dy;
				BallWorld bw = (BallWorld) getWorld();
				Score s = bw.getScore();
				int newScore = s.getScore() - 1000;
				s.setScore(newScore);
				  bw.setisPaused(true);
				// bw.setlife--;

			}
			// After moving and bouncing off of walls during the act() step in the Ball
			// class, add code so that a Ball will reverse its y-direction whenever it
			// intersects a Paddle.

			Paddle p = getOneIntersectingObject(Paddle.class);
			if (p != null) {
				dy = -dy;
			}

			Brick b = getOneIntersectingObject(Brick.class);
			if (b != null) {
				dy = -dy;
				BallWorld bw = (BallWorld) getWorld();
				Score s = bw.getScore();
				int newScore = s.getScore() + 100;
				s.setScore(newScore);

				if (getX() > b.getX() && getX() < b.getX() + b.getWidth()) {
					dy = -dy;
				}
				// else if Ball y-coord is between the Brick's top and bottom edges
				// reverse x-direction

				else if (getY() > b.getY() && getY() < b.getY() + b.getHeight()) {
					dx = -dx;
				} else {
					dy = -dy;
					dx = -dx;
				}

			}

		}

	}

}
