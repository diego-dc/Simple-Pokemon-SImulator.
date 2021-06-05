package Classes.Pokemons.PokemonTypes;

import Classes.Pokemons.IPokemon;
import Classes.Pokemons.PokemonProfile;

/**
 * Water Type Pokemon.
 * This is a type of pokemon,
 * strong against Fire Pokemon
 * weak against Plant Pokemon.
 *
 * @author Diego Caviedes A.
 */

public class WaterType extends PokemonProfile
{
    /**
     * Constructor for our WaterType Pokemon class
     * it will require a name, specie, an amount of health and some base attack
     */
    public WaterType(String name, String specie, double hp, double attack, double pp)
    {
        super(name, specie, hp, attack, pp);
    }


    @Override
    public void Attack(IPokemon target){
        target.AttackedFromWater(this);
    }


    /**
     * {@inheritDoc}
     *
     * WaterType is weak against PlantType.
     * This means it will receive double damage from a PlantType.
     */
    @Override
    public void AttackedFromPlant(PlantType attacker){
        this.receiveDamage(attacker.getAttack() * 2 );
    }
}
