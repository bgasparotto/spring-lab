package com.bgasparotto.springlab.bean.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.UUID;

@Component
@ApplicationScope
public class ApplicationComponent {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
