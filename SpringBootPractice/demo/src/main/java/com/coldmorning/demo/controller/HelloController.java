package com.coldmorning.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.coldmorning.demo.controller.entity.Hello;


/**
 * HelloWorldController
 */
@RestController
@RequestMapping(value="/hello")
public class HelloController {

    @GetMapping(value="/{name}")
    public Hello sayHello(@PathVariable String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    
}