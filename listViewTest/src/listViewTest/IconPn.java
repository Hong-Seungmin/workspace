package listViewTest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IconPn extends JPanel {
	private BufferedImage img = null;
	private int iw;
	private int ih;

	public void paint(Graphics g) {
		// Graphics2D g2 = (Graphics2D) g;
		Ellipse2D ellipse = new Ellipse2D.Double(this.getWidth() / 2 - 30, this.getHeight() / 2 - 30,
				this.getWidth() / 2 + 30, this.getHeight() / 2 + 30);

		g.setClip(ellipse);
		g.drawImage(img, this.getWidth() / 2 - 25, this.getHeight() / 2 - 25, this.getWidth() / 2 + 25,
				this.getHeight() / 2 + 25, 0, 0, iw, ih, null);
	}

	public IconPn() {

		this.setMinimumSize(new Dimension(50, 50));
		try {
			String path = "image\\";
			int number = (int) (Math.random() * 82) + 1;
			if (number < 10)
				img = ImageIO.read(new File(path + "00" + number + ".png"));
			else if (number < 100)
				img = ImageIO.read(new File(path + "0" + number + ".png"));
			else if (number < 1000)
				img = ImageIO.read(new File(path + number + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		iw = img.getWidth();
		ih = img.getHeight();
	}

}
