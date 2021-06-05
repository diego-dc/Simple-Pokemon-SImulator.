package Classes.Pokemons.PokemonTypes;

import Classes.Pokemons.PokemonProfile;
import Classes.Pokemons.IPokemon;


/**
 * Plant Type Pokemon.
 * This is a type of pokemon,
 * strong against Water Pokemon
 * weak against Fire Pokemon.
 *
 * @author Diego Caviedes A.
 */
public class PlantType extends PokemonProfile
{
    /**
     * Constructor for our PlantType Pokemon class
     * it will require a name, specie, an amount of health and some base attack
     */
    public PlantType(String name, String specie, double hp, double attack, double pp)
    {
        super(name, specie, hp, attack, pp);
    }


    @Override
    public void Attack(IPokemon IPokemon){
        IPokemon.AttackedFromPlant(this);
    }


    /**
     * {@inheritDoc}
     *
     * PlantType is weak against FireType.
     * This means it will receive double damage from a FireType.
     */
    @Override
    public void AttackedFromFire(FireType attacker){
        this.receiveDamage(attacker.getAttack() * 2);
    }


}
