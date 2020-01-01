package com.springlp.recipeapp.contrllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handlerNumberFormat (Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400BadRequest");
        modelAndView.addObject("exception",exception);

        return modelAndView;
    }
}
