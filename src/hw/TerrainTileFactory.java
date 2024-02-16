package hw;

public class TerrainTileFactory {
	
	public static TerrainTile newTerrainTile(String tileStr, GridPoint loc) throws InvalidTerrainTypeException {
		
		TerrainTile tt;
		
		if (tileStr.equalsIgnoreCase("g")) {
			tt = new Grass(loc);
		} else if (tileStr.equalsIgnoreCase("r")) {
			tt = new Road(loc);
		} else if (tileStr.equalsIgnoreCase("m")) {
			tt = new Mountain(loc);
		} else if (tileStr.equalsIgnoreCase("w")) {
			tt = new Water(loc);
		} else {
			throw new InvalidTerrainTypeException("Bad terrain type " + tileStr);
		}

		return tt;
	}

}
