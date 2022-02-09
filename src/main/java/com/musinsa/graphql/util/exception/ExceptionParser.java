package com.musinsa.graphql.util.exception;

import com.musinsa.graphql.enums.ErrorMessage;
import com.musinsa.graphql.exception.CustomGraphQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Component
public class ExceptionParser {

    public static CustomGraphQLException baseExceptionParser(Throwable e){
        CustomGraphQLException customGraphQLException = null;

        if (e instanceof CustomGraphQLException) {
            ((CustomGraphQLException) e).setErrorTrace(e.getStackTrace()[0].toString());
            customGraphQLException = (CustomGraphQLException) e;
        }

        // validation exception
        if (e instanceof MethodArgumentNotValidException) {
            customGraphQLException = new CustomGraphQLException(e.getClass().getSimpleName(), ErrorMessage.VALIDATION_FAIL_EXCEPTION, true);
            List<ObjectError> messageList = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            String message = "";
            for (int i = 0; i < messageList.size(); i++) {
                String validationMessage = messageList.get(i).getDefaultMessage();
                message += "[" + validationMessage + "]";
            }
            customGraphQLException.setErrorMessage(message);
            customGraphQLException.setErrorTrace(e.getStackTrace()[0].toString());
        }

        // unhandled Exception
        if (customGraphQLException == null) {
            customGraphQLException = new CustomGraphQLException(e.getClass().getSimpleName(), ErrorMessage.UNDEFINED_EXCEPTION, true);
            customGraphQLException.setErrorMessage(e.getMessage());
            customGraphQLException.setErrorTrace(e.getStackTrace()[0].toString());
        }

        if (customGraphQLException.getIsCritical())
            ; // TODO notify some messanger

        return customGraphQLException;
    }
}
