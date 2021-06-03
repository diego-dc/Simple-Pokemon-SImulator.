package PokemonTypesTests;
import Classes.PokemonTypes.Agua;
import Classes.PokemonTypes.Fuego;
import Classes.PokemonTypes.Planta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class WaterTypeTests {
    private Agua pokemonDeAgua;
    private Agua pokemonDeAgua2;
    private Agua pokemonDeAgua3;
    private Planta pokemonDePlanta;
    private Fuego pokemonDeFuego;

    @BeforeEach
    void setUp() throws Exception {
        pokemonDeAgua = new Agua("derek", "watertype", 10);
        pokemonDeAgua2 = new Agua("derek2", "watertype", 10);
        pokemonDeAgua3 = new Agua("derek3", "watertype", 10);
        pokemonDeFuego = new Fuego("miguelito", "Charizard", 10);
        pokemonDePlanta = new Planta("filip", "plantatype", 10);
    }

    @Test
    void fuego(){
        assertEquals(pokemonDeAgua.getName(), "derek");
        assertEquals(pokemonDeAgua2.getName(), "derek2");
        assertEquals(pokemonDeAgua.getSpecie(), "watertype");
        assertEquals(pokemonDeAgua2.getSpecie(), "watertype");
    }

    @Test
    void attack() {
        pokemonDeAgua.Attack(pokemonDePlanta);
        pokemonDeAgua.Attack(pokemonDeAgua2);
        pokemonDeAgua.Attack(pokemonDeFuego);
        assertEquals(pokemonDeAgua2.getHp(), 5, "Water type After being attacked by a water type Health should be 5");
        assertEquals(pokemonDePlanta.getHp(), 5, "Plant type After being attacked by a water type Health should be 0");
        assertEquals(pokemonDeFuego.getHp(), 0, "Fire type After being attacked by a water type Health should be 5");
    }

    @Test
    void attackedFrom() {
        pokemonDeAgua.AttackedFromFire();
        pokemonDeAgua2.AttackedFromWater();
        pokemonDeAgua3.AttackedFromPlant();
        assertEquals(pokemonDeAgua.getHp(), 5, "pokemonDeAgua, after being attacked by a fire type Health should be 5");
        assertEquals(pokemonDeAgua2.getHp(), 5, "pokemonDeAgua2, after being attacked by a water type Health should be 0");
        assertEquals(pokemonDeAgua3.getHp(), 0, "pokemonDeAgua3, after being attacked by a plant type Health should be 5");
        assertEquals(pokemonDeAgua3.isKO(), true, "If pokemonDeAgua3's health is 0, isKO() should be true");
    }
}
