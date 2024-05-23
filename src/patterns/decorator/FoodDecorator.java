package patterns.decorator;

public class FoodDecorator implements Food{
    private Food food;
    public FoodDecorator(Food food){
        this.food = food;
    }
    @Override
    public String showIngridients() {
        return food.showIngridients();
    }
}
