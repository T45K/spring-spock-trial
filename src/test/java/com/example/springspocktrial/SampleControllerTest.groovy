package com.example.springspocktrial

import org.junit.Test
import org.junit.runner.RunWith
import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

@SpringBootTest
@RunWith(SpringRunner)
@ContextConfiguration
class SampleControllerTest extends Specification {

    @SpringSpy
    SampleService service

    @Autowired
    SampleController sut

    @Test
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

    @Test
    def "test with manual DI"() {
        given:
        def service = Spy(SampleService)
        def sut = new SampleController(service)
        service.action() >> "good bye" // 不要

        when:
        def result = sut.index()

        then:
        // 手動で用意しても同じ結果らしい
        // Mockとかやと違う感じかな？
        1 * service.action() >> "good bye"
        result == "good bye"
    }

    @Test
    def "test with manual DI and mock"() {
        given:
        def service = Mock(SampleService)
        service.action() >> "good bye" // 不要
        def sut = new SampleController(service)

        when:
        def result = sut.index()

        then:
        // モックでも同様にここで戻り値を定義する
        1 * service.action() >> "good bye"
        result == "good bye"
    }
}
