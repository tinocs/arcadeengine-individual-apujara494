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
		List<A> allObjects = getWorld().getObjects(cls);
		List<A> intersectingObjects = new ArrayList<A>();
		for(int i = 0;i<allObjects.size();i++) {
			A actor = allObjects.get(i);
			if(actor.getBoundsInParent().intersects(this.getBoundsInParent()) && actor!=this ) {
				intersectingObjects.add(actor);
			}
		}
		return intersectingObjects;
	}
	public void move(double dx, double dy) {
		setX(getX()+dx);
		setY(getY()+dy);
	}
	
}
