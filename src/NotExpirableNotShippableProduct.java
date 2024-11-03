
public class NotExpirableNotShippableProduct extends Products {

    public NotExpirableNotShippableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public double isShippable() {
        return 0;
    }


}
