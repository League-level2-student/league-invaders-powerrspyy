import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel gamePanel = new GamePanel();

	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;

	JFrame frame;// = new JFrame();

	public LeagueInvaders() {
		frame = new JFrame("League Invaders");
		// frame.setTitle("")

	}

	public void setup() {

		frame.setSize(WIDTH, HEIGHT);
		frame.add(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		LeagueInvaders main = new LeagueInvaders();
		main.setup();
	}

}
