package YandexTasks.business;

public interface SomeBusinessObjectProcessor {
    void processBusinessObject(SomeBusinessObject object);
    BusinessStatus getBusinessStatus();
}
