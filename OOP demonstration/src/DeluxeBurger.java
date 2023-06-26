// deluxr burger class that inherit from the burger class
public class DeluxeBurger extends Burger{

    private Item deluxe1;
    private Item deluxe2;

    // default constructor Deluxe burger parameter comes from the burger class
    public DeluxeBurger(String name, double price){
        super(name, price);
    }

    // a method that that allows up to 5 toppings to be added to deluxe burger only.
    // using super() to get the first 3 from the parent burger class
    // deluxe2 object uses the override getExtraPrice method.
    public void addToppings(String topping1, String topping2, String topping3, String topping4, String topping5) {
        super.addToppings(topping1, topping2, topping3);
        deluxe1 = new Item(topping4,"Topping", 0);
        deluxe2 = new Item(topping5, "Topping", getExtraPrice(topping5));
    }

    // a printItem method that overrides the burger printItem method
    // printes the item of the deluxe burgers as well as getting name and price
    @Override
    public void printItem() {
        super.printItemizedList();

        if(deluxe1 != null){
            deluxe1.printItem();
        }
        if(deluxe2 != null){
            deluxe2.printItem();
        }
        System.out.printf("-".repeat(30) + "%n" );
        System.out.printf("%20s:\t$%4.2f%n", getName().toUpperCase(), getAdjustedPrice());
    }

    // a method to override the burger extra price method.
    // return 0 for the extra toppings
    @Override
    public double getExtraPrice(String toppingName) {
        return 0;
    }
}
