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
public class AwareLifecycleTest {
    private static final Queue<String> lifecycleEvents = new LinkedList<>();

    @Autowired
    private AwareLifecycle awareLifecycle;

    @Test
    public void interact() {
        awareLifecycle.logIt();
    }

    @AfterAll
    public static void verifyLifecycleEvents() {
        assertThat(lifecycleEvents.poll()).isEqualTo("Constructor");
        assertThat(lifecycleEvents.poll()).isEqualTo("BeanNameAware setBeanName(String)");
        assertThat(lifecycleEvents.poll()).isEqualTo("ApplicationContextAware setApplicationContext(...)");
        assertThat(lifecycleEvents.poll()).isEqualTo("logIt()");
        assertThat(lifecycleEvents).isEmpty();
    }

    @Configuration
    static class Config {

        @Bean
        AwareLifecycle beanUnderTest() {
            return new AwareLifecycle(lifecycleEvents);
        }
    }
}
