package nl;

public class NLException extends RuntimeException {
    public NLException() {
    }

    public NLException(String message) {
        super(message);
    }

    public NLException(String message, Throwable cause) {
        super(message, cause);
    }

    public NLException(Throwable cause) {
        super(cause);
    }

    public NLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public boolean isInternalError(){
        return true;
    }
}