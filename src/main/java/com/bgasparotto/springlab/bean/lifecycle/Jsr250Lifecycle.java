package com.bgasparotto.springlab.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Queue;

public class Jsr250Lifecycle {
    private final Queue<String> lifecycleEvents;

    public Jsr250Lifecycle(Queue<String> lifecycleEvents) {
        this.lifecycleEvents = lifecycleEvents;
        lifecycleEvents.offer("Constructor");
    }

    @PostConstruct
    private void init() {
        lifecycleEvents.offer("@PostConstruct init()");
    }

    public void logIt() {
        lifecycleEvents.offer("logIt()");
    }

    @PreDestroy
    private void destroy() {
        lifecycleEvents.offer("@PreDestroy destroy()");
    }
}
