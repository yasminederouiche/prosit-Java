public class Zoo {
    private Animal[] animals = new Animal[NBR_CAGES];
    private String name;
    private String city;
    private int animalCount = 0;
    public static final int NBR_CAGES = 25; // constante

    // Constructeurs
    public Zoo() {}

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // Afficher infos du zoo
    public void displayZoo() {
        System.out.println("Zoo : " + name + ", Ville : " + city + ", Cages : " + NBR_CAGES);
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Nombre cages=" + NBR_CAGES + ", Animaux=" + animalCount + "]";
    }

    // Instruction 10 - Ajouter un animal
    public boolean addAnimal(Animal animal) {
        if (animalCount >= NBR_CAGES) {
            System.out.println("Zoo plein, impossible d'ajouter " + animal.getName());
            return false;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                System.out.println("Animal déjà existant : " + animal.getName());
                return false;
            }
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    // Instruction 11 - Afficher les animaux
    public void afficherAnimals() {
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
        } else {
            for (int i = 0; i < animalCount; i++) {
                System.out.println(animals[i]);
            }
        }
    }

    // Instruction 11 - Rechercher un animal
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    // Instruction 13 - Supprimer un animal
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("Animal non trouvé : " + animal.getName());
            return false;
        }
        // Décalage à gauche
        for (int j = index; j < animalCount - 1; j++) {
            animals[j] = animals[j + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    // Instruction 15 - Vérifier si le zoo est plein
    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    // Instruction 16 - Comparer deux zoos
    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount == z2.animalCount) {
            System.out.println("Les deux zoos ont le même nombre d'animaux.");
            return null;
        }
        return (z1.animalCount > z2.animalCount) ? z1 : z2;
    }
}
