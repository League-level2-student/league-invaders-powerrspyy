import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int x_int, int y_int, int w, int h) {
		super(x_int, y_int, w, h);
		speed = 10;
				
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	public void up() {
		y -= speed;
	}
	public void down() {
		y += speed;
	}
	public void left() {
		x -= speed;
	}
	public void right() {
		x += speed;
	}

}
