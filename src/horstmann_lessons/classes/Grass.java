package horstmann_lessons.classes;
interface GrassInterface1{
    /*default методы имеют реализацию по умолчанию и их не обязательно реализовывать в реализации интерфейса
    * Если их не реализовать они по умолчанию наследуют реализацию из интерфейса*/
    default void methodSample(){
        System.out.println("tttt");
    }
}
interface GrassInterface2{
    default void methodSample(){
        System.out.println("ssss");
    }
}

public class Grass implements GrassInterface2, GrassInterface1{

    @Override
    public void methodSample() { /*если два применяемых интерфейса имеют default методы с одинаковыми названиями
    то при реализации в классе нужно будет
    определить из какого конкретного класса будет идти реализация*/
        GrassInterface2.super.methodSample();
    }
}


