package Classes.Items;

import Classes.Pokemons.PokemonProfile;

/**
 * Full Restore Potion Item Restores all the HP of the targeted Pokemon.
 */


public class FullRestorePotionItem implements IItem{

    @Override
    public void UseItem(PokemonProfile target)
    {
        target.receiveHeal(target.getMaxHP());
    }
}
