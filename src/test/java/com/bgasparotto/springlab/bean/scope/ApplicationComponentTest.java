package com.bgasparotto.springlab.bean.scope;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationComponentTest extends WebAwareTest {

    @Test
    public void shouldInjectSameInstanceAcrossDifferentRequests() {
        String componentIdOne = getAndReturn("/test/scope/application");
        String componentIdTwo = getAndReturn("/test/scope/application");

        assertThat(componentIdOne).isEqualTo(componentIdTwo);
    }
}
