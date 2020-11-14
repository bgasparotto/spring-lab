package com.bgasparotto.springlab.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Queue;

public class Jsr250Lifecycle {
    private final Queue<String> lifecycleEvents;

    public Jsr250Lifecycle(Queue<String> lifecycleEvents) {
        this.lifecycleEvents = lifecycleEvents;
        lifecycleEvents.add("Constructor");
    }

    @PostConstruct
    private void init() {
        lifecycleEvents.add("@PostConstruct init()");
    }

    public void logIt() {
        lifecycleEvents.add("logIt()");
    }

    @PreDestroy
    private void destroy() {
        lifecycleEvents.add("@PreDestroy destroy()");
    }
}
