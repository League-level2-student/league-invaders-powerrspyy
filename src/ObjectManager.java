import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
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
	

}
