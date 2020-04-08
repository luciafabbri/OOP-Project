package player;

import utility.Health;
import utility.Pair;

public class Prova {

	public static void main(String[] args) {
		PlayerImpl player =  new PlayerImpl(new Pair<>(0,0), null, 1, null);
		Health health = player.getHealth();

		System.out.println("VITA DEFAULT: " +health.getMaxHealth());
		System.out.println(health.getCurrentHealth());
		
		int vita2 = health.getMaxHealth();
		System.out.println("VITA massima : " +vita2);
		
		health.takeDmg(30);
		int vita3 = health.getCurrentHealth();
		System.out.println("VITA dopo danno -30 : " +vita3);

		System.out.println("VITA totale iniziale: " +health.getCurrentHealth());

		System.out.println("VITA totale iniziale: " +health.getMaxHealth());
		health.takeDmg(70);
		System.out.println("VITA dopo danno -70: " +health.getCurrentHealth());
		boolean yes =health.isAlive(health.getCurrentHealth());
		if (yes) {
			System.out.println("yes");
		}
		else {
			System.out.println("NO");

		}
		

	}

}
