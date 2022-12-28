package com.arnav.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Mark it as REST API
@RestController
public class HelloWorldController {


    //map request to url /hello-World
    @GetMapping("/hello-world")
    public String helloWorld(){
        //return hello world string
        return "Hello World!!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        //return hello world string
        return new HelloWorldBean("Hello World!!");
    }

    //rest api to accept path parameters
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        //return hello world string
        return new HelloWorldBean(String.format("Hello %s",name));
    }

}
