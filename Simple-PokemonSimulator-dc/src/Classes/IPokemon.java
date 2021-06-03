package Classes;

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
     * @param IPokemon
     *      pokemon targeted for the attack.
     */
    void Attack(IPokemon IPokemon);


    /**
     * Pokemon can receive damage.
     * Damage affects directly the health points.
     *
     * @param Damage
     */
    void receiveDamage(float Damage);


    /** Attack received by PlantType Pokemon */
    void AttackedFromPlant();

    /** Attack received by FireType Pokemon */
    void AttackedFromFire();

    /** Attack received by WaterType Pokemon */
    void AttackedFromWater();

    /** Will tell when a Pokemon is KO */
    boolean isKO();
}
