package com.bgasparotto.springlab.bean.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@RequestScope
public class RequestComponent {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
