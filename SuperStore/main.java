package SuperStore;

import java.util.Scanner;

public class main {
    public static void  main(String args[]) {
        Scanner sc=new Scanner(System.in);
        InventoryService1 in=new InventoryService1();
        in.additems(new Product(1, "Teddy Bracelet", 20, 150));
         in.additems(new Product(2, "Evil Eye Bracelet", 10, 150));
         in.additems(new Product(3, "Clear crystal Bracelet", 3, 150));

        System.out.println("Enter  the Name");
        String name=sc.next();
        System.out.println("Enter the password");
        String password=sc.next();
        Buyer buy=new Buyer(1, name, password);
        boolean run=true;
        while(run){
             System.out.println("\n--- MENU ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
sc.nextLine();
            switch (choice) {
                case 1:
                   System.out.println("\nAvailable Products:");
                    for (Product p : in.listInventory()) {
                        System.out.println("ID: " + p.getproductID() +
                            " | Name: " + p.getproductname() +
                            " | Stock: " + p.getStock() +
                            " | Price: $" + p.getPrice());
                    }
                    break;
                

            
                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Quantity: ");
                    int qty = Integer.parseInt(sc.nextLine());

                    Product found = null;
                    for (Product p : in.listInventory()) {
                        if (p.getproductID() == id) {
                            found = p;
                            break;
                        }
                    }
                    if (found != null) {
                        buy.getcart().addToCart(found, qty);
                        System.out.println("Added to cart!");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nYour Cart:");
                    if (buy.getcart().getitems().isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        double total = 0;
                        for (var entry : buy.getcart().getitems().entrySet()) {
                            double subtotal = entry.getKey().getPrice() * entry.getValue();
                            System.out.println(entry.getKey().getproductname() +
                                " x" + entry.getValue() + " = $" + subtotal);
                            total += subtotal;
                        }
                        System.out.println("Total: $" + total);
                    }
                    break;

                case 4:
                    if (buy.getcart().getitems().isEmpty()) {
                        System.out.println("Cart is empty!");
                        break;
                    }
                    try {
                        OrderService orderService = new OrderService();
                        orderService.buyitem(buy);

                        double total = 0;
                        for (var entry : buy.getcart().getitems().entrySet()) {
                            total += entry.getKey().getPrice() * entry.getValue();
                        }

                        System.out.println("\nChoose Payment Method:");
                        System.out.println("1. UPI");
                        System.out.println("2. Card");
                        System.out.print("Choose: ");
                        int payChoice = Integer.parseInt(sc.nextLine());

                        PaymentService payment = (payChoice == 1) ? new UPIPayment() : new CardPayment();
                        payment.makepayment(total);

                    } catch (RuntimeException e) {
                        System.out.println("Order failed: " + e.getMessage());
                    }
                    break;

                case 5:
                    run = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}

        
    
