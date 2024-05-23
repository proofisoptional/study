package YandexTasks.business;

public class SomeBusinessObjectProcessorWithStatus1 implements SomeBusinessObjectProcessor{

    @Override
    public void processBusinessObject(SomeBusinessObject object) {

    }

    @Override
    public BusinessStatus getBusinessStatus() {
        return BusinessStatus.STATUS1;
    }
}
