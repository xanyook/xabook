package org.xanyook.xabook.service.model;

public class ResponseBuilder<T> {

    private ResponseWrapper<T> responseWrapper;

    public ResponseBuilder() {
        this.responseWrapper = new ResponseWrapper<T>();
    }

    public ResponseWrapper<T> build(){
        return this.responseWrapper;
    }

    public ResponseBuilder<T> withData(T data){
        this.responseWrapper.setData(data);
        return this;
    }

    public ResponseBuilder<T> withError(){
        this.responseWrapper.setStatus(ResponseWrapper.ReturnedStatus.ERROR);
        return this;
    }

    public ResponseBuilder<T> withMessage(String message){
        this.responseWrapper.setMessage(message);
        return this;
    }

}
