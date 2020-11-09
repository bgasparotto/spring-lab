package com.bgasparotto.springlab.bean.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SingletonComponent.class)
public class SingletonComponentTest {

    @Autowired
    private SingletonComponent componentOne;

    @Autowired
    private SingletonComponent componentTwo;

    @Test
    public void shouldInjectSameInstanceForBothComponents() {
        assertThat(componentOne == componentTwo).isTrue();
        assertThat(componentOne.getId()).isEqualTo(componentTwo.getId());
    }
}
