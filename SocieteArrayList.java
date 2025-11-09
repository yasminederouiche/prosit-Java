import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe>, IRechercheAvancee<Employe> {
    private List<Employe> liste = new ArrayList<>();

    public void ajouterEmploye(Employe e) {
        if (e != null) liste.add(e);
    }

    public boolean rechercherEmploye(String nom) {
        for (Employe e : liste) {
            if (e.getNom() != null && e.getNom().equalsIgnoreCase(nom)) return true;
        }
        return false;
    }

    public boolean rechercherEmploye(Employe t) {
        return liste.contains(t);
    }

    public void supprimerEmploye(Employe t) {
        liste.remove(t);
    }

    public void displayEmploye() {
        for (Employe e : liste) {
            System.out.println(e);
        }
    }

    public void trierEmployeParId() {
        Collections.sort(liste);
    }

    public void trierEmployeParNomDépartementEtGrade() {
        Collections.sort(liste, Comparator.comparing(Employe::getNomDepartement, Comparator.nullsFirst(String::compareToIgnoreCase))
                .thenComparing(Employe::getGrade)
                .thenComparing(Employe::getNom, Comparator.nullsFirst(String::compareToIgnoreCase)));
    }

    public List<Employe> rechercherParDepartement(String nomDepartement) {
        List<Employe> res = new ArrayList<>();
        for (Employe e : liste) {
            if (e.getNomDepartement() != null && e.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                res.add(e);
            }
        }
        return res;
    }
}