package player;

import utility.Health;
import utility.Pair;

public class Prova {

	public static void main(String[] args) {
		PlayerImpl player =  new PlayerImpl(1, null);
		Health health = new HealthPlayerImpl(player.getHealth());

		System.out.println("VITA DEFAULT: " +player.getHealth());
		int vita1 = health.getCurrentHealth();
		System.out.println("VITA attuale : " +vita1);
		
		int vita2 = health.getMaxHealth();
		System.out.println("VITA massima : " +vita2);
		
		health.takeDmg(30);
		int vita3 = health.getCurrentHealth();
		System.out.println("VITA dopo danno -30 : " +vita3);
		
		int vita4 = player.getHealth();
		System.out.println("VITA 4 : " +vita4);
		


	}

}
