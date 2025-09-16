import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lecture du nom du zoo
        System.out.print("Entrez le nom du zoo : ");
        String zooName = sc.nextLine();

        // Lecture du nombre de cages
        int nbrCages = -1;
        while (nbrCages <= 0) {
            System.out.print("Entrez le nombre de cages (entier positif) : ");
            if (sc.hasNextInt()) {
                nbrCages = sc.nextInt();
                if (nbrCages <= 0) {
                    System.out.println("Erreur : le nombre doit être positif !");
                }
            } else {
                System.out.println("Erreur : veuillez entrer un nombre entier !");
                sc.next(); // vider la mauvaise saisie
            }
        }

        // Affichage du résultat
        System.out.println("Le zoo " + zooName + " contient " + nbrCages + " cages.");

        sc.close(); // fermer le scanner
    }
}
