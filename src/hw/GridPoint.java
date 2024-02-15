package hw;

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
		GridPoint gp = (GridPoint) o;
		return ((this.x == gp.x) && (this.y == gp.y));
	}
	
	public int hashCode() {
		return x*y;
	}
	
	public ArrayList<GridPoint> getNeighbors(int levels) {
		ArrayList<GridPoint> al = new ArrayList<GridPoint>();
		//TODO: neighbor finding code
		return al;
	}
}
