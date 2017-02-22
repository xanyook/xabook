package org.xanyook.xabook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.xanyook.xabook.exception.BusinessException;
import org.xanyook.xabook.exception.ErrorCode;
import org.xanyook.xabook.exception.TechnicalException;
import org.xanyook.xabook.service.model.ErrorResponse;
import org.xanyook.xabook.service.model.ErrorResponse.ErrorResponseBuilder;
import org.xanyook.xabook.service.model.ResponseWrapper.ResponseWrapperBuilder;
import org.xanyook.xabook.util.ErrorCodeUtils;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {

    private final String ENVELOP_QUERY_PARAM = "envelope";

    private ErrorCodeUtils errorCodeUtils;
    @Value("${application.admin.envelope.enabled:false}")
    private boolean envelopeEnabled;

    @Autowired
    public AdviceController(ErrorCodeUtils errorCodeUtils) {
        this.errorCodeUtils = errorCodeUtils;
    }

    private ErrorResponse buildResponse(Exception e, HttpServletRequest request, ErrorCode errorCode){
        return new ErrorResponseBuilder(errorCode, request)
                .triggeredBy(e)
                .withMessage(errorCodeUtils.getMessage(errorCode))
                .build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessExceptions(BusinessException e, HttpServletRequest request){
        ErrorResponse businessErrorResponse = buildResponse(e, request, e.getErrorCode());
        ResponseStatus responseStatusAnnotation = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        return new ResponseEntity<>(businessErrorResponse, responseStatusAnnotation.code());
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ErrorResponse> handleTechnicalException(TechnicalException e, HttpServletRequest request) {
        ErrorResponse technicalErrorResponse = buildResponse(e, request, e.getErrorCode());
        ResponseStatus responseStatusAnnotation = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        return new ResponseEntity<>(technicalErrorResponse, responseStatusAnnotation.code());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedException(Exception e, HttpServletRequest request){
        ErrorCode defaultErrorCode = errorCodeUtils.getDefaultErrorCode();
        ErrorResponse unknownErrorResponse = buildResponse(e, request, defaultErrorCode);
        return new ResponseEntity<>(unknownErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object returnedBody;

        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();

        boolean isEnvelopRequired = servletRequest.getParameterMap().entrySet().stream().anyMatch(element -> element.getKey().equals(ENVELOP_QUERY_PARAM) && Boolean.valueOf(element.getValue()[0]));

        if(isEnvelopRequired || envelopeEnabled){
            HttpStatus httpStatus = HttpStatus.valueOf(((ServletServerHttpResponse) response).getServletResponse().getStatus());

            ResponseWrapperBuilder<Object> builder = new ResponseWrapperBuilder<>().withData(body);

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
