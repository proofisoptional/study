package horstmann_lessons.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7, 9, 14, 22);
        //list.stream().parallel().forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));
        //list.parallelStream().forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));

        int list2 = list.get(2) + 4;
        int[] arr = new int[]{1,2,3,4};
        Optional<Integer> opt = list.stream().parallel().filter(n -> n>2).findFirst();
        System.out.println(opt);

    }
}

