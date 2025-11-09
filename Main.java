public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Zoo de Tunis", 3);

        Animal a1 = new Animal("Simba", "Lion", 5);
        Animal a2 = new Animal("Toto", "Singe", -2);
        Animal a3 = new Animal("Bella", "Girafe", 7);
        Animal a4 = new Animal("Rocky", "Tigre", 4);
        Animal a5 = new Animal("Nina", "Panda", 3);

        Animal[] animaux = {a1, a2, a3, a4, a5};

        for (Animal a : animaux) {
            try {
                zoo.addAnimal(a);
            } catch (InvalidAgeException e) {
                System.out.println("❌ Erreur : " + e.getMessage());
            } catch (ZooFullException e) {
                System.out.println("⚠️ " + e.getMessage());
            } finally {
                System.out.println("Nombre total d’animaux dans le zoo : " + zoo.getNombreAnimaux());
                System.out.println("---------------------------------------------");
            }
        }

        zoo.afficherAnimaux();
    }
}