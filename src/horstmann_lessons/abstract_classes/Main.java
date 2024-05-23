package horstmann_lessons.abstract_classes;

public class Main {
    public static void main(String[] args) {
        Person p;

        Person[] persons = new Person[3];

        persons[0] = new Employee("Arthur", 15, "Uralsk");

        if(persons[0].getClass() == Employee.class){
            System.out.println("success");
        }

        Employee e = new Employee("Arthur", 15, "sss");
    }
}
