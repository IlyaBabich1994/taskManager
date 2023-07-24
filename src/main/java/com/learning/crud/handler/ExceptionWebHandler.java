package com.learning.crud.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionWebHandler {
    private final Logger logger = LoggerFactory.getLogger(ExceptionWebHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView error(HttpServletRequest req, Exception ex) throws Exception {
        logger.info("Not found");
        ModelAndView modelAndView = new ModelAndView("error");
        if (AnnotationUtils.findAnnotation
                (ex.getClass(), ResponseStatus.class) != null) {
            logger.info("Exception: " + ex);
            System.out.println("Exception: " + ex);
            throw ex;
        }
        modelAndView.addObject("exception", ex);

        logger.info("Request: " + req.getRequestURL() + " raised " + ex);
        modelAndView.addObject("title", "Page Not Found");
        modelAndView.addObject("url", req.getRequestURL());
        return modelAndView;
    }
}
