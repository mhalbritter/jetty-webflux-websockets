package com.example.jettywebflux;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class MyWebSocketHandler implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<WebSocketMessage> stream = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(element -> session.textMessage(Integer.toString(element)))
                .delayElements(Duration.ofMillis(100));
        return session.send(stream);
    }
}
