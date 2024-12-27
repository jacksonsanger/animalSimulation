package animalSimulation;

import java.util.ArrayList;
import java.util.Random;

import edu.du.dudraw.Draw;

public class Duck extends Avatar implements Drawable{
	
	//flag to determine if the duck should be drawn flying or not
	private boolean flyingState = false;
	//movement Buffer, ducks are faster than humans, but slower than goats. They will only move every 2 steps
	private int movementBuffer = 0;
	private Random random;

	protected Duck(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.random = new Random();
	}

	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height = SimWindow.windowHeight/TerrainMap.gridHeight;
		// draw one of two images depending on if the duck is flying or not
		if(!flyingState) {
			duDwin.picture((location.getX() * width) + (width/2), ((location.getY() * height) + (height/2)), "images/duck.png", width, height);
		}
		else {
			duDwin.picture((location.getX() * width) + (width/2), ((location.getY() * height) + (height/2)), "images/duckFly.png", width, height);
		}
	}
	
	//ducks will look one level deep for water. Their movement is designed so that once they find water, they will stay there
	public void move() {	
		if(movementBuffer % 2 == 0) {
			// Check if the current tile is water
	        if (tm.getWet(location) != 100) {
	            flyingState = true; // Duck is not on water, so set flyingState to true
	        } else {
	            flyingState = false; // Duck is on water, so set flyingState to false
	        }
	        //Get the neighbors
	        ArrayList<GridPoint> options = location.getNeighbors(1);
	        // Filter for water tiles
	        ArrayList<GridPoint> waterTiles = new ArrayList<>();
	        for (GridPoint option : options) {
	            if (tm.getWet(option) == 100) {
	                waterTiles.add(option);
	            }
	        }
	        if (!waterTiles.isEmpty()) {
	            // If there are water tiles, randomly select one to move to
	            int index = random.nextInt(waterTiles.size());
	            location = waterTiles.get(index); // Move to the selected water tile
	        }
	        //otherwise, choose a random tile from neighbors to move to
	        else {
	        	int index = random.nextInt(options.size());
	        	location = options.get(index);
	        }
		}
		movementBuffer ++;
	}
	

}
