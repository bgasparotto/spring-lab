package com.bgasparotto.springlab.bean.scope;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SingletonComponent {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
