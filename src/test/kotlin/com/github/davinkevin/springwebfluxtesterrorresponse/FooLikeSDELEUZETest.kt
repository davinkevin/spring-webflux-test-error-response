package com.github.davinkevin.springwebfluxtesterrorresponse

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
@Import(FooRouter::class)
@ExtendWith(SpringExtension::class)
class FooLikeSDELEUZETest {

    @Autowired lateinit var rest: WebTestClient

    @Test
    fun `should check response`() {
        rest
                .get()
                .uri("/api/v1/foo")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                /* Then */
                .isNotFound
                .expectBody()
                .jsonPath("$.message")
                .isEqualTo("No Foo found")
    }

}

@WebFluxTest(controllers = [(FooHandler::class)])
@AutoConfigureWebTestClient
@AutoConfigureJson
@Import(FooRouter::class)
class FooLikeUsTest {

    @Autowired lateinit var rest: WebTestClient

    @Test
    fun `should check response`() {
        rest
                .get()
                .uri("/api/v1/foo")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                /* Then */
                .isNotFound
                .expectBody()
                .jsonPath("$.message")
                .isEqualTo("No Foo found")
    }

}