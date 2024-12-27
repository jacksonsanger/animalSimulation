package animalSimulation;

import java.util.ArrayList;

import edu.du.dudraw.Draw;
import java.util.Random;

public class Cow extends AvatarThatEats implements Drawable{
	//add in a simple int variable, the cow will only move if this number is a multiple of 5, so it will move every 5 steps
	private int movementBuffer = 0;
	private Random random;

	protected Cow(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.random = new Random();
		
	}

	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height = SimWindow.windowHeight/TerrainMap.gridHeight;
		duDwin.picture((location.getX() * width) + (width/2), ((location.getY() * height) + (height/2)), "images/cow.png", width, height);
	}

	//cows are lazy, so they only move every 5 steps. They also only move diagonally
    public void move() {
        // Only move if the movementBuffer is a multiple of 5
        if (movementBuffer % 5 == 0) {

	        ArrayList<GridPoint> neighbors = location.getNeighbors(1);
	        ArrayList<GridPoint> diagonalNeighbors = new ArrayList<GridPoint>();
	
	        // Filter for diagonal neighbors
	        for (GridPoint neighbor : neighbors) {
	            if (Math.abs(neighbor.getX() - location.getX()) == 1 && Math.abs(neighbor.getY() - location.getY()) == 1) {
	                diagonalNeighbors.add(neighbor);
	            }
	        }
	        
            // Move to a random diagonal position
            GridPoint newLocation = diagonalNeighbors.get(random.nextInt(diagonalNeighbors.size()));
            location = newLocation; // Update the cow's location

            // If the new location has vegetation, eat it
            if (tm.getVeg(newLocation) > 0) {
                eat(20);
            }
        }
        //increment movementBuffer after each step
        movementBuffer ++;
    }

	@Override
	//Call the eat method for the current location of the cow
	public void eat(int amt) {
		tm.theTiles.get(location).eat(amt);
		
	}
	

}
