package com.bgasparotto.springlab.bean.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Component
@SessionScope
public class SessionComponent {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
