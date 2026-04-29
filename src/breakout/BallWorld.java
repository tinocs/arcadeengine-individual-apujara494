package breakout;
import java.util.List;

import engine.World;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
public class BallWorld extends World{
	int width;
	int height;
	Score score;
	public BallWorld(int w, int h){
		width = w;
		height = h;
		setWidth(width);
		setHeight(height);
	}
	@Override
	public void act(long now) {
		
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

		
		
	}
	public Score getScore() {
		return score;
	}
	

}
