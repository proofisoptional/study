package horstmann_lessons.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GenericTests {
    interface Interface1{
        void methodnothing();
    }
    static class Test1 implements Interface1{

        public Test1(){

        }

        @Override
        public void methodnothing() {
            System.out.println("Fuck off");
        }
    }

    static class AnotherTest implements Interface1{
        public AnotherTest(){

        }

        @Override
        public void methodnothing() {
            System.out.println("Another test");
        }
    }
    static class TestChild extends Test1{
        public TestChild(){

        }

        @Override
        public void methodnothing() {
            super.methodnothing();
        }
    }

    static class TestChildChild extends TestChild{
        public TestChildChild() {
            super();
        }

        @Override
        public void methodnothing() {
            super.methodnothing();
        }
    }

    public static void Method1(List<? extends Test1> tests){
        System.out.println("Method1");
    }

    public static void Method2(List<? super Test1> tests){
        Object n = tests.get(0);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test1 testchild = new TestChild();
        Interface1 test2 = new Test1();
        Interface1 testchild2 = new TestChild();
        Interface1 anothertest = new AnotherTest();
        TestChild test3 = new TestChild();
        TestChildChild test4 = new TestChildChild();

        Method1(Arrays.asList(test1));
        Method1(Arrays.asList(testchild));
        //Method1(Arrays.asList(test2));
        //Method1(Arrays.asList(testchild2));

        Method2(Arrays.asList(test1));
        Method2(Arrays.asList(testchild));
        Method2(Arrays.asList(test2));
        Method2(Arrays.asList(testchild2));
        Method2(Arrays.asList(test3));
        Method2(Arrays.asList(test4));
        Method2(Arrays.asList(anothertest));
        Method2(Arrays.asList(4, 4, 8));

        List<? extends Number> foo1 = Arrays.asList(2, 4, 5, 6);
        List<? extends Number> foo2 = new ArrayList<Integer>();
        List<? extends Number> foo3 = new ArrayList<Double>();

        Number s = 4;
        // foo1.add((s)); -- cant add a value because cant guarantee that added values
        //will be assigned to classes that are already in List*/
        //For Example s is assigned to Number class but there could be an Integer or Double values in List

        // foo2.add((Integer)4); -- same despite that fact that we already defined that it Integer array list
        //they will have problems because List is defined as List<? extends Number> and it already defined it with any
        //of Integer Double or class that extends Number



        //Therefore we cannot write or modify anything in List with generics using EXTENDS keyword

        List<? extends Number> foo4 = Arrays.asList(2, 4.4, 5, 6.888);

        System.out.println(foo4.get(0)); //we have no problem with reading values from List using generics with EXTENDS keyword
        System.out.println(foo4.get(0).getClass()); //will return Integer
        System.out.println(foo4.get(1).getClass()); //will return Double

        // Double b = foo4.get(1); - foo4 values cannot be assigned to Double because any of these numbers in List could be
        //integer or number despite that foo4.get(1) is already a Double

        // Integer b = foo4.get(0); - same as Double

        Number b = foo4.get(0); // that is ACCEPTABLE becuase any of objects in LIst will be subclasses of Number

        List<? super Integer> foo5 = new ArrayList<Integer>();
        List<? super Integer> foo6 = new ArrayList<Number>();
        List<? super Integer> foo7 = new ArrayList<Object>();
        // List<? super Number> foo8 = new ArrayList<Integer>(); - not acceptable because SUPER means only superclasses of class

        List<? super Integer> foo8 = List.of(4, 5, 8.88); //that accepts any


        //Number n = foo8.get(0);
        //Integer n = foo8.get(0); - in both cases you are not guaranteed that you will get an object of class Integer or Number
        //The only guarantee you can get is that you will get an instance of Object or subclass of Object (but we dont know which one)
        //so we cannot assign values got from List noone class except Object
        Object n = foo8.get(0);

        foo8.add(4); // we can add Integer or subclasses of Integer because we will be sure that
        //subclasses of Integer can be objects of instance Integer
        //Objects of Integer class is allowed in these lists
        //we cannot Number, Object or Double because we cannot be sure that these values will be
        //declared as Integer values



    }
}
