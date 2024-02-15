package hw;

import java.awt.Color;

import edu.du.dudraw.Draw;

public class Grass extends TerrainTile {
	
	private int veg;
	
	public Grass(GridPoint location) {
		super(location);
		
		// Grass starts as full of vegetation
		veg = 100;
	}
	
	@Override
	public void setColor(Draw duDwin) {
		// veg is between 0..100
		// make vegcolor between 150..250
		int vegColor = 250-veg; 

		duDwin.setPenColor(new Color(0,vegColor,0));
	}

	@Override
	public int getVeg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBumpy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWet() {
		// TODO Auto-generated method stub
		return 0;
	}


}
