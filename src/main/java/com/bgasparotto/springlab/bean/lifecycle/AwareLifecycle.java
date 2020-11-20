package com.bgasparotto.springlab.bean.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Queue;

public class AwareLifecycle implements BeanNameAware, ApplicationContextAware {
    private final Queue<String> lifecycleEvents;

    public AwareLifecycle(Queue<String> lifecycleEvents) {
        this.lifecycleEvents = lifecycleEvents;
        lifecycleEvents.add("Constructor");
    }

    @Override
    public void setBeanName(String name) {
        lifecycleEvents.add("BeanNameAware setBeanName(String)");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        lifecycleEvents.add("ApplicationContextAware setApplicationContext(...)");
    }

    public void logIt() {
        lifecycleEvents.add("logIt()");
    }
}
