package hw;

import edu.du.dudraw.Draw;

public class Duck extends Avatar implements Drawable{

	protected Duck(TerrainMap tm, GridPoint location) {
		super(tm, location);
	}

	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height = SimWindow.windowHeight/TerrainMap.gridHeight;
		duDwin.picture((location.getX() * width) + (width/2), ((location.getY() * height) + (height/2)), "images/duckFly.png", width, height);
	}

	public void move() {		
	}
	

}
