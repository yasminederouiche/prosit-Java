package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {
    protected String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public abstract void swim();

    @Override
    public String toString() {
        return "Aquatic{" + super.toString() + ", habitat='" + habitat + "'}";
    }

    // Optionnel : tu peux garder une version d'equals() spécifique, mais Animal.equals couvre déjà les champs de base.
}
