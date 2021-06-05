package Classes.Pokemons.PokemonTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FireTypeTests {

    private FireType pokemonDeFireType;
    private FireType pokemonDeFireType2;
    private FireType pokemonDeFireType3;
    private WaterType pokemonDeWaterType;
    private PlantType pokemonDePlantType;

    @BeforeEach
    void setUp() throws Exception {
        pokemonDeFireType = new FireType("miguelito", "Charizard", 10.0, 5.0, 100);
        pokemonDeFireType2 = new FireType("miguelote", "Charizard", 10.0, 5.0, 100);
        pokemonDeFireType3 = new FireType("miguelotex", "Charizard", 10.0, 5.0, 100);
        pokemonDePlantType = new PlantType("filip", "plantatype", 10.0, 5.0, 100);
        pokemonDeWaterType = new WaterType("derek", "watertype", 10.0, 5.0, 100);
    }

    @Test
    void fuego(){
        assertEquals(pokemonDeFireType.getName(), "miguelito");
        assertEquals(pokemonDeFireType2.getName(), "miguelote");
        assertEquals(pokemonDeFireType.getSpecie(), "Charizard");
        assertEquals(pokemonDeFireType2.getSpecie(), "Charizard");
    }

    @Test
    void attack() {
        pokemonDeFireType.Attack(pokemonDeWaterType);
        pokemonDeFireType.Attack(pokemonDeFireType2);
        pokemonDeFireType.Attack(pokemonDePlantType);
        assertEquals(pokemonDeWaterType.getCurrentHP(), 5.0, "Water type After being attacked by a fire type Health should be 5");
        assertEquals(pokemonDePlantType.getCurrentHP(), 0.0, "Plant type After being attacked by a fire type Health should be 0");
        assertEquals(pokemonDeFireType2.getCurrentHP(), 5.0, "Fire type After being attacked by a fire type Health should be 5");
    }

    @Test
    void isKO() {
        pokemonDeWaterType.Attack(pokemonDeFireType2);
        assertEquals(pokemonDeFireType2.isKO(), true, "If pokemonDeFuego2's health is 0, isKO() should be true");
    }
}