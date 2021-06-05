package Classes.Items;

import Classes.Pokemons.PokemonProfile;

/**
 *  Item Interface.
 *
 *  All classes that share a common behaviour as Items.
 *
 * @author Diego Caviedes C.
 */

public interface IItem {

    /**
     * Items can be used and react with a Pokemon.
     */
    public void UseItem(PokemonProfile target);

}
