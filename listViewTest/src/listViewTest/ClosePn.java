package listViewTest;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ClosePn extends JPanel {
	private BufferedImage img = null;
	private AlphaComposite alpha = null;

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setComposite(alpha);
		g.drawImage(img, 0, 16, null);
	}

	public ClosePn() {
		super();

		try {
			img = ImageIO.read(new File("image\\delete.png"));
			alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setTranslucent() {
		alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

	}

	public void setOpaque() {
		alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.f);
	}
}
