package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---------- Création du zoo ----------
        System.out.print("Entrez le nom du zoo : ");
        String zooName = sc.nextLine();

        int nbrCages;
        while(true) {
            System.out.print("Entrez le nombre de cages (entier positif) : ");
            if(sc.hasNextInt()) {
                nbrCages = sc.nextInt();
                if(nbrCages > 0) break;
            } else sc.next();
            System.out.println("Veuillez entrer un entier positif !");
        }
        System.out.println(zooName + " comporte " + nbrCages + " cages.");

        // ---------- Test ajout animaux ----------
        Zoo zoo1 = new Zoo("Zoo Esprit", "Tunis");
        Zoo zoo2 = new Zoo("Zoo Safari", "Sousse");

        Animal lion = new Animal("Félidé", "Lion", 5, true);
        Animal tigre = new Animal("Félidé", "Shere Khan", 7, true);
        Animal lion2 = new Animal("Félidé", "Lion", 5, true); // doublon

        zoo1.addAnimal(lion);
        zoo1.addAnimal(tigre);
        zoo1.addAnimal(lion2); // refusé

        zoo1.displayAnimals();

        System.out.println("Indice lion : " + zoo1.searchAnimal(lion));
        System.out.println("Indice tigre : " + zoo1.searchAnimal(tigre));

        zoo1.removeAnimal(tigre);
        zoo1.displayAnimals();

        // Test zoo plein
        for(int i = 0; i < 30; i++) {
            zoo1.addAnimal(new Animal("TestFamily", "Animal" + i, 2, false));
        }
        System.out.println("Zoo plein ? " + zoo1.isZooFull());

        // Comparaison
        zoo2.addAnimal(new Animal("Canidés", "Wolf", 4, true));
        Zoo plusGrand = Zoo.comparerZoo(zoo1, zoo2);
        if(plusGrand != null)
            System.out.println("Zoo avec le plus d'animaux : " + plusGrand.getName());
        else
            System.out.println("Les deux zoos ont le même nombre d'animaux.");

        // ---------- Hiérarchie animale ----------
        Fish aquatic = new Fish("Poisson", "Nemo", 2, false, "Mer", "Clownfish");
        Terrestrial terrestrial = new Terrestrial("Félin", "Tigre", 7, true, 4);
        Dolphin dolphin = new Dolphin("Cétacé", "Dolly", 5, true, "Océan", 25.5f);
        Penguin penguin = new Penguin("Oiseau", "Pingu", 3, false, "Antarctique", 50.0f);

        System.out.println("\n=== Instances paramétrées ===");
        System.out.println(aquatic);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        System.out.println("\n=== Test des comportements de nage ===");
        aquatic.swim();
        dolphin.swim();
        penguin.swim();


        sc.close();
    }
}
