import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject {
	public static BufferedImage image;
	public static boolean gotImage = false;
	public static boolean needImage = true;

	public Projectile(int x_int, int y_int, int w, int h) {
		super(x_int, y_int, w, h);
		speed = 10;
		if (needImage) {
			loadImage("bullet.png");
		}
	}

	public void update() {
		y -= speed;
		super.update();
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.RED);
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
