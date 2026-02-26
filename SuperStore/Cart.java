package SuperStore;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items= new HashMap<>();
    public void addToCart(Product product, int quantity){
        items.put(product,items.getOrDefault(product,0 )+quantity );

    }
public Map<Product, Integer> getitems(){
    return items;
}
    
}
