package patterns.factory_method;

public class ConcreteCreator2 extends AbstractCreator{
    @Override
    public Behaviour createObject() {
        return new ConcreteObject2();
    }
}
