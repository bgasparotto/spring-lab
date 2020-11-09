package com.bgasparotto.springlab.bean.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = PrototypeComponent.class)
public class PrototypeComponentTest {

    @Autowired
    private PrototypeComponent componentOne;

    @Autowired
    private PrototypeComponent componentTwo;

    @Test
    public void shouldInjectSameInstanceForBothComponents() {
        assertThat(componentOne == componentTwo).isFalse();
        assertThat(componentOne.getId()).isNotEqualTo(componentTwo.getId());
    }
}
