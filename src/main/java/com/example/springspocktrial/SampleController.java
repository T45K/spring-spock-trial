package com.example.springspocktrial;

import com.example.springspocktrial.duplicatedBean.ISampleService2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class SampleController {
    private final SampleService service;
    private final ISampleService2 service2;

    public SampleController(final SampleService service, final ISampleService2 service2) {
        this.service = service;
        this.service2 = service2;
    }

    @GetMapping()
    public String index() {
        return service.action();
    }
}
