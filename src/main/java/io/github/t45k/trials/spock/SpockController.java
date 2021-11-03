package io.github.t45k.trials.spock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spock")
@RequiredArgsConstructor
public class SpockController {
    private final SpockService service;

    @GetMapping
    public String index() {
        return service.action();
    }
}
