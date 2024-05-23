package patterns.factory_method;

public class ConcreteCreator extends AbstractCreator{
    @Override
    public Behaviour createObject() {
        return new ConcreteObject();
    }
}
