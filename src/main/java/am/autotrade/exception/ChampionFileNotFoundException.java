package am.autotrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChampionFileNotFoundException extends RuntimeException {
    public ChampionFileNotFoundException(String message) {
        super(message);
    }

    public ChampionFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
