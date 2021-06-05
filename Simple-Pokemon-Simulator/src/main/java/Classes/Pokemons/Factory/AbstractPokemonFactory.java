package Classes.Pokemons.Factory;

import Classes.Pokemons.IPokemon;
import Classes.Pokemons.PokemonProfile;

/**
 * Pokemon Factory.
 * An extensible and easier way to create pokemon
 *
 * @author Diego Caviedes A.
 */

public abstract class AbstractPokemonFactory implements IPokemonFactory {
    protected String name;
    protected String specie;
    private double attack = 5.0;
    private double Hp = 100;
    private double pp = 100;


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public void setAttack(double attack) {
        this.attack = attack;
    }

    @Override
    public void setHp(double hp) {
        Hp = hp;
    }

    @Override
    public void setPP(double pp) {
        this.pp = pp;
    }
}
