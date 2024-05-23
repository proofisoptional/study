package horstmann_lessons.classes;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Dog", 11, new int[]{5, 8});
        Animal animal = new Animal("Animal", 12, new int[]{4, 8});
        dog.move();
        animal.move();
        for(int x: dog.getCoordinates()){
            System.out.println(x);
        }
        for(int x: animal.getCoordinates()){
            System.out.println(x);
        }
    }
}
