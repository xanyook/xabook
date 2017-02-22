package org.xanyook.xabook.exception;

import java.util.HashMap;
import java.util.Map;

public abstract class BusinessException extends Exception {

    private final ErrorCode errorCode;
    private Map<String, Object> properties;

    public BusinessException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BusinessException set(String name, Object value) {
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


}
