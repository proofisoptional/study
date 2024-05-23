package patterns.abstract_factory;

public class ConcreteGroupCreator extends AbstractGroupCreator{
    @Override
    public SpecificInterface1 createFirstObject() {
        return new FirstGroupObject1();
    }

    @Override
    public SpecificInterface2 createSecondObject() {
        return new FirstGroupObject2();
    }
}
