package com.rcn.exceptin.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcn.exception.BaseException;
import com.rcn.exception.CustomException1;
import com.rcn.exception.CustomException2;

/**
 * @author ekansh
 * @since 19/2/16
 */
@RestController
@RequestMapping({"","/"})
public class HomeController {

    @RequestMapping("/ex1")
    public String ex1(){
        // will be catched by global exception handler method handleBaseException
        throw new BaseException("Base Exception");
    }

    @RequestMapping("/ex2")
    public String ex2(){
        // will be catched by global exception handler method handleBaseException
        throw new CustomException1();
    }

    @RequestMapping("/ex3")
    public String ex3(){
        // will be catched by global exception handler method handleBaseException
        throw new CustomException2();
    }

    @RequestMapping("/ex4")
    public String ex4(){
        // will be catched by global exception handler method handleException
        throw new NullPointerException("null pointer exception");
    }

    @RequestMapping("/ex5")
    public String ex5(){
        // will be catched by controller exception hnadler handler method nfeHandler
        throw new NumberFormatException("number format exception");
    }

    /**
     * This method will handle all the Number Format Exceptions that arise within this controller.
     *
     * */
    @ExceptionHandler(value = NumberFormatException.class)
    public String nfeHandler(NumberFormatException e){
        return e.getMessage();
    }

    public String someMethod() {
        try {
            // do some stuff here
            return "something";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @RequestMapping("/greet")
    String sayHello(@RequestParam("name") String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The 'name' parameter must not be null or empty");
        }
        return String.format("Hello %s!", name);
    }
}
