package io.github.t45k.spring.trial.request;

import io.github.t45k.spring.trial.annotation.Bigger;
import lombok.Value;

@Value
@Bigger(min = "id1", max = "id2")
public class Request {
    int id1;
    int id2;
}
