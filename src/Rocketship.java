import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	public boolean movingUp;
	public boolean movingDown;
	public boolean movingLeft;
	public boolean movingRight;
	

	public Rocketship(int x_int, int y_int, int w, int h) {
		super(x_int, y_int, w, h);
		speed = 10;
		if (needImage) {
			loadImage("rocket.png");
		}

	}
	public void update() {
		// GamePanel.
		if(movingUp == true && GamePanel.rocket.y - GamePanel.rocket.speed >= 0) {
			up();
		}
		if(movingDown == true && GamePanel.rocket.y + GamePanel.rocket.speed + GamePanel.rocket.height <= LeagueInvaders.HEIGHT - 30) {
			down();
		}
		if(movingLeft == true && GamePanel.rocket.x - GamePanel.rocket.speed >= 0) {
			left();
		}
		if(movingRight == true && GamePanel.rocket.x + GamePanel.rocket.speed + GamePanel.rocket.width <= LeagueInvaders.WIDTH) {
			right();
		}
        super.update();
        
	}

	public void draw(Graphics g) {
		
		if(gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}
		g.setColor(Color.YELLOW);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
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
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 

}
