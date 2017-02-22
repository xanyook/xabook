package org.xanyook.xabook.service.model;

import org.xanyook.xabook.util.Builder;
import org.xanyook.xabook.exception.ErrorCode;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

public class ErrorResponse {

    private final Instant time;
    private final String message;
    private final String code;
    private final String cause;
    private final String path;

    private ErrorResponse(ErrorResponseBuilder builder){
        this.time = builder.time;
        this.message = builder.message;
        this.code = builder.code;
        this.cause = builder.cause;
        this.path = builder.path;
    }

    public Instant getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getCause() {
        return cause;
    }

    public String getPath() {
        return path;
    }

    public static class ErrorResponseBuilder implements Builder<ErrorResponse>{

        private Instant time;
        private String message;
        private String code;
        private String cause;
        private String path;

        public ErrorResponseBuilder(ErrorCode errorCode, HttpServletRequest request){
            StringBuffer requestURL = request.getRequestURL();
            if(null != request.getQueryString()){
                requestURL.append("?").append(request.getQueryString());
            }
            this.path = requestURL.toString();
            this.code = errorCode.getErrorCode();
            this.time = Instant.now();
        }

        public ErrorResponseBuilder triggeredBy(Exception e){
            this.cause = e.getClass().getCanonicalName();
            return this;
        }

        public ErrorResponseBuilder withMessage(String message){
            this.message = message;
            return this;
        }

        @Override
        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }

}
