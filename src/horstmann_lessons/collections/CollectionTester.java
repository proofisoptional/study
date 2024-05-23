package horstmann_lessons.collections;

import java.util.*;

public class CollectionTester {
    public static void CollectionTesting(){
        LinkedList<String> array = new LinkedList<>(Arrays.asList("Test1", "Test2", "Test3", "Test4", "Test5"));
        ListIterator<String> iter = array.listIterator(); /*при объявлении итератор находится до первого элемента, чтобы обратиться
        к первому элементу нужно провести iter.next()*/
        while(iter.hasNext()){
            String s = iter.next();
            if(s.equals("Test4")){
                iter.remove();
            }
        }
        while(iter.hasPrevious()){
            String s = iter.previous();
            if(s.equals("Test2")){
                /*array.add("ttt");*/ /*ConcurrentModificationException = нельзя модифицировать коллекцию во время итерирования по ней*/
                iter.add("AddedValue"); /*но можно добавлять элементы в коллекцию через итератор*/
            }
            if(s.equals("Test3")){
                iter.set("ReplacedValue"); /*и даже заменять значения в коллеции*/
            }
        }
        for(String s: array){
            System.out.print(s + " ");
        }
    }

    public static void CollectionTesting2(){
        LinkedList<String> array = new LinkedList<>(Arrays.asList("Test1", "Test2", "Test3", "Test4", "Test5"));
        for(String s: array){ /*Используется 1-ый итератор*/
            if(s.equals("Test2")){
                array.add("Temp"); /*Используется 2-ой итератор который пытается изменить коллекцию
                ConcurrentModificationException*/
            }
            System.out.println(s);
        }

    }

    public static void CollectionTesting3(){
        var staff = new LinkedList<String>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        ListIterator<String> iter = staff.listIterator();
        iter.next();
        iter.add("Juliet"); /*no Exception - we can add element while iterating using iterator*/
        for(String s: staff){
            System.out.print(s);
        }
    }

    public static void CollectionTesting4(){
        var staff = new LinkedList<String>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");

        ListIterator<String> iter  = staff.listIterator(2);

        System.out.println(iter.previous());
    }

    public static void main(String[] args) {
        CollectionTesting4();
    }
}
