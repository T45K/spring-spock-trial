package com.example.springspocktrial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class SampleController {
    private final SampleService service;

    public SampleController(final SampleService service) {
        this.service = service;
    }

    @GetMapping()
    public String index() {
        return service.action();
    }
}
