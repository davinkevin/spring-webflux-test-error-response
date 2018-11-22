package com.github.davinkevin.springwebfluxtesterrorresponse

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Configuration
class FooRouter(val foo: FooHandler) {

    fun routes() = router {
        "/api/v1/foo".nest {
            GET("/", foo::findAll)
        }
    }
}

@Service
class FooHandler {

    fun findAll(request: ServerRequest) =
            Mono.empty<ServerResponse>()
                    .switchIfEmpty(ResponseStatusException(HttpStatus.NOT_FOUND, "No Foo found").toMono())

}