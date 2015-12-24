package co.za.obothlale.kganane.exceptions;

/**
 * Created by Obothlale on 2015-05-07.
 *
 */
public class CircularLinkedListOutOfBounds extends Exception {
    public CircularLinkedListOutOfBounds(String message){
        super(message);
    }

    public CircularLinkedListOutOfBounds(String message,Throwable cause){
        super(message,cause);
    }
}
