package onlinestore;

public class NegativeNumException extends Exception{
    public NegativeNumException(String string) {
        super(string + " cannot be negative");
    }

}
