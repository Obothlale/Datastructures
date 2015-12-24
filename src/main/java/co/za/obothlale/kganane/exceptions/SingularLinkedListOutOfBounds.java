package co.za.obothlale.kganane.exceptions;

/**
 * Created by Obothlale on 2015-05-04.
 *
 */
public class SingularLinkedListOutOfBounds extends Exception {
    public SingularLinkedListOutOfBounds(String message){
        super(message);
    }

    public SingularLinkedListOutOfBounds(String message, Throwable cause){
        super(message,cause);
    }
}
