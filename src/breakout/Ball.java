package breakout;

import java.io.File;
import javafx.util.Duration;
import java.util.List;

import engine.Actor;
import engine.Sound;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;


public class Ball extends Actor {
	int dx;
	int dy;
//	
//	ball_bounce.wav	Plays when the ball bounces off the World edges or the paddle
//	brick_hit.wav	Plays when the ball bounces off a Brick and destroys the Brick
//	lose_life.wav	Plays when the ball reaches the bottom of the screen and the player loses a life
//	game_lost.wav	Plays when the game is lost
//	game_won.wav	Plays when the game is won (both levels cleared)
	
//	Sound quickSound = new Sound("/resources/smw_coin.wav");

		Sound bounceSound = new Sound("/resources/ball_bounce.wav", 1);
	    Sound brickSound  = new Sound("/resources/brick_hit.wav", 1);    
	    Sound loseSound   = new Sound("/resources/lose_life.wav", 1);

	
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
				bounceSound.play();
			}
			if (getY() < 0) {
				dy = -dy;
				bounceSound.play();

			}
			if (getX() > getWorld().getWidth() - getImage().getWidth()) {
				dx = -dx;
				bounceSound.play();

			}
			if (getY() > getWorld().getHeight() - getImage().getHeight()) {
				dy = -dy;
				

				BallWorld bw = (BallWorld) getWorld();
				Score s = bw.getScore();
				int newScore = s.getScore() - 1000;
				s.setScore(newScore);
				  bw.setisPaused(true);
				// bw.setlife--;
				  loseSound.play(); 

			}
			// After moving and bouncing off of walls during the act() step in the Ball
			// class, add code so that a Ball will reverse its y-direction whenever it
			// intersects a Paddle.

			Paddle p = getOneIntersectingObject(Paddle.class);
			if (p != null) {
				bounceSound.play();
				dy = -dy;
			}

			Brick b = getOneIntersectingObject(Brick.class);
			if (b != null) {
				 FadeTransition fade = new FadeTransition(Duration.millis(300), b);
				
				 
				 ScaleTransition shrink = new ScaleTransition(Duration.millis(300), b);
				 
				 ParallelTransition parallelt = new ParallelTransition(fade,shrink);
				 
				 parallelt.setOnFinished(new EventHandler<ActionEvent>() {
					 @Override
						public void handle(ActionEvent event) {
							b.getWorld().remove(b);

						}
					});
				 }
				 
//				 myTransition.setOnFinished(new EventHandler<ActionEvent>() {
//						@Override
//						public void handle(ActionEvent event) {
//							thisBrick.getWorld().remove(thisBrick);
//						}
//					});

				dy = -dy;
				brickSound.play();
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


