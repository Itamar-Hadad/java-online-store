package onlinestore;

public class StringEmptyNullException extends Exception{
    public StringEmptyNullException(String string){
        super(string + " cannot be null or empty");
    }
}
