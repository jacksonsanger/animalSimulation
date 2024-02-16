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

		try {

		 // TODO: Make the avatars
		 // Remember (0,0) is in the lower left corner
			Avatar human = AvatarFactory.newAvatar("human", tm, new GridPoint(2, 0));
			// add two ducks to show off differing behavior
			Avatar duck = AvatarFactory.newAvatar("duck", tm, new GridPoint(20, 15));
			Avatar duck2 = AvatarFactory.newAvatar("duck", tm, new GridPoint(10, 15));
			Avatar cow = AvatarFactory.newAvatar("cow", tm, new GridPoint(6, 6));
			Avatar goat = AvatarFactory.newAvatar("goat", tm, new GridPoint(11, 4));
			tp.addAvatar(human);
			tp.addAvatar(duck);
			tp.addAvatar(duck2);
			tp.addAvatar(cow);
			tp.addAvatar(goat);
		
		} catch (BadAvatarException e) {
			e.printStackTrace();
			return;
		}

		// Start the simulation
		tp.runSimulation();
	}

}
