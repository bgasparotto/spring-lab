package com.bgasparotto.springlab.bean.scope;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class SingletonComponent {
    private final Instant creationInstant = Instant.now();

    public Instant getCreationInstant() {
        return creationInstant;
    }
}
