package BookStore.Bookstore.Exception;

public class ExceptionBase {
    protected String message;
    protected int error_code;

    public ExceptionBase(String message, int error_code) {
        this.message = message;
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
