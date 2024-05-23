package patterns.singletone;

public class SingletoneClass {
    private static SingletoneClass instance;

    private SingletoneClass() {

    }
    public static SingletoneClass getInstance() {
        if(instance==null){
            SingletoneClass singletoneClass = new SingletoneClass();
            instance = singletoneClass;
            return instance;
        } else {
            return instance;
        }
    }
}
