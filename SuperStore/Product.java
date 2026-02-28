 package SuperStore;
 
 public class Product {
 
    private int productID;
    private String productname;
    private int stock;
    private double price;

    public Product(int id, String name, int stock, double price){
        this.productID=id;
        this.productname=name;
        this.stock=stock;
        this.price=price;

    }
    public void reducestock(int quantity){
     if(quantity> stock)
        throw new RuntimeException("Insufficient Stock");
    stock-=quantity;
    }

    public int getStock(){
        return stock;
    }
    public int getproductID(){
        return productID;
    }
    public String getproductname(){
        return productname;
    }
public double getPrice(){
    return price;
}
 }