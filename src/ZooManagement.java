import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Veuillez entrer le nom du zoo : ");
        String zooName = scanner.nextLine();
        while (zooName.trim().isEmpty()) {
            System.out.print("Erreur ❌ : le nom du zoo ne peut pas être vide. Réessayez : ");
            zooName = scanner.nextLine();
        }

        System.out.print("Veuillez entrer le nombre de cages : ");
        int nbrCages = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                int inputNbr = scanner.nextInt();
                if (inputNbr > 0) {
                    nbrCages = inputNbr;
                    break;
                } else {
                    System.out.print("Erreur ❌ : le nombre de cages doit être positif. Réessayez : ");
                }
            } else {
                System.out.print("Erreur ❌ : entrez un entier valide. Réessayez : ");
                scanner.next();
            }
        }

        Zoo myZoo = new Zoo(zooName, "Tunis", nbrCages);
        System.out.println("\n✅ Zoo créé avec succès !");
        myZoo.displayZoo();

        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Animal crocodile = new Animal("Crocodylidae", "Crocodile", 12, false);

        System.out.println("\nAnimaux créés :");
        System.out.println(lion);
        System.out.println(crocodile);

        System.out.println("\nAffichage direct du zoo avec toString :");
        System.out.println(myZoo);

        scanner.close();
    }
}
