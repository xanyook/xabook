package org.xanyook.xabook.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.xanyook.xabook.service.model.ResponseBuilder;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {

    private final String ENVELOP_QUERY_PARAM = "envelope";

    @Value("${application.admin.envelope.enabled:false}")
    private boolean envelopeEnabled;


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object returnedBody;

        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();

        boolean isEnvelopRequired = servletRequest.getParameterMap().entrySet().stream()
                    .anyMatch(element -> element.getKey().equals(ENVELOP_QUERY_PARAM) && true == Boolean.valueOf(element.getValue()[0]));

        if(isEnvelopRequired || envelopeEnabled){
            HttpStatus httpStatus = HttpStatus.valueOf(((ServletServerHttpResponse) response).getServletResponse().getStatus());

            ResponseBuilder<Object> builder = new ResponseBuilder<>().withData(body);
            if(!httpStatus.is2xxSuccessful()){
                builder.withError().withMessage(httpStatus.getReasonPhrase());
            }
            returnedBody = builder.build();
        }else {
            returnedBody = body;
        }

        return returnedBody;
    }
}
