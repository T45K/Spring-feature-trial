package io.github.t45k.trials.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handle(final MethodArgumentNotValidException exception) {
        exception.getFieldErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .forEach(System.out::println);
    }
}
