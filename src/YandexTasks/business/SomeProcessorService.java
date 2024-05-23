package YandexTasks.business;

import java.util.Map;

public class SomeProcessorService {
    private Map<BusinessStatus, SomeBusinessObjectProcessor> map;
    public void processBusinessObject(SomeBusinessObject object){
        SomeBusinessObjectProcessor processor = map.get(object.getStatus());
        processor.processBusinessObject(object);
    }
}
