package main.java.com.fis.exceptions;

public class WMFatalException extends RuntimeException {
    public static final boolean ROBOT_EXIT_ON_FAILURE = true;

    public WMFatalException() {
        super();
    }

    public WMFatalException(String string) {
        super(string);
    }

    public WMFatalException(Throwable t) {
        super(t);
    }

    public WMFatalException(String string, Throwable t) {
        super(string, t);
    }
}
