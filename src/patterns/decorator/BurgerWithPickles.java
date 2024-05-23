package patterns.decorator;

public class BurgerWithPickles extends FoodDecorator{
    public BurgerWithPickles(Food food) {
        super(food);
    }

    public String showIngridients() {
        return super.showIngridients() + " and pickles";
    }
}
