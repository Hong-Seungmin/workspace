package shoottinggame;

public class Enemy extends GraphicObject {
	int dx;

	public void update() {
		if ((int) (Math.random() * 5000) > 4990)
			dx = -dx;

		x += dx;
		if (x < 0)
			dx = +1;
		if (x > 500)
			dx = -1;
	}

	public Enemy(String name) {
		super(name);
		if ((int) (Math.random() * 100) > 50)
			dx = -10;
		else
			dx = 10;
		x = (int) (Math.random() * 500);
		y = 0;
	}
}
