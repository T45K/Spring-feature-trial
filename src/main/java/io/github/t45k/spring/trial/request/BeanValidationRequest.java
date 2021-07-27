package io.github.t45k.spring.trial.request;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class BeanValidationRequest {

    @NotNull
    Integer id1;

    @NotNull
    Integer id2;

    public BeanValidationRequest() {
        this.id1 = null;
        this.id2 = null;
    }
}
