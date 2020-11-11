package com.bgasparotto.springlab.bean.scope;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestComponentTest extends WebAwareTest {

    @Test
    public void shouldInjectDifferentInstancesPerRequest() {
        String componentIdOne = getAndReturn("/test/scope/request");
        String componentIdTwo = getAndReturn("/test/scope/request");

        assertThat(componentIdOne).isNotEqualTo(componentIdTwo);
    }
}
