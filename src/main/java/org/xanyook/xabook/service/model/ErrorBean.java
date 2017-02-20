package org.xanyook.xabook.service.model;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

public class ErrorBean extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, true);
        errorAttributes.remove("timestamp");
        return errorAttributes;
    }

    @Override
    public Throwable getError(RequestAttributes requestAttributes) {
        return super.getError(requestAttributes);
    }
}
