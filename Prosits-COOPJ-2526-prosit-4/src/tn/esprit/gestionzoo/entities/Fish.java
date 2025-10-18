package tn.esprit.gestionzoo.entities;

public class Fish extends Aquatic {
    private String species;

    public Fish(String family, String name, int age, boolean isMammal, String habitat, String species) {
        super(family, name, age, isMammal, habitat);
        this.species = species;
    }

    @Override
    public void swim() {
        System.out.println(getName() + " (poisson " + species + ") nage tranquillement dans " + habitat);
    }

    @Override
    public String toString() {
        return "Fish{" + super.toString() + ", species='" + species + "'}";
    }
}
