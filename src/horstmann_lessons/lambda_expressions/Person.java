package horstmann_lessons.lambda_expressions;

import java.util.ArrayList;
import java.util.List;

interface Predicate<Person> {
    boolean test(Person t);
}

public class Person {
    public enum Sex{
        MALE, FEMALE
    }
    String name;
    Sex gender;
    String emailAddress;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, Sex gender, String emailAddress, int age) {
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public void printPerson(){
        System.out.println("Name: " + this.name + ", age: " + this.age + ", address: " + this.emailAddress);
    }

    public static void printPersonsWithPredicate(List<Person> persons, Predicate<Person> tester){
        for(Person p : persons){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", Sex.FEMALE, "alice.anderson@gmail.com", 25);
        Person p2 = new Person("Arthur", Sex.MALE, "arthur.morgan@gmail.com", 37);
        Person p3 = new Person("John", Sex.MALE, "john.dow@gmail.com", 31);
        Person p4 = new Person("Cassandra", Sex.FEMALE, "cassandra.andolini@yahoo.com", 29);

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        //printPersonsWithPredicate(personList, s -> s.age < 30); /*print persons under some age*/
        printPersonsWithPredicate(personList, s -> s.name.equals("Alice")); /*print Alice*/
    }
}
