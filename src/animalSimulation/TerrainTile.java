package animalSimulation;

import edu.du.dudraw.Draw;

// This is an abstract class
public abstract class TerrainTile implements Drawable {
	
	// Every tile has a location
	private GridPoint location;
	
	protected TerrainTile (GridPoint location) {
		this.location = location;
	}

	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height = SimWindow.windowHeight/TerrainMap.gridHeight;
		
		System.out.println("x="+(location.getX()*width) + (width/2));
		System.out.println("y="+(location.getY()*height) + (height/2));
		// Each concrete tile will set its own color
		setColor(duDwin);
	
		// We draw all the rectangles the same once the color has been set
		duDwin.filledRectangle((location.getX()*width) + (width/2), (location.getY()*height) + (height/2), width/2, height/2);
	}
	
	// Part of the draw template for concrete tiles to set the color
	public abstract void setColor(Draw duDwin);
	
	// Allows tiles to provide different information
	//   on the vegetation, smoothness, and water content to tile 
	public abstract int getVeg();
	public abstract int getBumpy();
	public abstract int getWet();
	
	// Allows an avatar to eat at this tile
	public void eat(int amt) {
		// Do nothing by default
	}
	
}
