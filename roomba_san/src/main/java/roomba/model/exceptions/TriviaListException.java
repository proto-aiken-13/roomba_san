package roomba.model.exceptions;

public class TriviaListException extends Exception {
    public TriviaListException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code CommandException} with the specified detail {@code message} and {@code cause}.
     */
    public TriviaListException(String message, Throwable cause) {
        super(message, cause);
    }
}
