package breakout;
import java.util.List;

import engine.World;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
public class BallWorld extends World{
	int width;
	int height;
	Score score;
	int level;
	Lives life;
	public BallWorld(int w, int h){
		width = w;
		height = h;
		setWidth(width);
		setHeight(height);
	}
	@Override
	//In your BallWorld's act() method, check if the number of Brick objects is zero.  If so, increment the level and load the bricks for that level.  If the level is 3 or more, take the user back to the main menu after they see the game over message and press a key.

	public void act(long now) {
		List<Brick> bricks = getObjects(Brick.class);
		if(bricks.size()==0) {
			if(level==3) {
				
			}
			else {
				level++;
				loadNewLevel();
			}
		}
	}

	@Override
	public void onDimensionsInitialized() {
		
		score = new Score();
		score.setX(getWidth()/2);
		
		score.setY(height/2);
	
	//	getWorld().getChildren.add(score);

		
		Ball b = new Ball();
		b.setX(getWidth()/4);
		b.setY(getHeight()/4);
		add(b);
		
		Paddle p = new Paddle("paddle.png");
		p.setX(getWidth()/2);
		p.setY(getHeight()/2);
		add(p);
		
		Brick brick = new Brick();
		brick.setX(100);
		brick.setY(100);
		add(brick);
		
		setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Add your code here
				List<Paddle> list = getObjects(Paddle.class);
			    if (list.size()>0) {
		            Paddle p = list.get(0);
		            p.setX(event.getX() - p.getWidth() / 2);
		        }
				
			}});

		
		score = new Score();
		score.setX(20);
		score.setY(40);
		getChildren().add(score);
		//add(score);
		//getChildren().add(s);		
		
		life = new Lives();
		life.setX(400);
		life.setY(40);
		getChildren().add(life);
		
	}
	public Score getScore() {
		return score;
	}
	public void loadNewLevel() {
		List<Brick> bricks = getObjects(Brick.class);
		for(int i = 0;i<bricks.size();i++) {
			bricks.remove(i);
			i--;
		}
	}
}
