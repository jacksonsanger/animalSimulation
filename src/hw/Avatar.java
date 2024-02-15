package hw;

public abstract class Avatar implements Drawable {

	// The current position of the avatar on the grid
	protected GridPoint location;
	
	// The avatar also has access to the terrainMap
	protected TerrainMap tm;

	protected Avatar(TerrainMap tm, GridPoint location) {
		this.location = location;
		this.tm = tm;
	}	
	
	// This moves one step along path
	// Everyone moves differently
	public abstract void move();
		
}

