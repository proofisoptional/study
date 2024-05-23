package patterns.builder;

public class App {
    public static void main(String[] args) {
        Truck truck = Truck.builder().owner("dasda").power(2233).trailer("yes").build();
        System.out.println(truck);
    }
}
