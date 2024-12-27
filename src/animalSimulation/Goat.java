package animalSimulation;

import java.util.ArrayList;
import java.util.Comparator;

import edu.du.dudraw.Draw;

public class Goat extends AvatarThatEats implements Drawable{

	protected Goat(TerrainMap tm, GridPoint location) {
		super(tm, location);
	}

	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height = SimWindow.windowHeight/TerrainMap.gridHeight;
		duDwin.picture((location.getX() * width) + (width/2), ((location.getY() * height) + (height/2)), "images/mgoat.png", width, height);
	}
	
	
	public void move() {
        ArrayList<GridPoint> options = location.getNeighbors(2);
        
        // Filter out the current location
        options.remove(location);

        // Now, sort the options based on the amount of vegetation, descending
        options.sort(Comparator.comparingInt((GridPoint o) -> tm.getVeg(o)).reversed());

        // Move to the tile with the most vegetation if there is any
        for (GridPoint potentialMove : options) {
            if (tm.getVeg(potentialMove) > 0) {
                location = potentialMove; // Update the goat's location to the new tile with most vegetation
                break; // Break after moving
            }
        }

        // If the goat moved, eat from the new tile
        if (tm.getVeg(location) > 0) {
            eat(20);
        }
    }

	@Override
	//Call the eat method for the current location of the goat
	public void eat(int amt) {
		tm.theTiles.get(location).eat(amt);
		
	}
	
}
