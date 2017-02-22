package org.xanyook.xabook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode errorCode) {
            super(errorCode);
    }

    public EntityNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public EntityNotFoundException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }

    @Override
    public EntityNotFoundException set(String name, Object value) {
        super.set(name, value);
        return this;
    }

    public enum NotFoundCode implements ErrorCode {
        AUTHOR_NOT_FOUND,
        RESSOURCE_NOT_FOUND,
        BOOK_NOT_FOUND;


        @Override
        public String getErrorCode() {
            return this.name();
        }
    }
}
