




public class ShippableProduct extends Products {
    private double weight;


    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }


    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public double isShippable() {
        return weight;
    }


}
