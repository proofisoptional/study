package patterns.decorator;

public class BurgerWithKetchup extends FoodDecorator{
    public BurgerWithKetchup(Food food) {
        super(food);
    }

    public String showIngridients() {
        return super.showIngridients() + " and ketchup";
    }
}
