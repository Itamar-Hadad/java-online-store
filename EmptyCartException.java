package onlinestore;

public class EmptyCartException extends Exception{
    public EmptyCartException(){
        super("This buyer cart is empty");
    }
}
