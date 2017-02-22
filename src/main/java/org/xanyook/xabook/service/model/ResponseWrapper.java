package org.xanyook.xabook.service.model;

import org.xanyook.xabook.util.Builder;

public class ResponseWrapper<T> {

    private final T data;
    private final ReturnedStatus status;
    private final String message;

    private ResponseWrapper(ResponseWrapperBuilder<T> builder) {
        this.data = builder.data;
        this.status = builder.status;
        this.message = builder.message;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ReturnedStatus getStatus() {
        return status;
    }

    public enum ReturnedStatus {

        ERROR("ERROR"),
        SUCCESS("SUCCESS");

        private String value;

        ReturnedStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static class ResponseWrapperBuilder<T> implements Builder<ResponseWrapper> {

        private T data;
        private ReturnedStatus status;
        private String message;


        public ResponseWrapperBuilder() {
            status = ReturnedStatus.SUCCESS;
        }

        @Override
        public ResponseWrapper<T> build() {
            return new ResponseWrapper(this);
        }

        public ResponseWrapperBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }

        public ResponseWrapperBuilder<T> withError() {
            this.status = ReturnedStatus.ERROR;
            return this;
        }

        public ResponseWrapperBuilder<T> withMessage(String message) {
            this.message = message;
            return this;
        }
    }
}
