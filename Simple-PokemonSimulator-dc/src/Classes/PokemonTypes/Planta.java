package Classes.PokemonTypes;

import Classes.PokemonProfile;

public class Planta extends PokemonProfile
{
    // we create a constructor for our Plant class
    // it will require a name, specie, and an amount of health
    public Planta(String name, String specie, float health)
    {
        setName(name);
        setSpecie(specie);
        setHp(health);
    }
    // We can attack other pokemons
    // Depending on the pokemon's type it will receive a certain amount of damage
    public void Attack(Classes.IPokemon IPokemon){
        IPokemon.AttackedFromPlant();
    }

    // A Plant pokemon will receive 5 of damage from a Water pokemon
    // If this type is attacked by a Water type, we rest 5 from its current Health.
    public void AttackedFromWater(){
        this.receiveDamage(5);
    }
    // A Plant pokemon will receive 10 of damage from a Fire pokemon
    // If this type is attacked by a Fire type, we rest 10 from its current Health.
    public void AttackedFromFire(){
        this.receiveDamage(10);
    }
    // A Plant pokemon will receive 5 of damage from a Plant pokemon
    // If this type is attacked by a Plant type, we rest 5 from its current Health.
    public void AttackedFromPlant(){
        this.receiveDamage(5);
    }


}