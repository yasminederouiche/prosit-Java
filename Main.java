import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList soc = new SocieteArrayList();

        Employe e1 = new Employe(3, "Ben", "Ali", "Finance", 2);
        Employe e2 = new Employe(1, "Cherif", "Sami", "Informatique", 1);
        Employe e3 = new Employe(5, "Ben", "Youssef", "Informatique", 3);
        Employe e4 = new Employe(2, "Mansour", "Rania", "RH", 2);
        Employe e5 = new Employe(4, "Khaled", "Slim", "Finance", 1);

        soc.ajouterEmploye(e1);
        soc.ajouterEmploye(e2);
        soc.ajouterEmploye(e3);
        soc.ajouterEmploye(e4);
        soc.ajouterEmploye(e5);

        System.out.println("---- Tous les employés ----");
        soc.displayEmploye();

        System.out.println("---- Recherche par nom 'Ben' ----");
        System.out.println(soc.rechercherEmploye("Ben"));

        System.out.println("---- Recherche par objet (e3) ----");
        System.out.println(soc.rechercherEmploye(e3));

        System.out.println("---- Trier par id ----");
        soc.trierEmployeParId();
        soc.displayEmploye();

        System.out.println("---- Trier par département, grade, nom ----");
        soc.trierEmployeParNomDépartementEtGrade();
        soc.displayEmploye();

        System.out.println("---- Rechercher par département 'Informatique' ----");
        List<Employe> it = soc.rechercherParDepartement("Informatique");
        for (Employe e : it) {
            System.out.println(e);
        }

        System.out.println("---- Supprimer e2 (id=1) ----");
        soc.supprimerEmploye(e2);
        soc.displayEmploye();
    }
}