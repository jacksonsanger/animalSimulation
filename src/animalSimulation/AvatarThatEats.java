package animalSimulation;

public abstract class AvatarThatEats extends Avatar {

	public AvatarThatEats(TerrainMap tm, GridPoint gp) {
		super(tm, gp);
	}
	
	//these animals will eat
	public abstract void eat(int amt);

}
