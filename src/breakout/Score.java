package breakout;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
public class Score extends Text {
	int score;
	int fontSize;
	public Score(){
		score  = 0;
		setFont(new Font(fontSize+10));
		updateDisplay();
		
	}
	public void updateDisplay() {
		setText("Score:" + score);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int s) {
		score =s;
		updateDisplay();
	}

}
