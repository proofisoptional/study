package horstmann_lessons.lambda_expressions;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Main2 {

    public interface IntConsumer{
        void accept(int value);
    }
    public static void repeat(int n, IntConsumer action){
        for(int i =0; i< n; i++) action.accept(i);
    }

    public static void consumerTest(Consumer action){
        action.accept("SSss");
    }

    public static void main(String[] args) {
        repeat(10, i -> {
            if(i%2==0){
                System.out.println("Countdown: " + (9-i));
            }
        });
        consumerTest(name -> System.out.println(name));
    }
}
