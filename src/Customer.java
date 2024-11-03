
import java.util.List;

public class Customer  {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public void addToCart(Products product, int quantity) throws Exception {

        cart.addProduct(product, quantity);

    }

    public void checkout() throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty. Please add items to cart.");
        }

        double subtotal = cart.calculateSubtotal();
        double shippingFee = calculateShippingFee(cart.getShippableItems());
        double total = subtotal + shippingFee;

        try {

        }catch (Exception e) {}



        if (total > balance) {
            throw new Exception("Insufficient balance.");
        }



        processOrder(subtotal, shippingFee, total);
    }

    private double calculateShippingFee(List<Products> shippableItems) {
        double totalweight = 0;
        for(Products tempproduct: cart.getShippableItems()) {
            double weight = tempproduct.isShippable();
            String value = cart.getItems().get(tempproduct).toString();
            totalweight = totalweight + (Integer.parseInt(value) * weight);
        }
        ;
        return totalweight/10;
    }

    private void processOrder(double subtotal, double shippingFee, double total) {
        balance -= total;
        double totalweight = 0;


        System.out.println("\n** All products in cart **");
        for(Products tempproduct: cart.getItems().keySet()){
            String key = tempproduct.getName().toString();
            String value = cart.getItems().get(tempproduct).toString();
            System.out.println(key + ": " + value);
        }
        System.out.println("*************************\n");

        System.out.println("** Shippable notice **");
        for(Products tempproduct: cart.getShippableItems()){
            String key = tempproduct.getName().toString();
            double weight = tempproduct.isShippable();
            String value = cart.getItems().get(tempproduct).toString();
            totalweight=totalweight+(Integer.parseInt(value)*weight);

            System.out.println( value +"x "+key + "   " +weight+"g");
        }
        System.out.println("Total package weight "+totalweight);
        System.out.println("*************************\n");


        System.out.println("** Checkout receipt **");
        for(Products tempproduct: cart.getShippableItems()){
            String key = tempproduct.getName().toString();
            double Price = tempproduct.getPrice();
            String value = cart.getItems().get(tempproduct).toString();

            System.out.println( value +"x "+key + "  price : " +Price);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Shipping Fee: $" + shippingFee);
        System.out.println("Total Paid Amount: $" + total);
        System.out.println("Remaining Balance: $" + balance);
        System.out.println("*************************\n");
        cart.clearCart();
    }

    public double getBalance() {
        return balance;
    }
}

