package SuperStore;

import java.util.Map;

public class OrderService {
    public void buyitem(Buyer buyer){
        for(Map.Entry<Product, Integer> entry: buyer.getcart().getitems().entrySet()){
            Product product=entry.getKey();
            int qty= entry.getValue();
            if(product.getStock()<qty){
                throw new RuntimeException("No Stock Available");

            }
        
        product.reducestock(qty);
    }
System.out.print("Order Placed Successfully");
}
}
