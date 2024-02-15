package hw;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		// Load in the map
		TerrainMap tm;
		try {
			tm = new TerrainMap("map1.txt");
		} catch (TerrainFileException e) {
			System.out.println("Unable to parse terrain map: " + e.getMessage());
			e.printStackTrace();
			return;
		}
		catch(IOException e) {
			System.out.println("Trouble reading terrain map file: " + e.getMessage());
			e.printStackTrace();
			return;
		}

		// Make the display panel
		SimWindow tp = new SimWindow(tm);

//		try {
//
		// TODO: Make the avatars
		// Remember (0,0) is in the lower left corner
//		
//		} catch (BadAvatarException e) {
//			e.printStackTrace();
//			return;
//		}

		// Start the simulation
		tp.runSimulation();
	}

}
