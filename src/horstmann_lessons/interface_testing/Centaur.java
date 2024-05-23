package horstmann_lessons.interface_testing;

public class Centaur implements Animal, Human{
    @Override
    public void walk() {
        System.out.println("walk Centaur");
    }

}
