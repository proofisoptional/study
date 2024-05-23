package horstmann_lessons.abstract_classes;

interface Interface1{

    static String method(String s){
        return s.concat("s");
    }
    default String method1(String s){
        return s.concat("s1");
    }
}

interface Interface2{
    default String method1(String s){
        return s.concat("s2");
    }
}

public class Employee extends Person implements Interface1, Interface2{

    public Employee(String name, int age, String address) {
        super(name, age, address);
    }

    @Override
    public String getDescription() {
        return "Very Good Man";
    }

    @Override
    public int hashCode(){
        return 7 * super.getAge() + 15 + super.getName().hashCode();
    }

    @Override
    public String method1(String s) {
        return Interface1.super.method1(s);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Andreson", 22, "Washington");
        System.out.println(employee.method1("qqq"));
    }

}
