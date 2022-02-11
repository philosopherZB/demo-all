package com.philosopherzb.secret.service.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author philosopherZB
 * @date 2022/1/5
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Function<Exception, String> messageExtractor = this::extractReadableMessage;

    @ExceptionHandler(RuntimeException.class)
    public String handleSystemException(Exception e) {
        log.error("service occurs runtime error,error={}", e);
        return e.getMessage();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public String handleArgumentException(Exception e) {
        return this.messageExtractor.apply(e);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public String handleException(ConstraintViolationException e) {
        Optional<ConstraintViolation<?>> optional = e.getConstraintViolations().stream().findFirst();
        return optional.isPresent() ? optional.get().getMessage() : "param error";
    }

    private String extractReadableMessage(Exception e) {
        log.error("param exception: ", e);
        BindingResult bindingResult;
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        } else {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }

        return Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
    }
}
