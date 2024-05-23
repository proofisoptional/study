package YandexTasks.business;

public class SomeBusinessObjectProcessorWithStatus2 implements SomeBusinessObjectProcessor {
    @Override
    public void processBusinessObject(SomeBusinessObject object) {

    }

    @Override
    public BusinessStatus getBusinessStatus() {
        return BusinessStatus.STATUS2;
    }
}
