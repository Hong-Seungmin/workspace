package shoottinggame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
	private ArrayList<Enemy> enemy;
	private SpaceShip spaceship;
	private ArrayList<Missile> missile;

	private int cnt = 0;

	public void paint(Graphics g) {
		super.paint(g);

		for (Enemy i : enemy)
			i.draw(g);

		spaceship.draw(g);

		for (Missile i : missile)
			if (i.launched)
				i.draw(g);
	}

	public void keyPressed(KeyEvent event) {
		spaceship.keyPressed(event);
		if (cnt < 10)
			missile.get(cnt++).keyPressed(event, spaceship.x, spaceship.y);
		else
			cnt = 0;
	}

	public void keyReleased(KeyEvent event) {

	}

	public void keyTyped(KeyEvent event) {

	}

	public MyPanel() {
		super();
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);

		enemy = new ArrayList<Enemy>();
		for (int i = 0; i < 10; i++)
			enemy.add(new Enemy(".\\res\\enemy.png"));

		spaceship = new SpaceShip(".\\res\\spaceship.png");

		missile = new ArrayList<Missile>();
		for (int i = 0; i < 10; i++)
			missile.add(new Missile(".\\res\\missile.png"));

		cnt = missile.size();

		class MyThread extends Thread {
			public void run() {
				while (true) {
					hitEnemy();
					for (Enemy i : enemy)
						i.update();
					spaceship.update();

					for (Missile i : missile)
						i.update();
					
					repaint();

					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {

					}
				}
			}
		}

		Thread t = new MyThread();
		t.start();
	}

	public void hitEnemy() {
		Iterator<Enemy> iter = enemy.iterator();
		Enemy i;

		while (iter.hasNext()) {
			i = iter.next();
			for(Missile j: missile)
			if (((i.y + 75) > j.y) && ((i.x + 25) < j.avg && (i.x + 193) > j.avg)) {
				iter.remove();
				j.hitMissile();
				break;
			}
		}
	}

}
