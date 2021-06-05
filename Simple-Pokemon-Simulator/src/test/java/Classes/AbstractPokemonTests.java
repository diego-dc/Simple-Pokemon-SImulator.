package Classes;

import Classes.Items.IItem;
import Classes.Pokemons.PokemonProfile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractPokemonTests {


    /** Checks if the attack to a indifferent Type is correct */
    public void checkAttack(PokemonProfile pokemonAttacker, PokemonProfile pokemonTarget)
    {
        double expectedTargetHP = pokemonTarget.getMaxHP() - pokemonAttacker.getAttack();
        pokemonAttacker.Attack(pokemonTarget);
        assertEquals(expectedTargetHP, pokemonTarget.getCurrentHP(),
                "Attack Failed. Expected Target HP: " + expectedTargetHP + ", Actual: " + pokemonTarget.getCurrentHP());
    }


    /** Checks if the attack to a Type in disadvantage is correct */
    public void checkAttackToWeakType(PokemonProfile pokemonAttacker, PokemonProfile pokemonTarget)
    {
        double expectedTargetHP = pokemonTarget.getMaxHP() - (pokemonAttacker.getAttack() * 2);
        pokemonAttacker.Attack(pokemonTarget);
        assertEquals(expectedTargetHP, pokemonTarget.getCurrentHP(),
                "Attack Failed. Expected Target HP: " + expectedTargetHP + ", Actual: " + pokemonTarget.getCurrentHP());
    }


    /** Checks if the healing to a Pokemon is correct */
    public void checkHealingItemAction(IItem potionItem, PokemonProfile pokemonTarget, double ExpectedAmountToHeal)
    {
        double expectedTargetHP = pokemonTarget.getCurrentHP() + ExpectedAmountToHeal;
        potionItem.UseItem(pokemonTarget);
        assertEquals(expectedTargetHP, pokemonTarget.getCurrentHP(),
                "Healing Failed. Expected Target HP: " + expectedTargetHP + ", Actual: " + pokemonTarget.getCurrentHP());
    }


    /** Checks if the pp of a Pokemon is correct */
    public void checkPPBuffItemAction(IItem potionItem, PokemonProfile pokemonTarget, double ExpectedAmountToIncreasePP)
    {
        double expectedTargetPP = pokemonTarget.getCurrentPP() + ExpectedAmountToIncreasePP;
        potionItem.UseItem(pokemonTarget);
        assertEquals(expectedTargetPP, pokemonTarget.getCurrentPP(),
                "PP Buff Failed. Expected Target PP: " + expectedTargetPP + ", Actual: " + pokemonTarget.getCurrentPP());
    }



}
