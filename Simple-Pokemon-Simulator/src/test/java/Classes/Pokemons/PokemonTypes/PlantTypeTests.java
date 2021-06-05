package Classes.Pokemons.PokemonTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantTypeTests {

    private PlantType pokemonDePlantType;
    private PlantType pokemonDePlantType2;
    private PlantType pokemonDePlantType3;
    private WaterType pokemonDeWaterType;
    private FireType pokemonDeFireType;

    @BeforeEach
    void setUp() throws Exception {
        pokemonDePlantType = new PlantType("filip", "plantatype", 10.0, 5.0, 100);
        pokemonDePlantType2 = new PlantType("filip2", "plantatype", 10.0, 5.0, 100);
        pokemonDePlantType3 = new PlantType("filip3", "plantatype", 10.0, 5.0,100);
        pokemonDeFireType = new FireType("miguelito", "Charizard", 10.0, 5.0, 100);
        pokemonDeWaterType = new WaterType("derek", "watertype", 10.0, 5.0, 100);
    }

    @Test
    void Planta(){
        assertEquals(pokemonDePlantType.getName(), "filip");
        assertEquals(pokemonDePlantType2.getName(), "filip2");
        assertEquals(pokemonDePlantType.getSpecie(), "plantatype");
        assertEquals(pokemonDePlantType2.getSpecie(), "plantatype");
    }

    @Test
    void attack() {
        pokemonDePlantType.Attack(pokemonDeWaterType);
        pokemonDePlantType.Attack(pokemonDePlantType2);
        pokemonDePlantType.Attack(pokemonDeFireType);
        assertEquals(pokemonDeWaterType.getCurrentHP(), 0.0, "Water type After being attacked by a plant type Health should be 5");
        assertEquals(pokemonDePlantType2.getCurrentHP(), 5.0, "Plant type After being attacked by a plant type Health should be 0");
        assertEquals(pokemonDeFireType.getCurrentHP(), 5.0, "Fire type After being attacked by a plant type Health should be 5");
    }

    @Test
    void attackedFrom() {
        pokemonDeFireType.Attack(pokemonDePlantType);
        assertEquals(pokemonDePlantType.isKO(), true, "If pokemonDePlanta's health is 0, isKO() should be true");
    }
}