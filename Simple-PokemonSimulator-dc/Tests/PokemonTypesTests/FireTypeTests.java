package PokemonTypesTests;

import Classes.PokemonTypes.Agua;
import Classes.PokemonTypes.Fuego;
import Classes.PokemonTypes.Planta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireTypeTests {

    private Fuego pokemonDeFuego;
    private Fuego pokemonDeFuego2;
    private Fuego pokemonDeFuego3;
    private Agua pokemonDeAgua;
    private Planta pokemonDePlanta;

    @BeforeEach
    void setUp() throws Exception {
        pokemonDeFuego = new Fuego("miguelito", "Charizard", 10);
        pokemonDeFuego2 = new Fuego("miguelote", "Charizard", 10);
        pokemonDeFuego3 = new Fuego("miguelotex", "Charizard", 10);
        pokemonDePlanta = new Planta("filip", "plantatype", 10);
        pokemonDeAgua = new Agua("derek", "watertype", 10);
    }

    @Test
    void fuego(){
        assertEquals(pokemonDeFuego.getName(), "miguelito");
        assertEquals(pokemonDeFuego2.getName(), "miguelote");
        assertEquals(pokemonDeFuego.getSpecie(), "Charizard");
        assertEquals(pokemonDeFuego2.getSpecie(), "Charizard");
    }

    @Test
    void attack() {
        pokemonDeFuego.Attack(pokemonDeAgua);
        pokemonDeFuego.Attack(pokemonDeFuego2);
        pokemonDeFuego.Attack(pokemonDePlanta);
        assertEquals(pokemonDeAgua.getHp(), 5, "Water type After being attacked by a fire type Health should be 5");
        assertEquals(pokemonDePlanta.getHp(), 0, "Plant type After being attacked by a fire type Health should be 0");
        assertEquals(pokemonDeFuego2.getHp(), 5, "Fire type After being attacked by a fire type Health should be 5");
    }

    @Test
    void attackedFrom() {
        pokemonDeFuego.AttackedFromFire();
        pokemonDeFuego2.AttackedFromWater();
        pokemonDeFuego3.AttackedFromPlant();
        assertEquals(pokemonDeFuego.getHp(), 5 , "PokemonDeFuego, after being attacked by a fire type Health should be 5");
        assertEquals(pokemonDeFuego2.getHp(), 0 , "PokemonDeFuego2, after being attacked by a water type Health should be 0");
        assertEquals(pokemonDeFuego3.getHp(), 5 , "PokemonDeFuego3, after being attacked by a plant type Health should be 5");
        assertEquals(pokemonDeFuego2.isKO(), true, "If pokemonDeFuego2's health is 0, isKO() should be true");
    }
}