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


	public ObjectManager(Rocketship rocketship) {
		rocket = rocketship;
	}
	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}
	public void update() {
		for(Alien a: aliens) {
			a.update();
			if(a.y + a.height > LeagueInvaders.HEIGHT - 30) {
				a.isActive = false;
			}
		}
		for(Projectile p: projectiles) {
			p.update();
			if(p.y + p.height < LeagueInvaders.HEIGHT) {
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
	}
	public void checkCollision() {
		for(Alien a: aliens) {
			for(Projectile p: projectiles) {
				if (p.collisionBox.intersects(a.collisionBox) && p.isActive == true && a.isActive == true){
					a.isActive = false;
					p.isActive = false;
				}
			}
			if(rocket.collisionBox.intersects(a.collisionBox) && rocket.isActive == true && a.isActive == true) {
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
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		addAlien();		
	}

}
