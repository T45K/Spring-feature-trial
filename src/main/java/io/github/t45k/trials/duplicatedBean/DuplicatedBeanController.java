package io.github.t45k.trials.duplicatedBean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/duplicatedBean")
@RequiredArgsConstructor
public class DuplicatedBeanController {
    private final IDuplicatedBeanService service1;
}
