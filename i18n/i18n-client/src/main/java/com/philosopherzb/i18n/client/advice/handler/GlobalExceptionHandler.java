package com.philosopherzb.i18n.client.advice.handler;

import com.philosopherzb.i18n.client.advice.ecxeption.BizErrorCode;
import com.philosopherzb.i18n.client.advice.result.Result;
import com.philosopherzb.i18n.client.advice.result.ResultUtils;
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
    public Result<String> handleSystemException(Exception e) {
        log.error("service occurs runtime error: ", e);
        return ResultUtils.failResult(BizErrorCode.SYSTEM_BUSY);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Result<String> handleArgumentException(Exception e) {
        String msg = this.messageExtractor.apply(e);
        return ResultUtils.failResult(BizErrorCode.PARAM_VALID_EXCEPTION.getCode(), msg);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public Result<String> handleException(ConstraintViolationException e) {
        log.error("param exception: ", e);
        Optional<ConstraintViolation<?>> optional = e.getConstraintViolations().stream().findFirst();
        String msg = optional.isPresent() ? optional.get().getMessage() : BizErrorCode.PARAM_VALID_EXCEPTION.getErrorMessage();
        return ResultUtils.failResult(BizErrorCode.PARAM_VALID_EXCEPTION.getCode(), msg);
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
