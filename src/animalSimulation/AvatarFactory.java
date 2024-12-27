package animalSimulation;

public class AvatarFactory {

	public static Avatar newAvatar(String avaName, TerrainMap tm, GridPoint loc) throws BadAvatarException {
		Avatar avatar;
		if (avaName.equalsIgnoreCase("Human")) {
			avatar = new Human(tm, loc);
		}
		else if(avaName.equalsIgnoreCase("Duck")) {
			avatar = new Duck(tm, loc);
		}
		else if(avaName.equalsIgnoreCase("Cow")) {
			avatar = new Cow(tm, loc);
		}
		else if(avaName.equalsIgnoreCase("Goat")) {
			avatar = new Goat(tm, loc);
		}
		else {
			throw new BadAvatarException("No avatar named: " + avaName);
		}

		return avatar;
	}
}
