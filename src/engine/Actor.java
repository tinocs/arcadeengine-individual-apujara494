package engine;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
public abstract class Actor extends ImageView{
	private AnimationTimer myTimer;
	boolean isRunning;

	public  Actor() {
		
	}
	public abstract void act (long now);
	public void addedToWorld() {
		
	}
	public double getHeight() {
		return  getImage().getHeight();
	}
	public double getWidth() {
		return getImage().getWidth();
	}
	public World getWorld() {
		return (World)(getParent());
	}
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls){
		return null;
	}
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
		return null;
	}
	public void move(double dx, double dy) {
		setX(getX()+dx);
		setY(getY()+dy);
	}
	
}
