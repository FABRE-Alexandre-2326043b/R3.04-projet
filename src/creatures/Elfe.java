package creatures;

public class Elfe extends Creature{
	public void demoraliser(Creature creature) {
		creature.tomberMalade(this.getListeMaladies().get((int)(Math.random()*this.getListeMaladies().size())));
	}
}
