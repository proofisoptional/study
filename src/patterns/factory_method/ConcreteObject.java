package patterns.factory_method;

public class ConcreteObject implements Behaviour{
    @Override
    public void doSmth() {
        System.out.println("concreteObject method");
    }
}
