package com.musinsa.graphql.exception.staticException;

import com.musinsa.graphql.enums.ErrorMessage;
import com.musinsa.graphql.exception.CustomGraphQLException;

public class RequestInputException extends CustomGraphQLException {

    public RequestInputException(String className, ErrorMessage errorMessage, Boolean isCritical) {
        super(className, errorMessage, isCritical);
    }

    public RequestInputException(ErrorMessage errorMessage, Boolean isCritical) {
        super(errorMessage, isCritical);
    }
}
