public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    // Constructeur avec validation (Instruction 18)
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Erreur : l'âge d'un animal ne peut pas être négatif !");
            this.age = 0;
        }
        this.isMammal = isMammal;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal [Famille=" + family + ", Nom=" + name + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
    }

    // Un animal est unique par famille + nom (Instruction 12)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal other = (Animal) obj;
        return this.name.equalsIgnoreCase(other.name) &&
                this.family.equalsIgnoreCase(other.family);
    }
}
