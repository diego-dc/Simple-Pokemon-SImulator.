package Classes.Pokemons;

import Classes.Pokemons.PokemonTypes.FireType;
import Classes.Pokemons.PokemonTypes.PlantType;
import Classes.Pokemons.PokemonTypes.WaterType;

/**
 * Interface Pokemon
 *
 * Generic behaviours all pokemon share.
 *
 * @author Diego Caviedes Aguirre
 */

public interface IPokemon {


    /**
     * Each pokemon can realize a simple attack
     *
     * @param target
     *      pokemon targeted for the attack.
     */
    void Attack(IPokemon target);


    /**
     * Pokemon can receive damage.
     * Damage affects directly the health points.
     *
     * @param damage
     *      amount of damage received
     */
    void receiveDamage(double damage);

    /**
     * Pokemon can receive some healing.
     * Healing affects directly the health points.
     *
     * @param healAmount
     *      amount of heal received
     */
    void receiveHeal(double healAmount);


    /**
     * Pokemon use power points to realize actions
     */
    void UsePP(double ppUsed);


    /**
     * Pokemon can receive power points
     */
    void ReceivePP(double ppReceived);


    /** Attack received by PlantType Pokemon */
    void AttackedFromPlant(PlantType attacker);

    /** Attack received by FireType Pokemon */
    void AttackedFromFire(FireType attacker);

    /** Attack received by WaterType Pokemon */
    void AttackedFromWater(WaterType attacker);

    /** Will tell when a Pokemon is KO */
    boolean isKO();
}
