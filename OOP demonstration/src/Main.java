public class Main {
    public static void main(String[] args) {

        Item drink = new Item("Coke", "Drink", 1.75);
        Item fries = new Item("Fries", "side", 2.50);
        MealOrder meal = new MealOrder();
        MealOrder meal2 = new MealOrder("Regular", "Fries", "Coke");
        MealOrder deluxeMeal = new MealOrder("Deluxe", "Fries", "Coke");


//        drink.printItem();
//        drink.setSize("small");
//        drink.printItem();
//
//        fries.printItem();
//        fries.setSize("large");
//        fries.printItem();
//
//        Burger burger = new Burger("Regular", 3.5);
//        burger.addToppings("Bacon", "Cheese", "Grilled Onions");
//        burger.printItem();

//        meal.addTopping("Bacon", "grilled mushrooms", "BBQ sauce");
//        meal.setDrinkSize("large");
//        meal.printMealOrder();

        meal2.addTopping("bacon", "extra patty", "cheese", "bacon", "BBQ Sauce");
        meal2.setDrinkSize("large");
        meal2.printMealOrder();

        deluxeMeal.addTopping("Extra Patty", "bacon", "cheese", "grilled Onions", "mayo");
        deluxeMeal.printMealOrder();

    }
}