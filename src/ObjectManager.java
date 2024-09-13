import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener {
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<>();
ArrayList<Alien> aliens = new ArrayList<>();
Random random = new Random();
Integer score;
Font titleFont = new Font("Arial", Font.PLAIN, 22);



	public ObjectManager(Rocketship rocketship) {
		rocket = rocketship;
		score = 0;
	}
	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}
	public void update() {
		rocket.update();
		checkCollision();
		purgeObjects();
		for(Alien a: aliens) {
			a.update();
			if(a.y + a.height > LeagueInvaders.HEIGHT - 30) {
				a.isActive = false;
			}
		}
		for(Projectile p: projectiles) {
			p.update();
			if(p.y + p.height < 0) {
				p.isActive = false;
			}
			
		}
	}
	public void draw(Graphics g) {
		rocket.draw(g);
		for(Alien a: aliens) {
			a.draw(g);
		}
		for(Projectile p: projectiles) {
			p.draw(g);
		}
		drawScore(g);
		
		
	}
	public void checkCollision() {
		for(Alien a: aliens) {
			for(Projectile p: projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)){// && p.isActive == true && a.isActive == true
					a.isActive = false;
					p.isActive = false;
					score += 1;
				}
			}
			if(rocket.collisionBox.intersects(a.collisionBox)) {// && rocket.isActive == true && a.isActive == true
				a.isActive = false;
				rocket.isActive = false;
			}
		}
	}
	public void purgeObjects() {
		Iterator<Alien> iterA = aliens.iterator();
		while(iterA.hasNext()) {
			Alien a = iterA.next();
			if(!a.isActive) {
				iterA.remove();
			}
		}
		Iterator<Projectile> iterP = projectiles.iterator();
		while(iterP.hasNext()) {
			Projectile p = iterP.next();
			if(!p.isActive) {
				iterP.remove();
			}
		}
		if(rocket.isActive == false) {
			GamePanel.currentState = GamePanel.END;
			GamePanel.restart();
		}
	}
	public int getScore() {
		return score;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		addAlien();		
	}
	public void drawScore(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("Score: " + score, 10,10);
	}


}
