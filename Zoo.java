import java.util.ArrayList;

public class Zoo {
    private String nom;
    private int nbrCages;
    private ArrayList<Animal> animaux;

    public Zoo(String nom, int nbrCages) {
        this.nom = nom;
        this.nbrCages = nbrCages;
        this.animaux = new ArrayList<>();
    }

    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal.getAge() < 0) {
            throw new InvalidAgeException();
        }
        if (animaux.size() >= nbrCages) {
            throw new ZooFullException();
        }
        animaux.add(animal);
        System.out.println(animal.getNom() + " a été ajouté au zoo.");
    }

    public int getNombreAnimaux() {
        return animaux.size();
    }

    public void afficherAnimaux() {
        if (animaux.isEmpty()) {
            System.out.println("Aucun animal dans le zoo.");
        } else {
            System.out.println("Animaux présents dans le zoo :");
            for (Animal a : animaux) {
                System.out.println("- " + a.getNom() + " (" + a.getEspece() + ", " + a.getAge() + " ans)");
            }
        }
    }
}