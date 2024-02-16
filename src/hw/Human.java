package hw;

import java.util.ArrayList;

import edu.du.dudraw.Draw;

public class Human extends Avatar implements Drawable{
	
	//extra attribute to track the last location so that the human can move more easily only on roads
	
	protected GridPoint lastLocation;  

	protected Human(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.lastLocation = null;
	}

	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height = SimWindow.windowHeight/TerrainMap.gridHeight;
		duDwin.picture((location.getX() * width) + (width/2), ((location.getY() * height) + (height/2)), "images/human.png", width, height);
	}
	
    public void move() {
        ArrayList<GridPoint> options = location.getNeighbors(1);
        // Filter out the non-road tiles and the last location to avoid backtracking
        options.removeIf(neighbor -> !isRoad(neighbor) || neighbor.equals(lastLocation));

        if (options.size() > 0) {
            // Select the next move from the available road options
            location = options.get(0); // This could be a more sophisticated selection if needed
            lastLocation = location;
        } else if (isRoad(lastLocation)) {
            // If no other option, move back to the last location if it's a road
            location = lastLocation;
            lastLocation = null; // Clear the last location as we're backtracking
        }
    }

    private boolean isRoad(GridPoint point) {
        return tm.getBumpy(point) == 0;
    }
}
