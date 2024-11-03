import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Customer customer = new Customer("Yousef Hesham", 5000);
//            Customer customer2 = new Customer("John Doe", 5000);


            Products Cheese = new ExpirableProduct("Cheese", 250, 20, LocalDate.of(2024, 11, 13));

            Products tv = new ExpirableShippableProduct("tv", 250, 20, 13, LocalDate.of(2024, 11, 13));

            Products temp2 = new NotExpirableNotShippableProduct("name", 250, 20);

            Products orange = new ShippableProduct("orange", 250, 20, 200.25);


            customer.addToCart(Cheese, 2);
            customer.addToCart(orange, 2);
            customer.addToCart(tv, 2);

            customer.checkout();

//            customer2.addToCart(orange,18);
//            customer2.checkout();

            customer.addToCart(orange, 2);
            customer.checkout();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("done");
    }
}