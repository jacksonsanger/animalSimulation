# Animal Simulation

A Java-based 2D simulation that models animal behavior within a virtual world. The project includes terrain tiles, custom animal avatars with unique movement behaviors, and interactions between animals and the environment.

## Features

- **Virtual World Terrain:**
  - Terrain tiles represented by Grass, Water, Roads, and Mountains.
  - Vegetation levels for Grass and Mountains dynamically updated based on animal interactions.
  - Custom exceptions for handling invalid or malformed terrain files.

- **Animal Avatars:**
  - Multiple animal types, including a Human avatar restricted to Roads.
  - Distinct movement behaviors, such as targeting water or alternating between modes (e.g., flying and swimming).
  - Behavior-planning logic that evaluates both immediate neighbors and tiles further out.

- **Factory Design Patterns:**
  - `TerrainTileFactory` for creating terrain tiles.
  - `AvatarFactory` for instantiating animal avatars.

- **Grid-Based Navigation:**
  - GridPoint class for managing tile locations and neighbor detection.

## Installation

1. Open the project in your preferred Java IDE (e.g., Eclipse).
2. Ensure you have the `DuDraw` library added to your classpath.
3. Compile and run the `Main` class to start the simulation.

## How It Works

1. **Terrain Parsing:**
   - The program loads a terrain map from a file and validates its format using custom exceptions.
      - Each tile type is rendered with unique colors based on vegetation levels.

2. **Avatar Simulation:**
   - Avatars move across the map with behaviors determined by their specific implementations.
      - Interactions include consuming vegetation and dynamically changing their movement patterns.

3. **Dynamic Simulation:**
   - Terrain and avatars are redrawn at regular intervals using the `DuDraw` library.
      - The simulation window dynamically updates, showing terrain and avatar states in real time.

## Project Structure

- `src/`
  - **GridPoint**: Represents tile locations and provides neighbor detection.
    - **TerrainTile**: Abstract class for terrain tiles with Grass, Water, Roads, and Mountains as subclasses.
      - **Avatar**: Abstract class for animal avatars with specific movement and interaction behaviors.
        - **Factories**:
	    - `TerrainTileFactory`: Creates terrain tiles based on file input.
	        - `AvatarFactory`: Instantiates avatars with specific behaviors.
		  - **SimWindow**: Manages the graphical interface and simulation loop.

## Future Enhancements

- Add more animal types with complex behaviors.
- Introduce additional terrain properties, such as weather or obstacles.
- Implement a scoring system based on avatar activities.