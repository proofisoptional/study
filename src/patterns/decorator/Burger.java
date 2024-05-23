package patterns.decorator;

public class Burger implements Food{
    @Override
    public String showIngridients() {
        return "Burger with cheese and chicken";
    }
}
