import java.util.HashMap;

public class Bar {
    private final HashMap<String, Double> Drinks;
    private final HashMap<String, DiscountStrategy> Customer;

    Bar(){

        Drinks = new HashMap<>();
        Drinks.put("Beer", 5.0);
        Drinks.put("Vodka", 8.0);
        Drinks.put("Martini", 9.0);

        Customer = new HashMap<>();
        Customer.put("Alan", new RelativesDiscount());
        Customer.put("Betty", new MemberDiscount());

    }

    public double buyDrink(String name, String drink){

        if(Drinks.get(drink)==null){
            System.out.println("Drink not exist!");
            return -1;
        }

        DiscountStrategy discountStrategy = Customer.get(name);

        if (discountStrategy == null) { discountStrategy = new CustomerDiscount(); }
        double discount = discountStrategy.discount();
        double price = Drinks.get(drink) * (1-discount);

        System.out.printf("%s orders the drink <%s>, with <%s> %.1f%% off, price %.2f $\n",
                name, drink,
                discountStrategy.getClass().getName(),
                discount * 100,
                price
        );

        return price;
    }

}
