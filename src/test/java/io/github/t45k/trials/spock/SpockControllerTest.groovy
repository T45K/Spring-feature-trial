package io.github.t45k.trials.spock


import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
class SpockControllerTest extends Specification {

    @SpringSpy
    SpockService service

    @Autowired
    SpockController sut

    def "test with auto DI"() {
        given:
        service.action() >> "good bye" // 不要

        when:
        def result = sut.index()

        then:
        // 回数を確認する際に戻り値を書かんとあかんらしい
        // （書かないと元のメソッドが呼ばれる）
        // どういう仕様？
        // 逆にここで戻り値を書いたらgivenで定義しなくても良い
        1 * service.action() >> "good bye"
        result == "good bye"
    }

    def "test with manual DI"() {
        given:
        def service = Spy(SpockService)
        def sut = new SpockController(service)
        service.action() >> "good bye" // 不要

        when:
        def result = sut.index()

        then:
        // 手動で用意しても同じ結果らしい
        // Mockとかやと違う感じかな？
        1 * service.action() >> "good bye"
        result == "good bye"
    }

    def "test with manual DI and mock"() {
        given:
        def service = Mock(SpockService)
        service.action() >> "good bye" // 不要
        def sut = new SpockController(service)

        when:
        def result = sut.index()

        then:
        // モックでも同様にここで戻り値を定義する
        1 * service.action() >> "good bye"
        result == "good bye"
    }
}
