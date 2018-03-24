package player;
/**
 * 
 * @author François-Laurent
 *
 */
public class Action {
	
	public void dormir(Player player) {
		
		player.setEnergy(player.getEnergy()+50);
		player.setHealth(player.getHealth()+5);
	}
	
	public void manger(Player player) {
		
		player.setHealth(player.getHealth()+5);
	}
	
	public void douche(Player player) {
		
		player.setHygiene(player.getHygiene()+20);
	}
	
	public void sport(Player player) {
		
		player.setHygiene(player.getHygiene()-7);
		player.setEnergy(player.getEnergy()-10);
	}
	
	public void travailler (Player player) {
		player.setHumeur(player.getHumour()-10);
		player.setHygiene(player.getHygiene()-2);
		player.setEnergy(player.getEnergy()-5);
	}
	
	
}
