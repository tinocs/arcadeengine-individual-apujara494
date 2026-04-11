package engine;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
public abstract class World extends Pane{
//	An AnimationTimer that calls act() on the world first and then on each actor in the world every frame.
//	A variable that keeps track of whether the timer is running.
//	A Set of KeyCode objects that holds all the keys that are currently being pressed.
//	Variable(s) that keep track of whether the width and height have been set. Since width and height of Nodes is always 0 until layout is done (some time after show() is called on the stage), you will need a way to determine when the World has been given a real width and height so you can use the getWidth() and getHeight() methods when positioning your actors.
	private AnimationTimer timer;
	private boolean isTimerStopped;
	
	private boolean isWidthSet;
	private boolean isHeightSet;
	private  ArrayList<KeyCode> keysPressed = new ArrayList<>();

	public World() {
		isWidthSet = false;
		isHeightSet = false;
		
		isTimerStopped = true;
		
		//timer = new AnimationTimer();
		
	}
	public abstract void act(long now);
	
	public void	add(Actor actor) {
		getChildren().add(actor);
	}
	public <A extends Actor> java.util.List<A>	getObjects(java.lang.Class<A> cls){
		return null;
	}
	public <A extends Actor> java.util.List<A> getObjectsAt(double x, double y, java.lang.Class<A> cls){
		return null;
	}
	public boolean	isKeyPressed(javafx.scene.input.KeyCode code) {
		return false;
	}
	public boolean	isStopped() {
		return isTimerStopped;
	}
	public abstract void onDimensionsInitialized();
	
	public void remove(Actor actor) {
		getChildren().remove(actor);

	}
	public void	start() {
		
	}
	public void	stop() {
		
	}
	//private class widthListener
	
	// private class heightListener
}
