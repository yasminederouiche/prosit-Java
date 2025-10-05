import java.util.ArrayList;
import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Zoo> zoos = new ArrayList<>(); // plusieurs zoos possibles

        int choix;
        do {
            System.out.println("\n=== Menu Gestion Zoo ===");
            System.out.println("1. Ajouter un zoo");
            System.out.println("2. Afficher les zoos");
            System.out.println("3. Modifier un zoo");
            System.out.println("4. Supprimer un zoo");
            System.out.println("5. Comparer deux zoos");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    // Ajouter un zoo
                    System.out.print("Nom du zoo : ");
                    String name = sc.nextLine();
                    System.out.print("Ville du zoo : ");
                    String city = sc.nextLine();
                    zoos.add(new Zoo(name, city));
                    System.out.println("✅ Zoo ajouté avec succès !");
                    break;

                case 2:
                    // Afficher tous les zoos
                    if (zoos.isEmpty()) {
                        System.out.println("⚠️ Aucun zoo enregistré.");
                    } else {
                        for (int i = 0; i < zoos.size(); i++) {
                            System.out.println(i + " - " + zoos.get(i));
                        }
                    }
                    break;

                case 3:
                    // Modifier un zoo
                    if (zoos.isEmpty()) {
                        System.out.println("⚠️ Aucun zoo à modifier.");
                        break;
                    }
                    System.out.print("Entrez l'index du zoo à modifier : ");
                    int indexModif = sc.nextInt();
                    sc.nextLine();
                    if (indexModif >= 0 && indexModif < zoos.size()) {
                        Zoo z = zoos.get(indexModif);
                        System.out.println("Zoo sélectionné : " + z);

                        System.out.println("1. Changer le nom");
                        System.out.println("2. Changer la ville");
                        System.out.println("3. Ajouter un animal");
                        System.out.println("4. Supprimer un animal");
                        System.out.println("5. Afficher les animaux");
                        System.out.print("Choix : ");
                        int action = sc.nextInt();
                        sc.nextLine();

                        switch (action) {
                            case 1:
                                System.out.print("Nouveau nom : ");
                                String newName = sc.nextLine();
                                z.setName(newName);
                                break;
                            case 2:
                                System.out.print("Nouvelle ville : ");
                                String newCity = sc.nextLine();
                                z.setCity(newCity);
                                break;
                            case 3:
                                System.out.print("Famille de l'animal : ");
                                String fam = sc.nextLine();
                                System.out.print("Nom de l'animal : ");
                                String aniName = sc.nextLine();
                                System.out.print("Âge : ");
                                int age = sc.nextInt();
                                System.out.print("Mammifère ? (true/false) : ");
                                boolean mammif = sc.nextBoolean();
                                sc.nextLine();
                                z.addAnimal(new Animal(fam, aniName, age, mammif));
                                break;
                            case 4:
                                z.afficherAnimals();
                                System.out.print("Nom de l'animal à supprimer : ");
                                String aniDel = sc.nextLine();
                                z.removeAnimal(new Animal("", aniDel, 0, false));
                                break;
                            case 5:
                                z.afficherAnimals();
                                break;
                        }
                    } else {
                        System.out.println("⚠️ Index invalide.");
                    }
                    break;

                case 4:
                    // Supprimer un zoo
                    if (zoos.isEmpty()) {
                        System.out.println("⚠️ Aucun zoo à supprimer.");
                    } else {
                        System.out.print("Entrez l'index du zoo à supprimer : ");
                        int indexSup = sc.nextInt();
                        sc.nextLine();
                        if (indexSup >= 0 && indexSup < zoos.size()) {
                            zoos.remove(indexSup);
                            System.out.println("✅ Zoo supprimé !");
                        } else {
                            System.out.println("⚠️ Index invalide.");
                        }
                    }
                    break;

                case 5:
                    // Comparer deux zoos
                    if (zoos.size() < 2) {
                        System.out.println("⚠️ Il faut au moins deux zoos pour comparer.");
                    } else {
                        System.out.print("Index du premier zoo : ");
                        int i1 = sc.nextInt();
                        System.out.print("Index du deuxième zoo : ");
                        int i2 = sc.nextInt();
                        sc.nextLine();

                        if (i1 >= 0 && i1 < zoos.size() && i2 >= 0 && i2 < zoos.size()) {
                            Zoo bigger = Zoo.compareZoo(zoos.get(i1), zoos.get(i2));
                            if (bigger != null) {
                                System.out.println("Le plus grand zoo est : " + bigger);
                            }
                        } else {
                            System.out.println("⚠️ Index(s) invalide(s).");
                        }
                    }
                    break;

                case 0:
                    System.out.println("👋 Fin du programme.");
                    break;

                default:
                    System.out.println("❌ Choix invalide !");
            }

        } while (choix != 0);

        sc.close();
    }
}

