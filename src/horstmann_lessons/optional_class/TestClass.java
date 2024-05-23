package horstmann_lessons.optional_class;

import java.util.Optional;

public class TestClass {
    public static void testMethod(String name){
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.isPresent());
        opt.ifPresent(s -> System.out.println(s.length()));
        opt.ifPresentOrElse(s -> System.out.println(s.length()), () -> System.out.println("fAIL"));
        String s = opt.orElse("Sergey");
        System.out.println(s);
    }

    public static void main(String[] args) {
        testMethod(null);
    }
}
