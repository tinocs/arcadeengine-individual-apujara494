package breakout;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
public class Lives  extends Text{
	int lives;
	int fontSize;
	public Lives(){
		lives  = 3;
	    setFont(new Font(30));
		updateDisplay();
		
	}
	public void updateDisplay() {
		setText("Lives:" + lives);
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int s) {
		lives =s;
		updateDisplay();
	}
}
