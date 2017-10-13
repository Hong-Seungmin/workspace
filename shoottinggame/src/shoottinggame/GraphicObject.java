package shoottinggame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GraphicObject {
	BufferedImage img = null;
	int x = 0, y = 0;

	public void update() {

	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	public void keyPressed(KeyEvent event) {

	}

	public GraphicObject(String name) {
		try {
			img = ImageIO.read(new File(name));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

}
