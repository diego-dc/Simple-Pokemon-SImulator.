package Classes.Pokemons.Factory;

import Classes.Pokemons.PokemonProfile;
import Classes.Pokemons.PokemonTypes.FireType;


public class FireTypePokemon extends AbstractPokemonFactory {

    @Override
    public FireType createPokemon() {
        // we give some default values for all FireTypes Pokemon
        return new FireType(name, specie, 100, 5, 100);
    }
}
