package io.github.t45k.trials.controller;

import io.github.t45k.trials.request.BeanValidationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bean")
@Slf4j
@RequiredArgsConstructor
public class BeanValidationController {
    private final Validator validator;

    /**
     * Springの機能でバリデートする
     * MethodArgumentNotValidException が発生する
     */
    @PostMapping("/bySpring")
    public Map<String, Boolean> validateBySpringBoot(@RequestBody @Validated final BeanValidationRequest request) {
        log.info("id1: " + request.getId1());
        log.info("id2: " + request.getId2());

        return Map.of("message", true);
    }

    /**
     * Springの機能でバリデートする
     * 引数にエラー内容が入る
     */
    @PostMapping("/bySpring2")
    public Map<String, Boolean> validateBySpringBoot2(@RequestBody @Validated final BeanValidationRequest request,
                                                      final BindingResult errors) {
        log.info("id1: " + request.getId1());
        log.info("id2: " + request.getId2());

        System.out.println(
            errors.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("\n"))
        );

        return Map.of("message", true);
    }

    /**
     * Hibernate#validate でバリデートする
     */
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
