package SuperStore;

abstract class User {

    protected int userid;
    protected String username;
    protected String password;
    public User(int userid, String username, String password){
        this.userid=userid;
        this.username=username;
        this.password=encrypt(password);
    }
    private String encrypt(String password){
        return "ENC+"+password;
    }
public int getId(){
    return userid;
}
}

class Buyer extends User {
    private Cart cart;
public Buyer(int userid, String username, String password){
    super(userid, username, password);
    this.cart=new Cart();
}
public Cart getcart(){
    return cart;
}

}
