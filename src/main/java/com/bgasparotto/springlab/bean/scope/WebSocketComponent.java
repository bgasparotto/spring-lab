package com.bgasparotto.springlab.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebSocketComponent {
    private final Instant creationInstant = Instant.now();

    public Instant getCreationInstant() {
        return creationInstant;
    }
}
