package com.bgasparotto.springlab.bean.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class Jsr250LifecycleTest {
    private static final Queue<String> lifecycleEvents = new LinkedList<>();

    @Autowired
    private Jsr250Lifecycle jsr250Lifecycle;

    @Test
    public void interact() {
        jsr250Lifecycle.logIt();
    }

    @AfterAll
    public static void verifyLifecycleEvents() {
        assertThat(lifecycleEvents.poll()).isEqualTo("Constructor");
        assertThat(lifecycleEvents.poll()).isEqualTo("@PostConstruct init()");
        assertThat(lifecycleEvents.poll()).isEqualTo("logIt()");
        assertThat(lifecycleEvents.poll()).isEqualTo("@PreDestroy destroy()");
        assertThat(lifecycleEvents).isEmpty();
    }

    @Configuration
    static class Config {

        @Bean
        Jsr250Lifecycle beanUnderTest() {
            return new Jsr250Lifecycle(lifecycleEvents);
        }
    }
}
