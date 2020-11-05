package com.bgasparotto.springlab.bean.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.Instant;

@Component
@ApplicationScope
public class ApplicationComponent {
    private final Instant creationInstant = Instant.now();

    public Instant getCreationInstant() {
        return creationInstant;
    }
}
