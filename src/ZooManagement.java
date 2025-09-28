import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo : ");
        String zooName = sc.nextLine();

        Zoo myZoo = new Zoo(zooName, "Tunis");

        // Création d’animaux
        Animal lion = new Animal("Félidé", "Lion", 5, true);
        Animal tigre = new Animal("Félidé", "Tigre", 4, true);
        Animal aigle = new Animal("Oiseau", "Aigle", 3, false);
        Animal lion2 = new Animal("Félidé", "Lion", 5, true); // identique au premier

        // Instruction 10 : test ajout
        System.out.println("\n--- Test Ajout ---");
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tigre);
        myZoo.addAnimal(aigle);
        myZoo.addAnimal(lion2); // doit afficher "Animal déjà existant"

        // Remplissage volontaire pour tester zoo plein
        for (int i = 0; i < 30; i++) {
            myZoo.addAnimal(new Animal("Test", "Animal" + i, i, true));
        }

        // Instruction 11 : affichage et recherche
        System.out.println("\n--- Animaux du zoo ---");
        myZoo.afficherAnimals();

        System.out.println("\n--- Recherche ---");
        int index = myZoo.searchAnimal(lion);
        System.out.println("Résultat recherche Lion : " + index);

        // Recherche d’un animal identique
        index = myZoo.searchAnimal(lion2);
        System.out.println("Résultat recherche Lion2 : " + index);

        // Instruction 13 : suppression
        System.out.println("\n--- Suppression ---");
        myZoo.removeAnimal(tigre);
        myZoo.afficherAnimals();

        // Instruction 15 : vérification si zoo plein
        System.out.println("\nZoo plein ? " + myZoo.isZooFull());

        // Instruction 16 : comparaison de zoos
        Zoo otherZoo = new Zoo("Zoo Bizerte", "Bizerte");
        otherZoo.addAnimal(new Animal("Canidé", "Loup", 6, true));

        System.out.println("\n--- Comparaison ---");
        Zoo bigger = Zoo.compareZoo(myZoo, otherZoo);
        if (bigger != null) {
            System.out.println("Le plus grand zoo est : " + bigger);
        }

        sc.close();
    }
}
