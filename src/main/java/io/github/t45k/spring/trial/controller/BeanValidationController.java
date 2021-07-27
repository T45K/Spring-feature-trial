package io.github.t45k.spring.trial.controller;

import io.github.t45k.spring.trial.request.BeanValidationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/bean")
@Slf4j
@RequiredArgsConstructor
public class BeanValidationController {
    private final Validator validator;

    @PostMapping("/bySpring")
    public Map<String, Boolean> validateBySpringBoot(@RequestBody @Validated final BeanValidationRequest request) {
        log.info("id1: " + request.getId1());
        log.info("id2: " + request.getId2());

        return Map.of("message", true);
    }

    @PostMapping("/byHibernate")
    public Map<String, Boolean> validateByHibernate(@RequestBody final BeanValidationRequest request) {
        log.info("id1: " + request.getId1());
        log.info("id2: " + request.getId2());

        final Set<ConstraintViolation<BeanValidationRequest>> violations = validator.validate(request);
        for (final ConstraintViolation<BeanValidationRequest> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
        }

        return Map.of("message", true);
    }
}
