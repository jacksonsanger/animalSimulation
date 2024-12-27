package animalSimulation;

public class InvalidTerrainTypeException extends TerrainFileException {

	public InvalidTerrainTypeException() {
	}

	public InvalidTerrainTypeException(String message) {
		super(message);
	}

	public InvalidTerrainTypeException(Throwable cause) {
		super(cause);
	}

	public InvalidTerrainTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTerrainTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
