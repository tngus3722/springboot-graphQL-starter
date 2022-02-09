package com.musinsa.graphql.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.musinsa.graphql.enums.ErrorMessage;
import com.musinsa.graphql.util.exception.ExceptionParser;
import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"cause", "stackTrace", "message", "localizedMessage", "message", "suppressed"})
public class CustomGraphQLException extends RuntimeException implements GraphQLError {
    protected String className;
    protected String errorMessage;
    protected Integer code;
    protected String ErrorTrace;
    protected HttpStatus httpStatus;
    protected Boolean isCritical;

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return GraphQLError.super.getPath();
    }

    @Override
    public Map<String, Object> toSpecification() {
        return GraphQLError.super.toSpecification();
    }

    @Override
    public Map<String, Object> getExtensions() {
        CustomGraphQLException customGraphQLException = ExceptionParser.baseExceptionParser(this);
        Map<String, Object> errorMessageMap = new HashMap<>();
        errorMessageMap.put("className", customGraphQLException.className);
        errorMessageMap.put("errorMessage", customGraphQLException.errorMessage);
        errorMessageMap.put("code", customGraphQLException.code);
        errorMessageMap.put("isCritical", customGraphQLException.isCritical);
        errorMessageMap.put("classification", customGraphQLException.className);
        errorMessageMap.put("ErrorTrace", customGraphQLException.ErrorTrace);
        return errorMessageMap;
    }

    public CustomGraphQLException(ErrorMessage errorMessage, Boolean isCritical) { // 에러메시지만 온 경우
        this.className = this.getClass().getSimpleName();
        this.errorMessage = errorMessage.getErrorMessage();
        this.code = errorMessage.getCode();
        this.httpStatus = errorMessage.getHttpStatus();
        this.isCritical = isCritical;
    }

    public CustomGraphQLException(String className, ErrorMessage errorMessage, Boolean isCritical) { // 에러 메시지 + 클래스네임
        this.className = className;
        this.errorMessage = errorMessage.getErrorMessage();
        this.code = errorMessage.getCode();
        this.httpStatus = errorMessage.getHttpStatus();
        this.isCritical = isCritical;
    }

}