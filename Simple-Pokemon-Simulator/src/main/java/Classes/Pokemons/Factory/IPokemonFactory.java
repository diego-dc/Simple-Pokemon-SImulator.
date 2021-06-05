package Classes.Pokemons.Factory;

import Classes.Pokemons.IPokemon;
import Classes.Pokemons.PokemonProfile;

public interface IPokemonFactory {

    PokemonProfile createPokemon();

    void setName(String name);

    void setSpecie(String Specie);

    void setAttack(double Attack);

    void setHp(double hp);

    void setPP(double pp);

}
