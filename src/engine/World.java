package engine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
public abstract class World extends Pane{
// asdfbjasdf., 
//	An AnimationTimer that calls act() on the world first and then on each actor in the world every frame.
//	A variable that keeps track of whether the timer is running.
//	A Set of KeyCode objects that holds all the keys that are currently being pressed.
//	Variable(s) that keep track of whether the width and height have been set. Since width and height of Nodes is always 0 until layout is done (some time after show() is called on the stage), you will need a way to determine when the World has been given a real width and height so you can use the getWidth() and getHeight() methods when positioning your actors.
	private AnimationTimer timer;
	private boolean isTimerStopped;
	private boolean isWidthSet;
	private boolean isHeightSet;
	private  Set <KeyCode> keysPressed;

	public World() {
		isWidthSet = false;
		isHeightSet = false;
		
		keysPressed = new HashSet<KeyCode>();
		
		isTimerStopped = false;
		
		widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(newValue.intValue()>0) {
					isWidthSet = true;
				}
				if(isWidthSet && isHeightSet) {
					onDimensionsInitialized();
				}
			}
		   
		    
		});
		
		heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(newValue.intValue()>0) {
					isHeightSet = true;
				}
				if(isWidthSet && isHeightSet) {
					onDimensionsInitialized();
				}
			}
		   
		    
		});
		
		sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				// TODO Auto-generated method stub
				requestFocus();
				
				
			}
		  
		   
		});
		 
		setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				keysPressed.add(event.getCode());
			}
		   
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				keysPressed.remove(event.getCode());
			}
		   
		});
		
		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				act(now);
				
				for(int i = 0;i<getChildren().size();i++) {
					Actor x = (Actor) getChildren().get(i);
					if(x.getClass().equals(Actor.class)) {
						x.act(now);
					}
					
				}
				
			}
			
		};
		
		}
		
	
	public abstract void act(long now);
	
	public void	add(Actor actor) {
		getChildren().add(actor);
	}
	public <A extends Actor> java.util.List<A>	getObjects(java.lang.Class<A> cls){
		return null;
	}
	public <A extends Actor> java.util.List<A> getObjectsAt(double x, double y, java.lang.Class<A> cls){
		List<A> list = new ArrayList<A>();
		for(Node n: getChildren()) {
			if(cls.isInterface()) {
				list.add((A)n);
			}
		}
		
		return list;
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
		timer.start();
		isTimerStopped = false;
	}
	public void	stop() {
		timer.stop();
		isTimerStopped = true;

	}
	
}

