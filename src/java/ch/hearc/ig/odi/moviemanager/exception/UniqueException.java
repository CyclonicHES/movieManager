package ch.hearc.ig.odi.moviemanager.exception;

/**
 * gestion des exceptions
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
public class UniqueException extends Exception {

    /**
     * violation de contrainte d'unicité
     */
    public UniqueException() {
        super();
    }

    /**
     * violation d'une contreinte d'unicité
     * 
     * @param message message de l'exception
     */
    public UniqueException(final String message) {
        super(message);
    }

    /**
     * violation d'une contreinte d'unicité
     * 
     * @param cause cause
     */
    public UniqueException(final Throwable cause) {
        super(cause);
    }

    /**
     * violation d'une contreinte d'unicité
     * 
     * @param message message
     * @param cause cause
     */
    public UniqueException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
}
