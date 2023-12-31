package dev.lecture.sec03_04.a_spring_framework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping(value = "/some-api")
    public void someApi() {
        service.createArticle("의미 없는 데이터");
    }
}
