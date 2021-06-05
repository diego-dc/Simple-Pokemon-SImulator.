package Classes;

import Classes.Items.EtherItem;
import Classes.Items.FullRestorePotionItem;
import Classes.Items.PotionItem;
import Classes.Pokemons.Factory.FireTypePokemon;
import Classes.Pokemons.Factory.PlantTypePokemon;
import Classes.Pokemons.Factory.WaterTypePokemon;
import Classes.Pokemons.PokemonProfile;
import Classes.Pokemons.PokemonTypes.FireType;
import Classes.Pokemons.PokemonTypes.PlantType;
import Classes.Pokemons.PokemonTypes.WaterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTests extends AbstractPokemonTests {
    WaterTypePokemon w_pokemon = new WaterTypePokemon();
    FireTypePokemon f_pokemon = new FireTypePokemon();
    PlantTypePokemon p_pokemon = new PlantTypePokemon();

    WaterType waterPokemon;
    FireType firePokemon;
    PlantType plantPokemon;

    PotionItem simplePotion;
    EtherItem ether;
    FullRestorePotionItem bigPotion;

    @BeforeEach
    void SetUp() {
        w_pokemon.setName("noName");
        w_pokemon.setSpecie("noSpecie");
        waterPokemon = w_pokemon.createPokemon(); // 100 hp - 5 attack - 100pp
        f_pokemon.setName("noName");
        f_pokemon.setSpecie("noSpecie");
        firePokemon = f_pokemon.createPokemon(); // 100 hp - 5 attack - 100pp
        p_pokemon.setName("noName");
        p_pokemon.setSpecie("noSpecie");
        plantPokemon = p_pokemon.createPokemon(); // 100 hp - 5 attack - 100pp

        simplePotion = new PotionItem(5);
        ether = new EtherItem(5);
        bigPotion = new FullRestorePotionItem();

    }

    @Test
    void FactoryAndSettersTest()
    {
        WaterType wat = w_pokemon.createPokemon();

        assertEquals(wat.getAttack(), 5);
        assertEquals(wat.getCurrentHP(), 100);
        assertEquals(wat.getMaxHP(), 100);
        assertEquals(wat.getCurrentPP(), 100);
        assertEquals(wat.getMaxPP(), 100);

        wat.setAttack(10);
        wat.setCurrentHP(50);
        wat.setMaxHP(200);
        wat.setCurrentPP(50);
        wat.setMaxPP(200);

        assertEquals(wat.getAttack(), 10);
        assertEquals(wat.getCurrentHP(), 50);
        assertEquals(wat.getMaxHP(), 200);
        assertEquals(wat.getCurrentPP(), 50);
        assertEquals(wat.getMaxPP(), 200);
    }

    @Test
    void IndifferentAttacksTests() {
        //---- attack between indifferent types-----
        // water attacks plant
        checkAttack(waterPokemon, plantPokemon);
        // plant attacks fire
        checkAttack(plantPokemon, firePokemon);
    }

    @Test
    void DominantAttacksTests() {
        //----- attack from dominant type----
        // water attacks fire
        checkAttackToWeakType(waterPokemon, firePokemon);
        // plant attacks water
        checkAttackToWeakType(plantPokemon, waterPokemon);
    }

    @Test
    void ItemsTests()
    {
        // ----- Simple Potion ---------
        // check for no reaction when taking a potion with full health
        checkHealingItemAction(simplePotion, waterPokemon, 0.0); // 0 hp restored expected

        waterPokemon.Attack(firePokemon); // -10hp firePokemon

        checkHealingItemAction(simplePotion, firePokemon, 5.0); // +5hp expected

        // ----- ether --------
        // check for no pp buff from ether when Pokemon full PP.
        checkPPBuffItemAction(ether, plantPokemon, 0.0);

        plantPokemon.UsePP(25); // lets say PlantPokemon uses 25 pp

        checkPPBuffItemAction(ether, plantPokemon, 5.0); // +5pp expected


        //--------- Full health Potion -----------

        waterPokemon.receiveDamage(50); // -50hp water Pokemon

        checkHealingItemAction(bigPotion, waterPokemon, 50); // +50Hp expected
    }
}
