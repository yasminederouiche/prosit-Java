public class Animal {
    private String nom;
    private String espece;
    private int age;

    public Animal(String nom, String espece, int age) {
        this.nom = nom;
        this.espece = espece;
        this.age = age;
    }

    public String getNom() { return nom; }
    public String getEspece() { return espece; }
    public int getAge() { return age; }
}