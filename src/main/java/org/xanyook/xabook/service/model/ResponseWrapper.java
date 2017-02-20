package org.xanyook.xabook.service.model;

public class ResponseWrapper<T> {

    private T data;
    private ReturnedStatus status;
    private String message;

    public ResponseWrapper() {
        this.status = ReturnedStatus.SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ReturnedStatus getStatus() {
        return status;
    }

    public void setStatus(ReturnedStatus status) {
        this.status = status;
    }
    public enum ReturnedStatus{

        ERROR("ERROR"),
        SUCCESS("SUCCESS");

        private String value;

        ReturnedStatus(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }
    }




}
