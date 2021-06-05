package Classes.Pokemons;

import Classes.Pokemons.PokemonTypes.FireType;
import Classes.Pokemons.PokemonTypes.PlantType;
import Classes.Pokemons.PokemonTypes.WaterType;

/**
 * Abstract Pokemon Profile
 *
 * This class represents the profile of a Pokemon.
 * Each pokemon counts with unique specification:
 * Name -> Name of the pokemon.
 * Hp -> health points.
 * Specie -> Specie of the pokemon.
 * Attack -> base attack of the pokemon.
 *
 * @author Diego Caviedes Aguirre
 */

public abstract class PokemonProfile implements IPokemon {
    private String name;
    private String specie;
    private double currentHP;
    private double maxHP;
    private double attack = 5.0; // Base attack of 5 by Default
    private double currentPP;
    private double maxPP;

    /** Abstract Constructor to set parameters of a pokemon profile. */
    public PokemonProfile(String name, String specie, double hp, double attack, double pp)
    {
        this.name = name;
        this.specie = specie;
        this.currentHP = hp; // we consider that a new pokemon start with max healthPoints
        this.maxHP = hp;
        this.attack = attack;
        this.currentPP = pp; // we consider that a new pokemon start with max powerPoints
        this.maxPP = pp;
    }

    /** Name Setter. Sets the name of the pokemon with the given String */
    public void  setName(String newName){
        this.name = newName;
    }

    /** Name Getter. Returns the name of the pokemon in a String */
    public String getName(){
        if(this.name != null)
        {
            return this.name;
        }
        else
        {
            return "Name not specified";
        }
    }

    /** Specie Getter. Returns the specie of the pokemon in a String */
    public String getSpecie(){
        if (this.specie != null) {
            return this.specie;
        }
        else
        {
            return "Specie not specified";
        }
    }

    /** currentHP Setter. Sets the currentHP of the pokemon with the given double */
    public void setCurrentHP(double hp) {
        this.currentHP = hp;
    }

    /** currentHP Getter. Returns the currentHP of the pokemon in a double */
    public double getCurrentHP() {
        return currentHP;
    }

    /** maxHP Setter. Sets the maxHP of the pokemon with the given double */
    public void setMaxHP(double hp) {
        this.maxHP = hp;
    }

    /** maxHP Getter. Returns the maxHP of the pokemon in a double */
    public double getMaxHP() {
        return maxHP;
    }

    /** Attack Setter. Sets the Attack of the pokemon with the given double */
    public void setAttack(float attack) {
        this.attack = attack;
    }

    /** Attack Getter. Returns the Attack of the pokemon in a double */
    public double getAttack() {
        return this.attack;
    }

    /** currentPP Setter. Sets the currentPP of the pokemon with the given double */
    public void setCurrentPP(double pp) {
        this.currentPP = pp;
    }

    /** currentPP Getter. Returns the currentPP of the pokemon in a double */
    public double getCurrentPP() {
        return currentPP;
    }

    /** maxPP Setter. Sets the maxPP of the pokemon with the given double */
    public void setMaxPP(double pp) {
        this.maxPP = pp;
    }

    /** maxPP Getter. Returns the maxPP of the pokemon in a double */
    public double getMaxPP() {
        return maxPP;
    }

    /**
     * Indicates if this pokemon is KO or not
     */
    public boolean isKO(){
        if(currentHP <= 0){ // we check the health, if its 0 or negative, we say is KO
            return true;
        }
        else // anything else, we consider is not KO
        {
            return false;
        }
    }

    /**
     * Every pokemon might receive damage when its attacked by other pokemon
     * This method will rest the damage (float) specified to the currentHp of our Pokemon
     */
    public void receiveDamage(double damage){
        if(!this.isKO())
        {
            this.currentHP -= damage;
            if(this.currentHP < 0) // if health is under 0, we will set it to 0 to dont have negative numbers
            {
                this.currentHP = 0;
            }
        }
    }

    @Override
    public void receiveHeal(double healAmount) {
        if(!this.isKO())
        {
            if(this.currentHP + healAmount >= this.maxHP) // if the healing sets our HP equal or above maxHP, we will set it to maxHP
            {
                this.currentHP = this.maxHP;
            }
            else{this.currentHP += healAmount;}
        }
    }

    @Override
    public void UsePP(double ppUsed) {
        if(!this.isKO())
        {
            this.currentPP -= ppUsed;
            if(this.currentPP < 0) // if powerpoints are under 0, we will set it to 0 to dont have negative numbers
            {
                this.currentPP = 0;
            }
        }
    }

    @Override
    public void ReceivePP(double ppReceived) {
        if(!this.isKO())
        {
            // if the extra pp sets our powerpoints equal or above maxPP, we will set it to maxHP
            if(this.currentPP + ppReceived >= this.maxPP)
            {
                this.currentPP = this.maxPP;
            }
            else{this.currentPP += ppReceived;}
        }
    }

    @Override
    public void AttackedFromPlant(PlantType attacker) {
        this.receiveDamage(attacker.getAttack());
    }

    @Override
    public void AttackedFromFire(FireType attacker) {
        this.receiveDamage(attacker.getAttack());
    }

    @Override
    public void AttackedFromWater(WaterType attacker) {
        this.receiveDamage(attacker.getAttack());
    }


}
