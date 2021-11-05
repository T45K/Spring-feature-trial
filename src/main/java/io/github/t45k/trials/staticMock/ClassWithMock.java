package io.github.t45k.trials.staticMock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class ClassWithMock {
    private static final Logger logger = LoggerFactory.getLogger(ClassWithMock.class);

    public LocalDateTime now() {
        final LocalDateTime now = LocalDateTime.now();
        logger.info(now.toString());
        return now;
    }
}
