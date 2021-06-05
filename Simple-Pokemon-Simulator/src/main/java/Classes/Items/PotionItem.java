package Classes.Items;

import Classes.Pokemons.PokemonProfile;

/**
 * Potions restores an amount of HP to the targeted pokemon
 */
public class PotionItem implements IItem{
    private double healAmount = 5;

    /** Constructor of a Potion Item */
    public PotionItem(double healAmount) {
        this.healAmount = healAmount;
    }

    /** Setter. In case we want to modify the healing amount of this potion */
    // idk if this can happen, but just in case for now.
    public void setHealAmount(double healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void UseItem(PokemonProfile target) {
        target.receiveHeal(this.healAmount);
    }
}
