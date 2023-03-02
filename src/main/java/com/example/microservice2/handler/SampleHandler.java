package com.example.microservice2.handler;

import org.springframework.stereotype.Component;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.*;
@Component
public class SampleHandler {
    public Mono<ServerResponse> exampleHandler(ServerRequest request) {
        /* return ServerResponse.ok()
                .body(BodyInserters.fromObject("Hello, Spring WebFlux Sample!")); */

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(
                        Flux.just("This ", "is a ", "sample application")
                                .delayElements(Duration.ofSeconds(1)), String.class
                );
    }

    public Mono<ServerResponse> greet(ServerRequest request) {

        Mono<String> name = request.bodyToMono(String.class);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(
                        name.map(x->"Hello "+ x), String.class
                );
    }
}