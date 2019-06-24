package am.autotrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException() {
        super();
    }
    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CarNotFoundException(String message) {
        super(message);
    }
    public CarNotFoundException(Throwable cause) {
        super(cause);
    }
}
