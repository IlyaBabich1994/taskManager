package com.learning.crud.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
    @ExceptionHandler(value = Exception.class)
    public String error(HttpServletRequest req, Exception ex, Model model) throws Exception {
        System.out.println("ExceptionController");
        logger.info("Not found");
        ModelAndView modelAndView = new ModelAndView("error");
        if (AnnotationUtils.findAnnotation
                (ex.getClass(), ResponseStatus.class) != null)
            throw ex;
        modelAndView.addObject("exception", ex);
        return "error";
    }

}
