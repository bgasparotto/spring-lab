package com.bgasparotto.springlab.bean.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.time.Instant;

@Component
@RequestScope
public class RequestComponent {
    private final Instant creationInstant = Instant.now();

    public Instant getCreationInstant() {
        return creationInstant;
    }
}
