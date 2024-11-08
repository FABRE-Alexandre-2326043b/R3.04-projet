package creatures;

public class Orque extends Creature{
	public void contaminer(Creature creature) {
		creature.tomberMalade(this.getListeMaladies().get((int)(Math.random()*this.getListeMaladies().size())));
	}
}
