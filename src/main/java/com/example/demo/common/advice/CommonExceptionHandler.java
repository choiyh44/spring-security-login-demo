package com.example.demo.common.advice;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.common.exception.CommonException;
import com.example.demo.common.model.ResponseErrorVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@EnableWebMvc
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<Object> handleCommonException(CommonException commonException, WebRequest webRequest) {
        return handleExceptionInternal(commonException, commonException.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("{}", ex);
        if (Objects.isNull(body)) body = ex.getMessage();

        ResponseErrorVo responseErrorVo = null;
        responseErrorVo = new ResponseErrorVo(LocalDateTime.now(), body);
        return super.handleExceptionInternal(ex, responseErrorVo, headers, status, request);
    }

}
