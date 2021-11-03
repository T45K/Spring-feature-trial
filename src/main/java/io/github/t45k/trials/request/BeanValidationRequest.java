package io.github.t45k.trials.request;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class BeanValidationRequest {

    @NotNull(message = "id1 is not null")
    Integer id1;

    @NotNull
    Integer id2;

    public BeanValidationRequest() {
        this.id1 = null;
        this.id2 = null;
    }
}
