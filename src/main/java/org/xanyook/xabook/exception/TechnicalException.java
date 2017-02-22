package org.xanyook.xabook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class TechnicalException extends RuntimeException {

    private final ErrorCode errorCode;
    private Map<String, Object> properties;

    public TechnicalException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public TechnicalException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public TechnicalException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public TechnicalException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public TechnicalException set(String name, Object value) {
        getProperties().put(name, value);
        return this;
    }

    public Map<String, Object> getProperties(){
        if(null == properties){
            properties = new HashMap<>();
        }
        return properties;
    }

    public ErrorCode getErrorCode(){
        return errorCode;
    }


    public enum TechnicalCode implements ErrorCode {
        DEFAULT_ERROR_CODE;

        @Override
        public String getErrorCode() {
            return this.name();
        }
    }
}
