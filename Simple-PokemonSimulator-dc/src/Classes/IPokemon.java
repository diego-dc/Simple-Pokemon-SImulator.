package Classes;

import Classes.PokemonTypes.FireType;
import Classes.PokemonTypes.PlantType;
import Classes.PokemonTypes.WaterType;

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
     * @param Damage
     */
    void receiveDamage(double Damage);


    /** Attack received by PlantType Pokemon */
    void AttackedFromPlant(PlantType attacker);

    /** Attack received by FireType Pokemon */
    void AttackedFromFire(FireType attacker);

    /** Attack received by WaterType Pokemon */
    void AttackedFromWater(WaterType attacker);

    /** Will tell when a Pokemon is KO */
    boolean isKO();
}
