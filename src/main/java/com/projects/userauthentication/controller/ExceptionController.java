package com.projects.userauthentication.controller;

import com.projects.userauthentication.errorHandler.ApiError;
import com.projects.userauthentication.errorHandler.ApiException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
    private static final String UNIT_OF_WORK_HEADER = "X-UOW";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnknownException(HttpServletRequest request, Exception ex) {
        Integer code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = stackTrace(ex);

        ApiError body = new ApiError(code, message);
        body.setCode(code);
        body.setMessage(message);
        body.setTracking(this.extractUnitOfWork(request));
        injectStacktraceIfDebugging(request.getParameter("d"), ex, body);
        LOGGER.error(message, ex);

        return new ResponseEntity<>(body, HttpStatus.valueOf(code));
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleApiException(HttpServletRequest request, ApiException ex) {

        String message = ex.getMessage() != null ? ex.getMessage() : ex.toString();

        ApiError body = new ApiError();
        body.setCode(ex.getCode());
        body.setMessage(message);
        body.setCauses(ex.getCauses());
        body.setTracking(this.extractUnitOfWork(request));

        this.injectStacktraceIfDebugging(request.getParameter("d"), ex, body);

        LOGGER.warn(message, ex);

        MultiValueMap<String, String> headers = null;
        if (ex.getHttpResponseHeaders() != null) {
            headers = new HttpHeaders();
            headers.putAll(ex.getHttpResponseHeaders());
        }
        return new ResponseEntity<>(body, headers, HttpStatus.valueOf(ex.getHttpStatusCode()));
    }

    private String stackTrace(Exception ex) {
        return ExceptionUtils.getStackTrace(ex);
    }

    private String extractUnitOfWork(HttpServletRequest httpRequest) {
        String currentUowValue = httpRequest.getHeader(UNIT_OF_WORK_HEADER);
        if (currentUowValue == null || "".equals(currentUowValue)) {
            LOGGER.debug("No UOW received");
            return null;
        } else {
            LOGGER.debug("UOW received: " + currentUowValue);
            return currentUowValue;
        }
    }

    private void injectStacktraceIfDebugging(String debugParameterValue, Exception ex, ApiError body) {
        if (debugParameterValue != null && "1".equals(debugParameterValue)) {
            StringWriter w = new StringWriter();
            PrintWriter writer = new PrintWriter(w);
            ex.printStackTrace(writer);
            String stacktrace = w.toString();

            body.setStacktrace(stacktrace);
        }
    }
}
