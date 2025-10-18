package tn.esprit.gestionzoo.entities;

import java.util.Objects;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal() {}

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    public String getFamily() { return family; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isMammal() { return isMammal; }

    @Override
    public String toString() {
        return "Animal{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMammal=" + isMammal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return age == animal.age &&
                isMammal == animal.isMammal &&
                Objects.equals(family, animal.family) &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, name, age, isMammal);
    }
}
