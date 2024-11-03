

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart implements CartInterface{

    private Map<Products, Integer> items = new HashMap<>();

    @Override
    public void addProduct(Products product, int quantity) throws Exception {
        if (quantity > product.getQuantity()) {
           throw new Exception("Requested quantity of "+product.getName() +" is not available in stock."+product.getQuantity());
        }
        if(product.isExpired()){
            throw new Exception("Requested "+product.getName() +" is Expired.");

        }
            items.put(product, quantity);
            product.setQuantity(product.getQuantity() - quantity);
    }

    @Override
    public double calculateSubtotal() {
        double total = 0;
        for(Products tempproduct: this.getShippableItems()){
            String key = tempproduct.getName().toString();
            double price = tempproduct.getPrice();
            String value = this.getItems().get(tempproduct).toString();
            total = total +(price*Integer.parseInt(value));
        }
//        System.out.println(total);
        return total;

    }

    @Override
    public List<Products> getShippableItems() {
        List<Products> shippableItems = new ArrayList<>();
        for (Products product : items.keySet()) {
            if(product instanceof ShippableProduct || product instanceof ExpirableShippableProduct) {
                shippableItems.add(product);
            }
        }
        return shippableItems;
    }

    @Override
    public void clearCart() {
        items.clear();
    }

    @Override
    public Map<Products, Integer> getItems() {
        return items;
    }



    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
