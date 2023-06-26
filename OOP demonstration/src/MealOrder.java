public class MealOrder {

    private Burger burger;
    private Item side;
    private Item drink;

    // instantiate a meal order with no parameter passed. Set a default value of regular, fries, and coke.
    // chain constructor to set default value
    public MealOrder(){
        this("Regular", "Fries", "Coke");
    }

    // instantiate a custom meal order. If meal order is deluxe, standard price will be set else charge regular price
    public MealOrder(String burger, String side, String drink){
        if(burger.equalsIgnoreCase("deluxe")){
            this.burger = new DeluxeBurger(burger, 9.5);
        }else {
            this.burger = new Burger(burger, 3.75);
        }
        this.side = new Item(side, "side", 1.75);
        this.drink = new Item(drink, "drink", 1.25);
    }

    // add up to 3 toppings on all burgers except for deluxe burger
    public void addTopping(String topping1, String topping2, String topping3){
        burger.addToppings(topping1, topping2, topping3);
    }

    // overloaded addTopping method for deluxe burgers. up to 5 toppings can be added
    public void addTopping(String topping1, String topping2, String topping3, String topping4, String topping5){
        if(burger instanceof DeluxeBurger db){
            db.addToppings(topping1, topping2, topping3, topping4, topping5);
        }else {
            burger.addToppings(topping1, topping2, topping3);
        }
    }

    // Set the size of the drinks
    public void setDrinkSize(String drinkSize){
        drink.setSize(drinkSize);
    }

    // if deluxe burger than get the adjusted price only, else, get all prices
    public double getTotalPrice(){
        if(burger instanceof DeluxeBurger){
            return burger.getAdjustedPrice();
        }
        return burger.getAdjustedPrice() + side.getAdjustedPrice() + drink.getAdjustedPrice();
    }

    // print an itemized list of customer's order
    public void printItemizedOrder(){
        //print the burger list from the burger class if burger is deluxe, set the side and drink to 0
        // as deluxe meal have their own standard pricing
        burger.printItem();
        if(burger instanceof  DeluxeBurger){
            Item.printItem(side.getName(), 0);
            Item.printItem(drink.getName(), 0);
        }else{
            side.printItem();
            drink.printItem();
        }
    }

    // called the printItemizedOrder method and also format the receipt.
    public void printMealOrder(){
        printItemizedOrder();
        System.out.println("-".repeat(30));
        System.out.printf("%20s:\t$%4.2f%n","Total", getTotalPrice());
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));

    }

}
