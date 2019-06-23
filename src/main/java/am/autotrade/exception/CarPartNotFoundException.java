package am.autotrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CarPartNotFoundException extends RuntimeException {

    public CarPartNotFoundException() {
        super();
    }
    public CarPartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CarPartNotFoundException(String message) {
        super(message);
    }
    public CarPartNotFoundException(Throwable cause) {
        super(cause);
    }
}
