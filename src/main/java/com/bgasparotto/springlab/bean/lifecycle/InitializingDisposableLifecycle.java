package com.bgasparotto.springlab.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Queue;

public class InitializingDisposableLifecycle implements InitializingBean, DisposableBean {
    private final Queue<String> lifecycleEvents;

    public InitializingDisposableLifecycle(Queue<String> lifecycleEvents) {
        this.lifecycleEvents = lifecycleEvents;
        lifecycleEvents.add("Constructor");
    }

    @Override
    public void afterPropertiesSet() {
        lifecycleEvents.add("InitializingBean afterPropertiesSet()");
    }

    public void logIt() {
        lifecycleEvents.add("logIt()");
    }

    @Override
    public void destroy() {
        lifecycleEvents.add("DisposableBean destroy()");
    }
}
