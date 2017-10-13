package shoottinggame;

import java.awt.event.KeyEvent;

public class Missile extends GraphicObject {
	boolean launched = false;
	int avg = 0;

	public void update() {
		if (launched)
			y -= 5;
		if (y < 25) {
			y = 2000;
			x = -1;
			avg = 0;
			launched = false;
		}
	}

	public void hitMissile() {
		y = 2000;
		x = -1;
		avg = 0;
		launched = false;
	}

	public void keyPressed(KeyEvent event, int x, int y) {
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;
			this.x = x;
			this.y = y;
			avg = x + 62;
		}
	}

	public Missile(String name) {
		super(name);
		y = 2000;
	}
}
