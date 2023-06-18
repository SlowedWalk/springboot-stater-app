package tech.hidetora.security.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.hidetora.security.dto.response.ErrorResponse;
import tech.hidetora.security.exception.AppUserException;
import tech.hidetora.security.exception.EntityNotFoundException;
import tech.hidetora.security.exception.InvalidEntityException;
import tech.hidetora.security.exception.InvalidOperationException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .code(exception.getErrorCode())
                .httpCode(httpStatus.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(AppUserException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(AppUserException exception, WebRequest webRequest) {
        final HttpStatus httpStatus = HttpStatus.valueOf(exception.getErrorCode().getCode());

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .code(exception.getErrorCode())
                .httpCode(exception.getErrorCode().getCode())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEntityException(InvalidEntityException exception, WebRequest webRequest) {
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .code(exception.getErrorCode())
                .httpCode(httpStatus.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEntityException(InvalidOperationException exception, WebRequest webRequest) {
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .code(exception.getErrorCode())
                .httpCode(httpStatus.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}


