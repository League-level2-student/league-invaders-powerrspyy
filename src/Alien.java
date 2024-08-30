import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x_int, int y_int, int w, int h) {
		super(x_int, y_int, w, h);
		speed = 1;
	}

	public void update() {
		y += speed;
	}

	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
	}

}
