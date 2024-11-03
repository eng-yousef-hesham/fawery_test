


import java.time.LocalDate;

public class ExpirableShippableProduct extends Products  {
    private double weight;
    private LocalDate expiryDate;

    public ExpirableShippableProduct(String name, double price, int quantity, double weight,LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }


    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public double isShippable() {
        return weight;
    }

}