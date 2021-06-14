package io.github.t45k.spring.trial.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class BiggerImpl implements ConstraintValidator<Bigger, Object> {

    private String min;
    private String max;

    @Override
    public void initialize(final Bigger constraintAnnotation) {
        // ConstraintValidator.super.initialize(constraintAnnotation);
        log.info("initialized");
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        log.info("validation");
        final BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        final int id1 = (int) beanWrapper.getPropertyValue(min);
        final int id2 = (int) beanWrapper.getPropertyValue(max);
        if (id1 < id2) {
            System.out.println(id1);
            System.out.println(id2);
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("hoge").addConstraintViolation();
        return false;
    }
}
