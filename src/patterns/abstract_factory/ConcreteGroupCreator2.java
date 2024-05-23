package patterns.abstract_factory;

public class ConcreteGroupCreator2 extends AbstractGroupCreator{
    @Override
    public SpecificInterface1 createFirstObject() {
        return new SecondGroupObject1();
    }

    @Override
    public SpecificInterface2 createSecondObject() {
        return new SecondGroupObject2();
    }
}
