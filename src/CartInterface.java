





import java.util.List;
import java.util.Map;


public interface CartInterface {
    public void addProduct(Products product, int quantity) throws Exception;

    public double calculateSubtotal();

    public List<Products> getShippableItems();

    public void clearCart();

    public Map<Products, Integer> getItems();

    public boolean isEmpty();
}
