import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean gotbg = false;
	public static boolean needbg = true;
	final static int MENU = 0;
	final static int GAME = 1;
	final static int END = 2;
	static int currentState = MENU;
	static int killed = 0;
	Font titleFont;
	Timer frameDraw;
	Font textFont;
	static Rocketship rocket;
	static ObjectManager OM;
	static Timer alienSpawn;

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		textFont = new Font("Arial", Font.PLAIN, 24);
		frameDraw = new Timer(1000 / 60, this);
		rocket = new Rocketship(250, 700, 50, 50);
		frameDraw.start();
		OM = new ObjectManager(rocket);
		if(needbg) {
			loadImage("space.png");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);

		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 23, LeagueInvaders.HEIGHT / 8);
		g.setFont(textFont);
		g.drawString("Press ENTER to start", 135, LeagueInvaders.HEIGHT / 2);
		g.drawString("Press SPACE for instructions", 95, LeagueInvaders.HEIGHT * 3 / 4);
	}

	public void drawGameState(Graphics g) {
		if(gotbg) {
			g.drawImage(image, 0,0,LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		}else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		OM.update();
		OM.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, LeagueInvaders.HEIGHT / 8);
		g.setFont(textFont);
		g.drawString("You killed " + killed + " enemies!", 135, LeagueInvaders.HEIGHT / 2);
		g.drawString("Press ENTER to restart!", 115, LeagueInvaders.HEIGHT * 3 / 4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}

		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			
			} else {
				if(currentState != GAME) {
					currentState++;
					currentState %= 3;
				}
			}
			if(currentState == GAME) {
				startGame();
			}
//			else if(currentState == END) {
//				killed = OM.getScore();
//				alienSpawn.stop();
//				rocket = new Rocketship(250, 700, 50, 50);
//				OM = new ObjectManager(rocket);
//			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (currentState == GAME) {
				rocket.movingUp = true;
//				if (rocket.y - rocket.speed >= 0) {
//					rocket.up();
//				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (currentState == GAME) {
				rocket.movingDown = true;
//				if (rocket.y + rocket.speed + rocket.height <= LeagueInvaders.HEIGHT - 30) {
//					rocket.down();
//				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if (currentState == GAME) {
				rocket.movingLeft = true;
//				if (rocket.x - rocket.speed >= 0) {
//					rocket.left();
//				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			if (currentState == GAME) {
				rocket.movingRight = true;
//				if (rocket.x + rocket.speed + rocket.width <= LeagueInvaders.WIDTH) {
//					rocket.right();
//				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			OM.addProjectile(rocket.getProjectile());
		}

	}
	public void loadImage(String imageFile) {
		if (needbg) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotbg = true;
			} catch (Exception e) {

			}
			needbg = false;
		}
	}
	public void startGame() {
		alienSpawn = new Timer(1000 , OM);
	    alienSpawn.start();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (currentState == GAME) {
				rocket.movingUp = false;
			}}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if(currentState == GAME) {
				rocket.movingDown = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if(currentState == GAME) {
				rocket.movingLeft = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			if(currentState == GAME) {
				rocket.movingRight = false;
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public static void restart() {
		killed = OM.getScore();
		alienSpawn.stop();
		rocket = new Rocketship(250, 700, 50, 50);
		OM = new ObjectManager(rocket);

	}
}
