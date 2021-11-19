package main.java.com.fis.exceptions;

public class WMNonFatalException extends RuntimeException {
    /**
     * Mark this exception as fatal
     */
    public static final boolean ROBOT_EXIT_ON_FAILURE = true;

    public WMNonFatalException() {
        super();
    }

    public WMNonFatalException(String string) {
        super(string);
    }

    public WMNonFatalException(Throwable t) {
        super(t);
    }

    public WMNonFatalException(String string, Throwable t) {
        super(string, t);
    }
}
