package io.github.t45k.spring.trial.controller;

import io.github.t45k.spring.trial.annotation.Bigger;
import io.github.t45k.spring.trial.request.Request;
import lombok.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

    /*
    Check request param
     */
    @GetMapping
    public Map<String, Boolean> index(@Validated final RequestParams params) {
        System.out.println(params.getMin());
        System.out.println(params.getMax());
        return Map.of("success", true);
    }

    @Value
    @Bigger(max = "max", min = "min")
    private static class RequestParams {
        int min;
        int max;
    }
}
