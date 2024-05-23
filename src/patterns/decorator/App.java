package patterns.decorator;

public class App {
    public static void main(String[] args) {
        Food food = new BurgerWithKetchup(new Burger());
        System.out.println(food.showIngridients());

        food = new BurgerWithPickles(food);
        System.out.println(food.showIngridients());
    }

}
