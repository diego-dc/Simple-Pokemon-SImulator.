package Classes;

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
    private float hp;
    private float attack;

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

    /** Specie Setter. Sets the Specie of the pokemon with the given String */
    protected void setSpecie(String mySpecie)
    {
        this.specie = mySpecie;
    }

    public String getSpecie(){
        if (this.specie != null) {
            return this.specie;
        }
        else
        {
            return "Specie not specified";
        }
    }

    public float getHp() {
        return hp;
    }

    protected void setHp(float hp) {
        this.hp = hp;
    }

    // Every pokemon might receive damage when its attacked by other pokemon
    // This method will just rest the damage (float) specified to the health of our Classes.Pokemon
    public void receiveDamage(float damage){
        if(!this.isKO())
        {
            this.hp -= damage;
            if(this.hp < 0) // if health is under 0, we will set it to 0 to dont have negative numbers
            {
                this.hp = 0;
            }
        }
    }

    // this method will tell us if this pokemon is KO or not
    public boolean isKO(){
        if(hp <= 0){ // we check the health, if its 0 or negative, we say is KO
            return true;
        }
        else // anything else, we consider is not KO
        {
            return false;
        }

    }

}
