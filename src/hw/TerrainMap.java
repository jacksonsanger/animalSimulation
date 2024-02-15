package hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import edu.du.dudraw.Draw;

// The TerrainMap consists of a 2D grid of Tiles

public class TerrainMap implements Drawable {
	// Instead of having the tiles stored in a 2d array
	//   we will have them stored in a Map so we can make
	//   use of the tile's hashCode
	// This won't be any faster than a 2d array - and might
	//   actually be more complex than it, but it is a good
	//   academic exercise.
	// Note the use of HashMaps forces GridPoint to have a hashCode
	// I did leave the older 2d array code in but commented...
	//private TerrainTile[][] theTiles;
	Map<GridPoint, TerrainTile> theTiles;

	// public static constants set by the file reader
	public static int gridWidth;
	public static int gridHeight;

	// Constructor to read from file
	public TerrainMap(String filename) throws IOException, TerrainFileException
	{
		// Do it with a bufferedReader line by line
		// Then a String Tokenizer
		// Could probably use a Scanner as well
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		// Read in the width
		String widthHeight = br.readLine();
		StringTokenizer st = new StringTokenizer(widthHeight);
		
		int width, height;
		
		try {
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
		}
		catch(NumberFormatException e) {
			throw new MalformedTerrainFileException("unable to parse: " + widthHeight, e);
		}

		//theTiles = new TerrainTile[width][height];
		theTiles = new HashMap<GridPoint, TerrainTile>();

		// Now read the info (row by row)
		// Since 0,0 is in lower corner in DuDraw
		//   read the heights in upside down
		for (int y=height-1; y>=0; y--) {
			String currentRow = br.readLine();
			st = new StringTokenizer(currentRow);
			for (int x=0; x<width; x++) {

				String currentTile = st.nextToken();

				// Make a GridPoint for the coords read in
				GridPoint loc = new GridPoint(x,y);
				
				TerrainTile tt;
				
				if (currentTile.equalsIgnoreCase("g")) {
					tt = new Grass(loc);
				} else if (currentTile.equalsIgnoreCase("r")) {
					tt = new Road(loc);
				} else if (currentTile.equalsIgnoreCase("m")) {
					tt = new Mountain(loc);
				} else if (currentTile.equalsIgnoreCase("w")) {
					tt = new Water(loc);
				} else {
					throw new InvalidTerrainTypeException("Bad terrain type " + currentTile);
				}

				// Factory method
				theTiles.put(loc, tt);
				


			}
		}

		// Set the static variables so other will know
		TerrainMap.gridWidth = width;
		TerrainMap.gridHeight = height;

		br.close();	
	}

	// To enable the Board to draw itself on the given Graphics
	public void draw(Draw duDwin) {
		// 2d array version
		//		for (int x=0; x<theTiles.length; x++) {
		//			for (int y=0; y<theTiles[0].length; y++) {
		//				theTiles[x][y].draw(duDwin);
		//			}
		//		}
		// Map version
		// Get the keys
		for(TerrainTile tile : theTiles.values()) {
			tile.draw(duDwin);
		}
	}

	// Methods to get access to the individual tiles
	//   veg, wet, bumpy, and eat methods
	public int getVeg(GridPoint position) {		
		return 0;
	}

	public int getWet(GridPoint position) {
		return 0;
	}

	public int getBumpy(GridPoint position) {
		return 0;
	}

	public void eat(GridPoint position, int amt) {

	}
}
