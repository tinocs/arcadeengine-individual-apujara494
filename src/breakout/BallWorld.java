package breakout;
import engine.World;
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
		score.setX(width/3);
		score.setY(height/3);

		
		Ball b = new Ball();
		b.setX(getWidth()/4);
		b.setY(getHeight()/4);
		add(b);
		
		Paddle p = new Paddle("paddle.png");
		p.setX(getWidth()/2);
		p.setY(getHeight()/2);
		add(p);
		
	}
	public Score getScore() {
		return score;
	}
	

}
