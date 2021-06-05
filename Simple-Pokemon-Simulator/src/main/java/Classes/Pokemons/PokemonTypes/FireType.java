package Classes.Pokemons.PokemonTypes;

import Classes.Pokemons.IPokemon;
import Classes.Pokemons.PokemonProfile;

/**
 * Fire Type Pokemon.
 * This is a type of pokemon,
 * strong against Plant Pokemon
 * weak against Water Pokemon.
 *
 * @author Diego Caviedes A.
 */
public class FireType extends PokemonProfile {

    /**
     * Constructor for our FireType Pokemon class
     * it will require a name, specie, an amount of health and some base attack
     */
    public FireType(String name, String specie, double hp, double attack, double pp)
    {
        super(name, specie, hp, attack, pp);
    }

    @Override
    public void Attack(IPokemon IPokemon){
        IPokemon.AttackedFromFire(this);
    }

    /**
     * {@inheritDoc}
     *
     * FireType is weak against WaterType.
     * This means it will receive double damage from a WaterType.
     */
    @Override
    public void AttackedFromWater(WaterType attacker){
        this.receiveDamage(attacker.getAttack() * 2);
    }

}