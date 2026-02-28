package SuperStore;

import java.util.ArrayList;
import java.util.List;

public interface InventoryService {
void additems(Product product);
void updateitems(Product product);  // interface methods are by default public  and abstract    
List<Product> listInventory();
    
} 
class InventoryService1 implements InventoryService{
    private List<Product> products=new ArrayList<>();
   public  void additems(Product product){
        products.add(product);
    }
    public void updateitems(Product product){

    }
    public List<Product> listInventory(){
        return products;
    }
}