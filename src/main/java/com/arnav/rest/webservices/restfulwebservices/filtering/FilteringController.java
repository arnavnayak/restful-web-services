package com.arnav.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value 1","value 2","value 3");
    }

    @GetMapping("/filtering_list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("value 1","value 2","value 3"),
                new SomeBean("value 4","value 5","value 6"));
    }
}
