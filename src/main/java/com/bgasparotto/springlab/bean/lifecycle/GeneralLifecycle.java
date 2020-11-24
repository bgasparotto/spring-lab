package com.bgasparotto.springlab.bean.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Queue;

/**
 * You would not want to mix up JSR-250 annotations with Initializing/Disposable Bean in real-life, but this is for the
 * sake of the experiment.
 */
public class GeneralLifecycle implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {
    private final Queue<String> lifecycleEvents;

    public GeneralLifecycle(Queue<String> lifecycleEvents) {
        this.lifecycleEvents = lifecycleEvents;
        lifecycleEvents.offer("Constructor");
    }

    @Override
    public void setBeanName(String name) {
        lifecycleEvents.offer("BeanNameAware setBeanName(String)");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        lifecycleEvents.offer("ApplicationContextAware setApplicationContext(...)");
    }

    @PostConstruct
    private void postConstruct() {
        lifecycleEvents.offer("@PostConstruct postConstruct()");
    }

    @Override
    public void afterPropertiesSet() {
        lifecycleEvents.offer("InitializingBean afterPropertiesSet()");
    }

    public void logIt() {
        lifecycleEvents.offer("logIt()");
    }

    @PreDestroy
    private void preDestroy() {
        lifecycleEvents.offer("@PreDestroy preDestroy()");
    }

    @Override
    public void destroy() {
        lifecycleEvents.offer("DisposableBean destroy()");
    }
}
