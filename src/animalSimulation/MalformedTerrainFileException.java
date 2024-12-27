package animalSimulation;

public class MalformedTerrainFileException extends TerrainFileException {

	public MalformedTerrainFileException() {
	}

	public MalformedTerrainFileException(String message) {
		super(message);
	}

	public MalformedTerrainFileException(Throwable cause) {
		super(cause);
	}

	public MalformedTerrainFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public MalformedTerrainFileException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
