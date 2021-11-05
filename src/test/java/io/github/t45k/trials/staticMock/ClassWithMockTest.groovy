package io.github.t45k.trials.staticMock

import spock.lang.Specification

import java.time.LocalDateTime

class ClassWithMockTest extends Specification {

    def 'test'() {
        given:
        GroovyMock(LocalDateTime, global: true)
        LocalDateTime.now() >> LocalDateTime.of(0, 0, 0, 0, 0)
        def sut = new ClassWithMock()

        expect:
        sut.now() == LocalDateTime.of(0, 0, 0, 0, 0)
    }
}
