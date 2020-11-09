package com.bgasparotto.springlab.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class PrototypeComponent {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
