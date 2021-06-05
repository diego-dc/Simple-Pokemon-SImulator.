package Classes.Pokemons.Factory;

import Classes.Pokemons.PokemonProfile;
import Classes.Pokemons.PokemonTypes.WaterType;

public class WaterTypePokemon extends AbstractPokemonFactory {

    @Override
    public WaterType createPokemon() {
        // we give some default values for all WaterTypes Pokemon
        return new WaterType(name, specie, 100, 5, 100);
    }
}
