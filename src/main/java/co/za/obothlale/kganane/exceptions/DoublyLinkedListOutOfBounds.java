package co.za.obothlale.kganane.exceptions;

/**
 * Created by Obothlale on 2015-05-04.
 *
 */
public class DoublyLinkedListOutOfBounds extends Exception {
    public DoublyLinkedListOutOfBounds(String message){
        super(message);
    }

    public DoublyLinkedListOutOfBounds(String message,Throwable cause){
        super(message,cause);
    }
}
