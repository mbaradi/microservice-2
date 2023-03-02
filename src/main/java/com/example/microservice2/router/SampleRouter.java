package com.example.microservice2.router;

import com.example.microservice2.handler.SampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RequestPredicates;
@Configuration
public class SampleRouter {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(SampleHandler sampleHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/exampleHandler").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), sampleHandler::exampleHandler)
                .andRoute(RequestPredicates.POST("/greet").and(RequestPredicates.accept(MediaType.TEXT_EVENT_STREAM)), sampleHandler::greet);
    }
}

