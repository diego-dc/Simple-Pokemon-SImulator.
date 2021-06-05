package Classes.Pokemons.Factory;

import Classes.Pokemons.PokemonProfile;
import Classes.Pokemons.PokemonTypes.PlantType;

public class PlantTypePokemon extends AbstractPokemonFactory {

    @Override
    public PlantType createPokemon() {
        // we give some default values for all PlantType
        return new PlantType(name, specie, 100, 5, 100);
    }
}
