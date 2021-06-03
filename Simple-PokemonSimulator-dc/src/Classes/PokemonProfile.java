package Classes;

import Classes.PokemonTypes.FireType;
import Classes.PokemonTypes.PlantType;
import Classes.PokemonTypes.WaterType;

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
    private double hp;
    private double attack = 5;

    /** Abstract Constructor to set parameters of a pokemon profile. */
    public PokemonProfile(String name, String specie, double hp, double attack)
    {
        this.name = name;
        this.specie = specie;
        this.hp = hp;
        this.attack = attack;
    }

    /** Name Setter. Sets the name of the pokemon with the given String */
    protected void  setName(String newName){
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

    /** HP Setter. Sets the HP of the pokemon with the given float */
    protected void setHp(double hp) {
        this.hp = hp;
    }

    /** HP Getter. Returns the HP of the pokemon in a float */
    public double getHp() {
        return hp;
    }

    /** Attack Setter. Sets the Attack of the pokemon with the given float */
    public void setAttack(float attack) {
        this.attack = attack;
    }

    /** Attack Getter. Returns the Attack of the pokemon in a float */
    public double getAttack() {
        return this.attack;
    }

    /**
     * Indicates if this pokemon is KO or not
     */
    public boolean isKO(){
        if(hp <= 0){ // we check the health, if its 0 or negative, we say is KO
            return true;
        }
        else // anything else, we consider is not KO
        {
            return false;
        }
    }

    /**
     * Every pokemon might receive damage when its attacked by other pokemon
     * This method will rest the damage (float) specified to the Hp of our Pokemon
     */
    public void receiveDamage(double damage){
        if(!this.isKO())
        {
            this.hp -= damage;
            if(this.hp < 0) // if health is under 0, we will set it to 0 to dont have negative numbers
            {
                this.hp = 0;
            }
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
