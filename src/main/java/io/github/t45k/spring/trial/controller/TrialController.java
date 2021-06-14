package io.github.t45k.spring.trial.controller;

import io.github.t45k.spring.trial.request.Request;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TrialController {

    @PostMapping
    public Map<String, Boolean> index(@RequestBody @Validated Request request) {
        System.out.println(request.getId1());
        System.out.println(request.getId2());
        return Map.of("success", true);
    }
}
