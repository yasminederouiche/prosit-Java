package tn.esprit.gestionzoo.entities;

public class Zoo {
    private String name;
    private String city;
    private Animal[] animals;
    private int nbrAnimals;
    private static final int MAX_ANIMALS = 25;

    private Aquatic[] aquaticAnimals = new Aquatic[10];
    private int aquaticCount = 0;

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[MAX_ANIMALS];
        this.nbrAnimals = 0;
    }

    public String getName() { return name; }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein !");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("Animal déjà présent !");
            return false;
        }
        animals[nbrAnimals++] = animal;
        System.out.println(animal.getName() + " ajouté au zoo !");
        return true;
    }

    public void displayAnimals() {
        System.out.println("\nAnimaux du zoo :");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        if (animal == null) return -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i] != null && animals[i].equals(animal)) return i;
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) return false;
        animals[index] = animals[--nbrAnimals];
        animals[nbrAnimals] = null;
        return true;
    }

    public boolean isZooFull() {
        return nbrAnimals >= MAX_ANIMALS;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals) return z1;
        else if (z2.nbrAnimals > z1.nbrAnimals) return z2;
        else return null;
    }

    public void addAquaticAnimal(Aquatic a) {
        if (a == null) return;
        if (aquaticCount < aquaticAnimals.length) {
            aquaticAnimals[aquaticCount++] = a;
        } else {
            System.out.println("Le tableau des animaux aquatiques est plein !");
        }
    }

    public void makeAquaticsSwim() {
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] != null) aquaticAnimals[i].swim();
        }
    }

    public double maxDepthPenguins() {
        double maxDepth = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > maxDepth)
                    maxDepth = p.getSwimmingDepth();
            }
        }
        return maxDepth;
    }

    public void displayNumberByType() {
        int countDolphins = 0, countPenguins = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) countDolphins++;
            else if (aquaticAnimals[i] instanceof Penguin) countPenguins++;
        }
        System.out.println("Dauphins : " + countDolphins + ", Pingouins : " + countPenguins);
    }

}