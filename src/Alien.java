import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {
	public static BufferedImage image;
	public static boolean gotImage = false;
	public static boolean needImage = true;

	public Alien(int x_int, int y_int, int w, int h) {
		super(x_int, y_int, w, h);
		speed = 1;
		if (needImage) {
			loadImage("alien.png");
		}
	}

	public void update() {
		y += speed;
		super.update();
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}else {
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
		}
	}

	public void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

}
