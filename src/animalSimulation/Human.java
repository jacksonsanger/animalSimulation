package animalSimulation;

import java.util.ArrayList;
import java.util.Random;

import edu.du.dudraw.Draw;

public class Human extends Avatar implements Drawable{
	
	//random variable to introduce random movement to tiles that are only road
	private Random random;
	//movement buffer, humans are on the slower end, so they will only move every three steps
	private int movementBuffer = 0;

	protected Human(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.random = new Random();
	}

	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height = SimWindow.windowHeight/TerrainMap.gridHeight;
		duDwin.picture((location.getX() * width) + (width/2), ((location.getY() * height) + (height/2)), "images/human.png", width, height);
	}
	
    public void move() {
    	if(movementBuffer % 3 == 0) {
	        ArrayList<GridPoint> options = location.getNeighbors(1);
	        // Filter out the non-road tiles
	        options.removeIf(neighbor -> tm.getBumpy(neighbor) != 0);
	
	        // If there are road options, choose one at random
	        if (!options.isEmpty()) {
	            int randomIndex = random.nextInt(options.size()); // Select a random index
	            location = options.get(randomIndex); // Move to the selected road tile
	        }
	        // If there are no road options, the human will not move
    	}
    	movementBuffer ++;
    }
}
