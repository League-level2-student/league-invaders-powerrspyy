import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Timer frameDraw;
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
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
		g.drawString("LEAGUE INVADERS", 23, LeagueInvaders.HEIGHT/8);
	}

	public void drawGameState(Graphics g) {

	}

	public void drawEndState(Graphics g) {

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
		
		System.out.println("action");
		repaint();
		
	}
}
