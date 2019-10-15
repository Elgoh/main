package seedu.address.cashier.logic.exception;

/**
 * Represents a "not a number" error encountered by a parser.
 */
public class NotANumberException extends Exception {

    private String msg;

    public NotANumberException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String toString() {
        return this.msg;
    }
}
