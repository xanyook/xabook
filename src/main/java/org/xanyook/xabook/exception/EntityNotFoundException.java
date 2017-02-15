package org.xanyook.xabook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = -3241367607909376040L;

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super( message );
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super( message, cause );
    }

    public EntityNotFoundException(Throwable cause) {
        super( cause );
    }

}
