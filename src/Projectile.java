import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	public Projectile(int x_int, int y_int, int w, int h) {
		super(x_int, y_int, w, h);
		speed = 10;
	}

	public void update() {
		y -= speed;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}
}
