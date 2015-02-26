package exceptions;

/**
 * Created by Denis Makarov on 26.02.2015.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String s) {
        throw new RuntimeException(s);
    }
}