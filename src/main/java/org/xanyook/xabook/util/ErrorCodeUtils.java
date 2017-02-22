package org.xanyook.xabook.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xanyook.xabook.exception.ErrorCode;
import org.xanyook.xabook.exception.TechnicalException;
import org.xanyook.xabook.processor.ErrorCodepouette;

import java.util.Set;

@Component
public final class ErrorCodeUtils {

    private Set<ErrorCodepouette> errorCodes;

    @Autowired
    private ErrorCodeUtils(Set<ErrorCodepouette> errorCodes){
        this.errorCodes = errorCodes;
    }

    public ErrorCode getDefaultErrorCode() {
        return TechnicalException.TechnicalCode.DEFAULT_ERROR_CODE;
    }

    public String getMessage(ErrorCode code){
        return errorCodes.stream()
                .filter(element -> element.getCode().equals(code.getErrorCode()))
                .findFirst().get().getMessage();

    }
}
