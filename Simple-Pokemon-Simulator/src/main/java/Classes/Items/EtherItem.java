package Classes.Items;

/**
 * Ether Item restores power points of the targeted Pokemon.
 */

import Classes.Pokemons.PokemonProfile;

public class EtherItem implements IItem{
    private double ppIncrement = 10;

    /** Constructor for a EtherItem */
    public EtherItem(double ppIncrement) {
        this.ppIncrement = ppIncrement;
    }


    @Override
    public void UseItem(PokemonProfile target) {
        target.ReceivePP(this.ppIncrement);
    }
}
