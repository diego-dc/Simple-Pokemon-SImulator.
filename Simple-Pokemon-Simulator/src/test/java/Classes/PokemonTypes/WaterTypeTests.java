package Classes.PokemonTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class WaterTypeTests {
    private WaterType pokemonDeWaterType;
    private WaterType pokemonDeWaterType2;
    private WaterType pokemonDeWaterType3;
    private PlantType pokemonDePlantType;
    private FireType pokemonDeFireType;

    @BeforeEach
    void setUp() throws Exception {
        pokemonDeWaterType = new WaterType("derek", "watertype", 10.0, 5.0);
        pokemonDeWaterType2 = new WaterType("derek2", "watertype", 10.0, 5.0);
        pokemonDeWaterType3 = new WaterType("derek3", "watertype", 10.0, 5.0);
        pokemonDeFireType = new FireType("miguelito", "Charizard", 10.0, 5.0);
        pokemonDePlantType = new PlantType("filip", "plantatype", 10.0, 5.0);
    }

    @Test
    void fuego(){
        assertEquals(pokemonDeWaterType.getName(), "derek");
        assertEquals(pokemonDeWaterType2.getName(), "derek2");
        assertEquals(pokemonDeWaterType.getSpecie(), "watertype");
        assertEquals(pokemonDeWaterType2.getSpecie(), "watertype");
    }

    @Test
    void attack() {
        pokemonDeWaterType.Attack(pokemonDePlantType);
        pokemonDeWaterType.Attack(pokemonDeWaterType2);
        pokemonDeWaterType.Attack(pokemonDeFireType);
        assertEquals(pokemonDeWaterType2.getHp(), 5, "Water type After being attacked by a water type Health should be 5");
        assertEquals(pokemonDePlantType.getHp(), 5, "Plant type After being attacked by a water type Health should be 0");
        assertEquals(pokemonDeFireType.getHp(), 0, "Fire type After being attacked by a water type Health should be 5");
    }

    @Test
    void attackedFrom() {
        pokemonDePlantType.Attack(pokemonDeWaterType3);
        assertEquals(pokemonDeWaterType3.isKO(), true, "If pokemonDeAgua3's health is 0, isKO() should be true");
    }
}
