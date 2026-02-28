package SuperStore;

public interface PaymentService {

    void makepayment(double amount);

} 
 class UPIPayment implements PaymentService {
    public void makepayment(double amount){
        System.out.println(
       "Paid :"+amount     
        );
    }
}
 class CardPayment implements PaymentService {
    public void makepayment(double amount){
        System.out.println("Paid : "+amount);
    }

    
}