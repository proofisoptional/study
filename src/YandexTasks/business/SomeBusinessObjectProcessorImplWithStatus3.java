package YandexTasks.business;

public class SomeBusinessObjectProcessorImplWithStatus3 implements SomeBusinessObjectProcessor {
    @Override
    public void processBusinessObject(SomeBusinessObject object) {

    }

    @Override
    public BusinessStatus getBusinessStatus() {
        return BusinessStatus.STATUS3;
    }
}
