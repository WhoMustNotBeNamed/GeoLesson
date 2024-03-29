package ru.hse.coursework.geolesson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AppControllerAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllExceptions(Exception ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", ex.getMessage());
        return model;
    }
}