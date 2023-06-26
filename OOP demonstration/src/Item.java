public class Item {

    private String name;
    private String type;
    private double price;
    private String size = "MEDIUM";

    // constructor that takes in parameter. Default size is set to medium
    // using toUpperCase() quality of life
    public Item(String name, String type, double price){
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.price = price;
    }

    // return the name of either the Side or Drink else return name of item
    public String getName(){

        if(type.equals("SIDE") || type.equals("DRINK")){
            return size + " " + name;
        }

        return (name);
    }

    // get based price without the extra charges
    public double getBasedPrice(){
        return price;
    }

    // set the size of our items.
    public void setSize ( String size){
        this.size = size.toUpperCase();
    }

    // get the price adjustment if size was changed
    public double getAdjustedPrice(){
        return switch(size){
            case "SMALL" -> getBasedPrice() - 0.75;
            case "LARGE" -> getBasedPrice() + 1.25;
            default -> getBasedPrice();
        };
    }

    // using string formatter to print name and price of item
    // static method as this will use field names
    public static void printItem(String name, double price){
        System.out.printf("%20s:\t$%4.2f%n", name.toUpperCase(), price);

    }

    public void printItem(){
        printItem(getName(), getAdjustedPrice());
    }
}
