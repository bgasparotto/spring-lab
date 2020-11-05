package com.bgasparotto.springlab.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Scope("prototype")
public class PrototypeComponent {
    private final Instant creationInstant = Instant.now();

    public Instant getCreationInstant() {
        return creationInstant;
    }
}
