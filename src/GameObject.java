import java.awt.Rectangle;

public class GameObject {
	int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 boolean isActive = true;
	 Rectangle collisionBox;

		public GameObject(int x_int, int y_int, int w, int h){
		x = x_int;
		y = y_int;
		width = w;
		height = h;
        collisionBox = new Rectangle(x, y, width, height);
		
	}
	public void update() {
        collisionBox.setBounds(x, y, width, height);
        
	}
}

