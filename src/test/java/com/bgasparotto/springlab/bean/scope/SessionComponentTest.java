package com.bgasparotto.springlab.bean.scope;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;

import static org.assertj.core.api.Assertions.assertThat;

public class SessionComponentTest extends WebAwareTest {
    private MockHttpSession sessionOne;
    private MockHttpSession sessionTwo;

    @BeforeEach
    public void setUp() {
        sessionOne = new MockHttpSession();
        sessionTwo = new MockHttpSession();
    }

    @Test
    public void shouldInjectSameInstanceWhenSessionIsTheSame() {
        String componentIdOne = getAndReturn("/test/scope/session", sessionOne);
        String componentIdTwo = getAndReturn("/test/scope/session", sessionOne);

        assertThat(componentIdOne).isEqualTo(componentIdTwo);
    }

    @Test
    public void shouldInjectDifferentInstanceWhenSessionIsDifferent() {
        String componentIdOne = getAndReturn("/test/scope/session", sessionOne);
        String componentIdTwo = getAndReturn("/test/scope/session", sessionTwo);

        assertThat(componentIdOne).isNotEqualTo(componentIdTwo);
    }
}
