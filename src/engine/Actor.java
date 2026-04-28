package engine;
import java.util.ArrayList;
import java.util.List;

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
		return  getBoundsInParent().getHeight();
	}
	public double getWidth() {
		return  getBoundsInParent().getWidth();

	}
	public World getWorld() {
		return (World)(getParent());
	}
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls){
		
		List<A> intersectingObjects = getIntersectingObjects(cls);
		if(intersectingObjects.size()==0) {
			return null;
		}
		else {
			return intersectingObjects.get(0);
		}
		
	}
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
		List<A> possibleActors  = getWorld().getObjects(cls);
		List<A> touchingActors = new ArrayList<A>();
		for(A obj : possibleActors) {
			if (obj != this && obj.getBoundsInParent().intersects(this.getBoundsInParent())) {
				touchingActors.add(obj);
			}
		}
		return touchingActors;
	}
	public void move(double dx, double dy) {
		setX(getX()+dx);
		setY(getY()+dy);
	}
	
}
