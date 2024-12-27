package animalSimulation;

import java.util.ArrayList;

// My own point class to hold points in grid coords
// java.awt.Point also works, but for practice have
//   the students make their own
// Needs a equals to work with ArrayList
// Needs a hashCode to work with HashMap - also need equals for this
// I don't believe I need a compareTo since I'm not sorting
//   or using a tree structure with gridpoints
public class GridPoint {
	private int x;
	private int y;
	
	public GridPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public boolean equals(Object o) {
		if(o instanceof GridPoint) {
			GridPoint gp = (GridPoint) o;
			return ((this.x == gp.x) && (this.y == gp.y));
		}
		else{
			return false;
		}	
	}
	
	public int hashCode() {
		return x*y;
	}
	
	public ArrayList<GridPoint> getNeighbors(int levels) {
	    ArrayList<GridPoint> a1 = new ArrayList<>();
	    // Only consider points that are exactly 'levels' steps away in at least one axis.
	    for (int dx = -levels; dx <= levels; dx++) {
	        for (int dy = -levels; dy <= levels; dy++) {
	            int newX = x + dx;
	            int newY = y + dy;
	            // Skip the current point itself
	            if (dx == 0 && dy == 0) continue;
	            // Only add points that are 'levels' steps away in at least one dimension
	            if ((Math.abs(dx) == levels || Math.abs(dy) == levels) && newX >= 0 && newX < TerrainMap.gridWidth && newY >= 0 && newY < TerrainMap.gridHeight) {
	                a1.add(new GridPoint(newX, newY));
	            }
	        }
	    }
	    return a1;
	}

}
