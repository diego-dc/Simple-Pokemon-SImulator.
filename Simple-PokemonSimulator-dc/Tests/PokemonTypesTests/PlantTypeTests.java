package PokemonTypesTests;

import Classes.PokemonTypes.Agua;
import Classes.PokemonTypes.Fuego;
import Classes.PokemonTypes.Planta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantTypeTests {

    private Planta pokemonDePlanta;
    private Planta pokemonDePlanta2;
    private Planta pokemonDePlanta3;
    private Agua pokemonDeAgua;
    private Fuego pokemonDeFuego;

    @BeforeEach
    void setUp() throws Exception {
        pokemonDePlanta = new Planta("filip", "plantatype", 10);
        pokemonDePlanta2 = new Planta("filip2", "plantatype", 10);
        pokemonDePlanta3 = new Planta("filip3", "plantatype", 10);
        pokemonDeFuego = new Fuego("miguelito", "Charizard", 10);
        pokemonDeAgua = new Agua("derek", "watertype", 10);
    }

    @Test
    void Planta(){
        assertEquals(pokemonDePlanta.getName(), "filip");
        assertEquals(pokemonDePlanta2.getName(), "filip2");
        assertEquals(pokemonDePlanta.getSpecie(), "plantatype");
        assertEquals(pokemonDePlanta2.getSpecie(), "plantatype");
    }

    @Test
    void attack() {
        pokemonDePlanta.Attack(pokemonDeAgua);
        pokemonDePlanta.Attack(pokemonDePlanta2);
        pokemonDePlanta.Attack(pokemonDeFuego);
        assertEquals(pokemonDeAgua.getHp(), 0, "Water type After being attacked by a plant type Health should be 5");
        assertEquals(pokemonDePlanta2.getHp(), 5, "Plant type After being attacked by a plant type Health should be 0");
        assertEquals(pokemonDeFuego.getHp(), 5, "Fire type After being attacked by a plant type Health should be 5");
    }

    @Test
    void attackedFrom() {
        pokemonDePlanta.AttackedFromFire();
        pokemonDePlanta2.AttackedFromWater();
        pokemonDePlanta3.AttackedFromPlant();
        assertEquals(pokemonDePlanta.getHp(), 0 , "pokemonDePlanta, after being attacked by a fire type Health should be 5");
        assertEquals(pokemonDePlanta2.getHp(), 5 , "pokemonDePlanta2, after being attacked by a water type Health should be 0");
        assertEquals(pokemonDePlanta3.getHp(), 5 , "pokemonDePlanta3, after being attacked by a plant type Health should be 5");
        assertEquals(pokemonDePlanta.isKO(), true, "If pokemonDePlanta's health is 0, isKO() should be true");
    }
}