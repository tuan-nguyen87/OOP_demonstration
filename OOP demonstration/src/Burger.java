// Burger class inherits from the Item class
public class Burger extends Item{

    private Item topping1;
    private Item topping2;
    private Item topping3;

    public Burger(String name, double price){
        super(name, "Burger", price);
    }

    @Override
    public String getName() {
        return super.getName() + " Burger";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasedPrice() +
                ((topping1 == null) ? 0 : topping1.getAdjustedPrice()) +
                ((topping2 == null) ? 0 : topping2.getAdjustedPrice()) +
                ((topping3 == null) ? 0: topping3.getAdjustedPrice());
    }

    public double getExtraPrice(String toppingName){

        return switch(toppingName.toUpperCase()){
          case "AVOCADO", "CHEESE", "GRILLED MUSHROOMS", "GRILLED ONIONS" -> 1.25;
          case "EXTRA PATTY", "BACON" -> 1.75;
            default -> 0.0;
        };
    }
    public void addToppings(String topping1, String topping2, String topping3){
        this.topping1 = new Item(topping1, "Topping", getExtraPrice(topping1));
        this.topping2 = new Item(topping2, "Topping", getExtraPrice(topping2));
        this.topping3 = new Item(topping3, "Topping", getExtraPrice(topping3));
    }

    public void printItemizedList(){

        printItem("Based Burger", getBasedPrice());
        if(topping1 != null){
            topping1.printItem();
        }
        if(topping2 != null){
            topping2.printItem();
        }
        if(topping3 != null){
            topping3.printItem();
        }

    }
    @Override
    public void printItem() {
        printItemizedList();
        System.out.printf("-".repeat(30) + "%n" );
        super.printItem();
    }
}
